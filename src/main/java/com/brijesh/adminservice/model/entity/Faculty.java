package com.brijesh.adminservice.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "faculty", schema = "admin")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long facultyId;
    String facultyName;
    String facultyEmail;
    String facultyPassword;
    Long adminId;
    String designation;
    Long departmentId;

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyEmail() {
        return facultyEmail;
    }

    public void setFacultyEmail(String facultyEmail) {
        this.facultyEmail = facultyEmail;
    }

    public String getFacultyPassword() {
        return facultyPassword;
    }

    public void setFacultyPassword(String facultyPassword) {
        this.facultyPassword = facultyPassword;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Faculty() {
    }

    public Faculty(Long facultyId, String facultyName, String facultyEmail, String facultyPassword, Long adminId, String designation, Long departmentId) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyEmail = facultyEmail;
        this.facultyPassword = facultyPassword;
        this.adminId = adminId;
        this.designation = designation;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyEmail='" + facultyEmail + '\'' +
                ", facultyPassword='" + facultyPassword + '\'' +
                ", adminId=" + adminId +
                ", designation='" + designation + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
