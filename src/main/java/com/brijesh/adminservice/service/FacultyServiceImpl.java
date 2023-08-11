package com.brijesh.adminservice.service;

import com.brijesh.adminservice.dao.AdminDao;
import com.brijesh.adminservice.dao.DepartmentDao;
import com.brijesh.adminservice.dao.FacultyDao;
import com.brijesh.adminservice.exception.AdminException;
import com.brijesh.adminservice.model.entity.Admin;
import com.brijesh.adminservice.model.entity.Department;
import com.brijesh.adminservice.model.entity.Faculty;
import com.brijesh.adminservice.model.request.FacultyRequest;
import com.brijesh.adminservice.model.response.FacultyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private AdminDao adminDao;

    @CacheEvict(value = "faculty", allEntries = true)
    @Override
    public FacultyResponse saveFaculty(Long adminId, FacultyRequest facultyRequest) {

        Admin admin = adminDao.getById(adminId);
        Department department = departmentDao.getById(facultyRequest.getDepartmentId());
        if(!Objects.equals(department.getAdminId(), adminId))
            throw new AdminException("Admin Is not Valid..");

        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyRequest.getFacultyName());
        faculty.setFacultyEmail(facultyRequest.getFacultyEmail());
        faculty.setFacultyPassword(facultyRequest.getFacultyPassword());
        faculty.setAdminId(adminId);
        faculty.setDesignation(facultyRequest.getDesignation());
        faculty.setDepartmentId(department.getDepartmentId());
        Faculty savedFaculty = facultyDao.save(faculty);
        return new FacultyResponse("F"+savedFaculty.getFacultyId(), savedFaculty.getFacultyName(), savedFaculty.getFacultyEmail(), savedFaculty.getFacultyPassword(), admin.getAdminEmail(), savedFaculty.getDesignation(), department.getDepartmentName());
    }

    @Cacheable(value = "faculty", key = "#adminId")
    @Override
    public List<FacultyResponse> getFacultyByAdminId(Long adminId) {
//        log.info("Getting All faculties by Admin Id...");
        System.out.println("Getting All Faculties by Admin Id");
        List<FacultyResponse> facultyResponseList = new ArrayList<>();
        Admin a = adminDao.getById(adminId);
        List<Faculty> faculties = facultyDao.findByAdminId(adminId);
        if(faculties==null)
            throw new AdminException("There is no Faculty for this Admin...");
        for(Faculty f : faculties){
            try {
                Department d = departmentDao.getById(f.getDepartmentId());
                FacultyResponse facultyResponse = new FacultyResponse("F" + f.getFacultyId(), f.getFacultyName(), f.getFacultyEmail(), f.getFacultyPassword(), a.getAdminEmail(), f.getDesignation(), d.getDepartmentName());
                facultyResponseList.add(facultyResponse);
            }catch (Exception e){
                System.out.println("Error while getting faculties...");
            }
        }

        return facultyResponseList;
    }

    @CacheEvict(value = "faculty", allEntries = true)
    @Override
    public void deleteFaculty(Long facultyId, Long adminId) {
        Faculty faculty = facultyDao.getById(facultyId);
        if(faculty == null) throw new AdminException("Faculty not found....");
        if(!Objects.equals(faculty.getAdminId(), adminId))
            throw new AdminException("Admin is not valid for delete");
        facultyDao.delete(faculty);
    }
}
