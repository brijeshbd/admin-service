package com.brijesh.adminservice.dao;

import com.brijesh.adminservice.model.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyDao extends JpaRepository<Faculty, Long> {
    List<Faculty> findByAdminId(Long adminId);
}
