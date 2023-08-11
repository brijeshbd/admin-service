package com.brijesh.adminservice.model.request;

public class CourseRequest {
    String courseName;
    String departmentName;

    public CourseRequest() {
    }

    public CourseRequest(String courseName, String departmentName) {
        this.courseName = courseName;
        this.departmentName = departmentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
