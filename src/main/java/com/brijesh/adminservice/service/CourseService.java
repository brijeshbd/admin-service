package com.brijesh.adminservice.service;

import com.brijesh.adminservice.model.request.CourseRequest;
import com.brijesh.adminservice.model.response.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourse(Long adminId, CourseRequest courseRequest);

    List<CourseResponse> getByDepartmentName(Long adminId, Long departmentId);

    CourseResponse getCourseById(Long courseId);
}
