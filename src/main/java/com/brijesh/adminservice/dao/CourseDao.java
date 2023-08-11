package com.brijesh.adminservice.dao;

import com.brijesh.adminservice.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {
    List<Course> findByDepartmentId(Long departmentId);
}
