package com.brijesh.adminservice.controller;

import com.brijesh.adminservice.model.request.DepartmentRequest;
import com.brijesh.adminservice.model.response.DepartmentResponse;
import com.brijesh.adminservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentRequest departmentRequest){
        DepartmentResponse departmentResponse = departmentService.saveDepartment(departmentRequest);
        return ResponseEntity.ok(departmentResponse);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByAdmin/{adminId}")
    public ResponseEntity<List<?>> showDepartmentByAdminId(@PathVariable Long adminId){
        List<DepartmentResponse> departments = departmentService.getDepartmentByAdminId(adminId);
        return ResponseEntity.ok(departments);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{adminId}/{departmentId}")
    public ResponseEntity<?> updateDepartment(@RequestBody DepartmentRequest departmentRequest, @PathVariable Long departmentId, @PathVariable Long adminId){
        DepartmentResponse departmentResponse = departmentService.updateDepartment(adminId, departmentId, departmentRequest);
        return ResponseEntity.ok(departmentResponse);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{adminId}/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long adminId, @PathVariable Long departmentId){
        departmentService.deleteDepartment(adminId, departmentId);
        return ResponseEntity.ok("Deleted Successfully...");
    }

}
