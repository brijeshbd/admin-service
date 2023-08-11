package com.brijesh.adminservice.controller;

import com.brijesh.adminservice.model.request.FacultyRequest;
import com.brijesh.adminservice.model.response.FacultyResponse;
import com.brijesh.adminservice.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping(value = "/save/{adminId}")
    public ResponseEntity<?> saveFaculty(@PathVariable Long adminId, @RequestBody FacultyRequest facultyRequest){
        FacultyResponse facultyResponse = facultyService.saveFaculty(adminId, facultyRequest);
        return ResponseEntity.ok(facultyResponse);
    }


    @GetMapping(value = "getByAdmin/{adminId}")
    public ResponseEntity<List<?>> getFacultyByAdminId(@PathVariable Long adminId){
        List<FacultyResponse> responses = facultyService.getFacultyByAdminId(adminId);
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping(value = "/delete/{facultyId}")
    public ResponseEntity<?> deleteFaculty(@PathVariable Long facultyId, @RequestParam Long adminId){
        facultyService.deleteFaculty(facultyId, adminId);
        return ResponseEntity.ok("Deleted Sucessfully...");
    }


}
