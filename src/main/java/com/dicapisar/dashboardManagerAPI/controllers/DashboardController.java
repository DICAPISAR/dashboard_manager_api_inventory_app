package com.dicapisar.dashboardManagerAPI.controllers;

import com.dicapisar.dashboardManagerAPI.dtos.response.DashboardsInfoDTO;
import com.dicapisar.dashboardManagerAPI.exceptions.SessionErrorException;
import com.dicapisar.dashboardManagerAPI.exceptions.SessionWithOutPermissionException;
import com.dicapisar.dashboardManagerAPI.services.IDashboardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.dicapisar.dashboardManagerAPI.commons.DashboardManagerConstants.*;
import static com.dicapisar.dashboardManagerAPI.utils.SessionUtils.*;


@RestController
@AllArgsConstructor
@RequestMapping("/dashboards")
public class DashboardController {

    private IDashboardsService dashboardsService;

    @GetMapping()
    public ResponseEntity<DashboardsInfoDTO> getDashboards(HttpSession session)
            throws SessionWithOutPermissionException, SessionErrorException {
        this.validatePermissions(session);
        return new ResponseEntity<>(dashboardsService.getDashboardsInfo(), HttpStatus.OK);
    }

    private void validatePermissions(HttpSession session)
            throws SessionErrorException, SessionWithOutPermissionException {

        ArrayList<String> rolesPermissions = new ArrayList<>(List.of(ADMIN, MANAGER, EMPLOYED));

        validateSessionExist(session);
        validateSessionHavePermissions(session, rolesPermissions);
    }
}
