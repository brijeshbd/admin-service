package com.brijesh.adminservice.exception;

public class AdminException extends RuntimeException{
    String message;

    @Override
    public String getMessage() {
        return message;
    }
AdminException(){
        super("Admin is not Found...");
}
    public AdminException(String message) {
        super(message);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
