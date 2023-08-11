package com.brijesh.adminservice.model.response;

import java.io.Serializable;

public class CourseResponse implements Serializable {
    String courseCode;
    String courseName;
    String departmentName;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
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

    @Override
    public String toString() {
        return "CourseResponse{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public CourseResponse() {
    }

    public CourseResponse(String courseCode, String courseName, String departmentName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.departmentName = departmentName;
    }
}
