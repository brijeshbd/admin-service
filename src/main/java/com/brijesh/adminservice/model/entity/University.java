package com.brijesh.adminservice.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "university", schema = "admin")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long universityId;
    String universityName;

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

}
