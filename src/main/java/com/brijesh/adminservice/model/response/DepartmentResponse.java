package com.brijesh.adminservice.model.response;

import java.io.Serializable;

public class DepartmentResponse implements Serializable {

    String departmentCode;
    String departmentName;
    String city;
    String universityName;
    String createdBy;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public DepartmentResponse() {
    }

    public DepartmentResponse(String departmentCode, String departmentName, String city, String universityName, String createdBy) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.city = city;
        this.universityName = universityName;
        this.createdBy = createdBy;
    }
}
