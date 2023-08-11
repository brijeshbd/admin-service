package com.brijesh.adminservice.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "admin")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long courseId;
    String courseName;
    Long departmentId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Course() {
    }

    public Course(Long courseId, String courseName, Long departmentId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
