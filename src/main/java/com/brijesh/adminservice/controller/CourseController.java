package com.brijesh.adminservice.controller;

import com.brijesh.adminservice.model.request.CourseRequest;
import com.brijesh.adminservice.model.response.CourseResponse;
import com.brijesh.adminservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST, value = "/save/{adminId}")
    public ResponseEntity<?> saveCourse(@PathVariable Long adminId, @RequestBody CourseRequest courseRequest){
        CourseResponse courseResponse = courseService.saveCourse(adminId, courseRequest);
        return ResponseEntity.ok(courseResponse);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByDepartment/{adminId}")
    public ResponseEntity<List<?>> getCourseByDepartmentName(@RequestParam Long departmentId, @PathVariable Long adminId){
        List<CourseResponse> response = courseService.getByDepartmentName(adminId, departmentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getNameById/{courseId}")
    public ResponseEntity<?> getById(@PathVariable Long courseId){
        CourseResponse courseResponse = courseService.getCourseById(courseId);
        return ResponseEntity.ok(courseResponse.getCourseName());
    }

}
