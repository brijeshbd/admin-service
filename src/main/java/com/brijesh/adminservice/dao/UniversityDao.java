package com.brijesh.adminservice.dao;

import com.brijesh.adminservice.model.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDao extends JpaRepository<University, Long> {
    University findByUniversityName(String universityName);
}
