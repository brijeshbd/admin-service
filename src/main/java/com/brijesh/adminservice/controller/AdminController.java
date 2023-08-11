package com.brijesh.adminservice.controller;

import com.brijesh.adminservice.model.request.AdminRequest;
import com.brijesh.adminservice.model.response.AdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brijesh.adminservice.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.POST,  value = "/save")
    public ResponseEntity<?> saveAdmin(@RequestBody AdminRequest adminRequest){
        AdminResponse adminResponse = adminService.saveAdmin(adminRequest);
        if(adminResponse!=null){
            return ResponseEntity.ok(adminResponse);
        } else {
            throw new RuntimeException("Data is not Saved...");
        }

    }

    @RequestMapping(value = "/get/{adminId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAdminById(@PathVariable Long adminId){
        AdminResponse adminResponse = adminService.getAdminById(adminId);
        return ResponseEntity.ok(adminResponse);
    }

}
