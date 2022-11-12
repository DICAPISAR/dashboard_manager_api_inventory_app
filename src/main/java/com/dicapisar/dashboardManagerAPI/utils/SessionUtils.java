package com.dicapisar.dashboardManagerAPI.utils;

import com.dicapisar.dashboardManagerAPI.exceptions.SessionErrorException;
import com.dicapisar.dashboardManagerAPI.exceptions.SessionWithOutPermissionException;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.dicapisar.dashboardManagerAPI.commons.DashboardManagerConstants.*;

public class SessionUtils {
    public static void validateSessionExist(HttpSession session) throws SessionErrorException {
        if (session.getAttribute(ROL_NAME) == null) {
            throw new SessionErrorException();
        }
    }

    public static void validateSessionHavePermissions(HttpSession session, ArrayList<String> permissionList)
            throws SessionWithOutPermissionException {
      if (!permissionList.contains(session.getAttribute(ROL_NAME))){
          throw new SessionWithOutPermissionException();
      }
    }

}
