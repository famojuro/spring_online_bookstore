package com.innovativeapps.bookstoremanager.util.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
    int status;
    int code;
    String message;
    String link;
    String developerMessage;

    public ErrorMessage() {}

    public ErrorMessage(int status, int code, String message, String link, String developerMessage) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
        this.link = link;
        this.developerMessage = developerMessage;
    }

    public ErrorMessage(GeneralAppException gae) {
        super();
        this.link = gae.link;
        this.code = gae.code;
        this.developerMessage= gae.developerMessage;
        this.status = gae.status;
        this.message = gae.message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ErrorMessage(NotFoundException ex){
        this.status = Response.Status.NOT_FOUND.getStatusCode();
        this.message = ex.getMessage();
        this.link = "https://jersey.java.net/apidocs/2.8/jersey/javax/ws/rs/NotFoundException.html";
    }
}
