package com.brijesh.adminservice.service;

import com.brijesh.adminservice.model.request.DepartmentRequest;
import com.brijesh.adminservice.model.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse saveDepartment(DepartmentRequest departmentRequest);

    List<DepartmentResponse> getDepartmentByAdminId(Long adminId);

    DepartmentResponse updateDepartment(Long adminId, Long departmentId, DepartmentRequest departmentRequest);

    void deleteDepartment(Long adminId, Long departmentId);
}
