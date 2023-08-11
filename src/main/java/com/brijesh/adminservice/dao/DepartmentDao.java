package com.brijesh.adminservice.dao;

import com.brijesh.adminservice.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, Long> {
    List<Department> findByAdminId(Long adminId);

    Department findByDepartmentName(String departmentName);
}
