package com.brijesh.adminservice.model.response;

import java.io.Serializable;

public class FacultyResponse implements Serializable {

    String facultyCode;
    String facultyName;
    String facultyEmail;
    String facultyPassword;
    String adminEmail;
    String designation;
    String departmentName;

    public String getFacultyPassword() {
        return facultyPassword;
    }

    public void setFacultyPassword(String facultyPassword) {
        this.facultyPassword = facultyPassword;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
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

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public FacultyResponse(String facultyCode, String facultyName, String facultyEmail, String facultyPassword, String adminEmail, String designation, String departmentName) {
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
        this.facultyEmail = facultyEmail;
        this.facultyPassword = facultyPassword;
        this.adminEmail = adminEmail;
        this.designation = designation;
        this.departmentName = departmentName;
    }

    public FacultyResponse() {
    }

    @Override
    public String toString() {
        return "FacultyResponse{" +
                "facultyCode='" + facultyCode + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", facultyEmail='" + facultyEmail + '\'' +
                ", facultyPassword='" + facultyPassword + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", designation='" + designation + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
