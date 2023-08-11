package com.brijesh.adminservice.service;

import com.brijesh.adminservice.model.request.AdminRequest;
import com.brijesh.adminservice.model.response.AdminResponse;

public interface AdminService {


    AdminResponse saveAdmin(AdminRequest adminRequest);

    AdminResponse getAdminById(Long adminId);
}
