package com.brijesh.adminservice.service;

import com.brijesh.adminservice.dao.AdminDao;
import com.brijesh.adminservice.exception.AdminException;
import com.brijesh.adminservice.model.entity.Admin;
import com.brijesh.adminservice.model.request.AdminRequest;
import com.brijesh.adminservice.model.response.AdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{


    @Autowired
    private AdminDao adminDao;

    @CacheEvict(value = "admin", allEntries = true)
    @Override
    public AdminResponse saveAdmin(AdminRequest adminRequest) {
        AdminResponse response = new AdminResponse();
        try {
            Admin admin = new Admin();
            admin.setAdminName(adminRequest.getAdminName());
            admin.setAdminEmail(adminRequest.getAdminEmail());
            admin.setAdminPassword(adminRequest.getAdminPassword());
            Admin savedAdmin = adminDao.save(admin);
            if(savedAdmin != null) {
                response.setAdminCode("A"+savedAdmin.getAdminId());
                response.setAdminName(savedAdmin.getAdminName());
                response.setAdminEmail(savedAdmin.getAdminEmail());
            }

        } catch (Exception e){
            System.out.println(e);
        }

        return response;
    }

    @Cacheable(value = "admin", key = "#adminId")
    @Override
    public AdminResponse getAdminById(Long adminId) {
        AdminResponse adminResponse = new AdminResponse();
        try {
            Admin admin = adminDao.getById(adminId);
            if (admin != null) {
                adminResponse.setAdminCode("A" + admin.getAdminId());
                adminResponse.setAdminName(admin.getAdminName());
                adminResponse.setAdminEmail(admin.getAdminEmail());
            }
        } catch (Exception e) {
            System.out.println("Id is not found " + e);
            throw new AdminException("User Not Found...");
        }
        return adminResponse;
    }
}
