package com.brijesh.adminservice.model.response;

import java.io.Serializable;

public class AdminResponse implements Serializable {
    String adminCode;
    String adminName;
    String adminEmail;

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public AdminResponse(){
    }

}
