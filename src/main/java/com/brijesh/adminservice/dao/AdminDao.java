package com.brijesh.adminservice.dao;

import com.brijesh.adminservice.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminDao extends JpaRepository<Admin, Long> {
    Admin findByAdminEmail(String email);
}
