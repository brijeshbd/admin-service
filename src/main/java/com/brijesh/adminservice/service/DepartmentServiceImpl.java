package com.brijesh.adminservice.service;

import com.brijesh.adminservice.dao.AdminDao;
import com.brijesh.adminservice.dao.DepartmentDao;
import com.brijesh.adminservice.dao.UniversityDao;
import com.brijesh.adminservice.exception.AdminException;
import com.brijesh.adminservice.model.entity.Admin;
import com.brijesh.adminservice.model.entity.Department;
import com.brijesh.adminservice.model.entity.University;
import com.brijesh.adminservice.model.request.DepartmentRequest;
import com.brijesh.adminservice.model.response.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    AdminDao adminDao;

    @Autowired
    UniversityDao universityDao;

    @CacheEvict(value = {"course", "department"}, allEntries = true)
    @Override
    public DepartmentResponse saveDepartment(DepartmentRequest departmentRequest) {
        DepartmentResponse departmentResponse;
        String email = departmentRequest.getAdminEmail();
        Admin admin = adminDao.findByAdminEmail(email);
        System.out.println(admin.toString());
        University university = universityDao.findByUniversityName(departmentRequest.getUniversityName());
        if(admin==null || university==null)
        {
            throw new RuntimeException("User/ University is not Present ...");
        }
        Department department = new Department();
        department.setDepartmentName(departmentRequest.getDepartmentName());
        department.setCity(departmentRequest.getCity());
        department.setAdminId(admin.getAdminId());
        department.setUniversityId(university.getUniversityId());
        Department savedDepartment = departmentDao.save(department);
        if(savedDepartment == null) {
            throw new AdminException("Department is not Saved...");
        }
        departmentResponse = new DepartmentResponse("D"+savedDepartment.getDepartmentId(),savedDepartment.getDepartmentName(), savedDepartment.getCity(), university.getUniversityName(), admin.getAdminEmail());
        return departmentResponse;
    }

    @Cacheable(value = "department", key = "#adminId")
    @Override
    public List<DepartmentResponse> getDepartmentByAdminId(Long adminId) {
        List<Department> departmentList = departmentDao.findByAdminId(adminId);
        Admin a = adminDao.getById(adminId);
        List<DepartmentResponse> responses = new ArrayList<>();
        if(departmentList!=null && !departmentList.isEmpty()){
            for(Department d : departmentList){
                University u = universityDao.getById(d.getUniversityId());
                DepartmentResponse departmentResponse = new DepartmentResponse("D"+d.getDepartmentId(),d.getDepartmentName(), d.getCity(), u.getUniversityName(), a.getAdminEmail());
                responses.add(departmentResponse);
            }
        }
        return responses;
    }

    @CachePut(value = "department", key = "#adminId")
    @Override
    public DepartmentResponse updateDepartment(Long adminId, Long departmentId, DepartmentRequest departmentRequest) {
        DepartmentResponse departmentResponse;
        Department findDepartment = departmentDao.getById(departmentId);
        Admin admin = adminDao.getById(adminId);
        University university = universityDao.findByUniversityName(departmentRequest.getUniversityName());
        if(!Objects.equals(findDepartment.getAdminId(), adminId)){
            throw new AdminException("You are not valid Admin to do this action..");
        }
        if(departmentRequest.getDepartmentName()!=null) findDepartment.setDepartmentName(departmentRequest.getDepartmentName());
        if(departmentRequest.getCity()!=null) findDepartment.setCity(departmentRequest.getCity());
        if(departmentRequest.getUniversityName()!=null) findDepartment.setUniversityId(university.getUniversityId());

        Department savedDepartment = departmentDao.save(findDepartment);
        String universityName = null;
        if(university==null){
            universityName = universityDao.getById(findDepartment.getUniversityId()).getUniversityName();
        } else {
            universityName = university.getUniversityName();
        }
        departmentResponse = new DepartmentResponse("D"+savedDepartment.getDepartmentId(), savedDepartment.getDepartmentName(), savedDepartment.getCity(), universityName, admin.getAdminEmail());
        return departmentResponse;
    }

    @CacheEvict(value = "department", allEntries = true)
    @Override
    public void deleteDepartment(Long adminId, Long departmentId) {
        Admin a = adminDao.getById(adminId);
        Department d = departmentDao.getById(departmentId);
        if(a==null || a.getAdminId() != d.getAdminId()){
            throw new AdminException("You are not valid Admin...");
        }
        departmentDao.delete(d);
    }
}
