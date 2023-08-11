package com.brijesh.adminservice.model.request;

public class FacultyRequest {

    String facultyName;
    String facultyEmail;
    String facultyPassword;
    String designation;
    Long departmentId;

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

    public FacultyRequest(String facultyName, String facultyEmail, String facultyPassword, String designation, Long departmentId) {
        this.facultyName = facultyName;
        this.facultyEmail = facultyEmail;
        this.facultyPassword = facultyPassword;
        this.designation = designation;
        this.departmentId = departmentId;
    }

    public FacultyRequest() {
    }

    @Override
    public String toString() {
        return "FacultyRequest{" +
                "facultyName='" + facultyName + '\'' +
                ", facultyEmail='" + facultyEmail + '\'' +
                ", facultyPassword='" + facultyPassword + '\'' +
                ", designation='" + designation + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
