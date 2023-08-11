package com.brijesh.adminservice.service;

import com.brijesh.adminservice.model.request.FacultyRequest;
import com.brijesh.adminservice.model.response.FacultyResponse;

import java.util.List;

public interface FacultyService {
    FacultyResponse saveFaculty(Long adminId, FacultyRequest facultyRequest);

    List<FacultyResponse> getFacultyByAdminId(Long adminId);

    void deleteFaculty(Long facultyId, Long adminId);
}
