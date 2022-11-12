package com.dicapisar.dashboardManagerAPI.exceptions;

import org.springframework.http.HttpStatus;

public class SessionWithOutPermissionException extends DashboardManagerException{

    public SessionWithOutPermissionException() {
        super("The user does not have the necessary permissions to perform the requested action.", HttpStatus.FORBIDDEN);
    }
}
