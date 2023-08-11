package com.brijesh.adminservice.service;

import com.brijesh.adminservice.dao.CourseDao;
import com.brijesh.adminservice.dao.DepartmentDao;
import com.brijesh.adminservice.exception.AdminException;
import com.brijesh.adminservice.model.entity.Course;
import com.brijesh.adminservice.model.entity.Department;
import com.brijesh.adminservice.model.request.CourseRequest;
import com.brijesh.adminservice.model.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseDao courseDao;

    @Autowired
    DepartmentDao departmentDao;

    @CacheEvict(value = "course",  allEntries = true)
    @Override
    public CourseResponse saveCourse(Long adminId, CourseRequest courseRequest) {
        Department department = departmentDao.findByDepartmentName(courseRequest.getDepartmentName());
        if(!Objects.equals(department.getAdminId(), adminId)){
            throw new AdminException("Admin is different ");
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDepartmentId(department.getDepartmentId());
        Course savedCourse = courseDao.save(course);
        return new CourseResponse("C"+savedCourse.getCourseId(), savedCourse.getCourseName(), department.getDepartmentName());
    }

    @Cacheable(value = "course", key="{#adminId, #departmentId}")
    @Override
    public List<CourseResponse> getByDepartmentName(Long adminId, Long departmentId) {
        System.out.println("Getting Department By name...");
        Department department = departmentDao.getById(departmentId);
        System.out.println("DEpartment Name is : " + department);
        if(!Objects.equals(department.getAdminId(), adminId))
            throw new AdminException("Admin is not Valid...");
        List<Course> courseList = courseDao.findByDepartmentId(department.getDepartmentId());
        if(courseList==null && courseList.isEmpty())
            throw new AdminException("Course List is empty...");
        List<CourseResponse> responseList = new ArrayList<>();
        for(Course c : courseList){
            CourseResponse courseResponse = new CourseResponse("C"+c.getCourseId(), c.getCourseName(), department.getDepartmentName());
            responseList.add(courseResponse);
        }
        return responseList;
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {

        Course c = courseDao.getById(courseId);
        String departmentName = departmentDao.getById(c.getDepartmentId()).getDepartmentName();
        CourseResponse response = new CourseResponse("C"+c.getCourseId(), c.getCourseName(), departmentName);
        return response;
    }
}
