package com.dicapisar.dashboardManagerAPI.exceptions;

import org.springframework.http.HttpStatus;

public class SessionErrorException extends DashboardManagerException{

    public SessionErrorException() {
        super("Session error, try to login again.", HttpStatus.FORBIDDEN);
    }
}
