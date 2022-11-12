package com.dicapisar.dashboardManagerAPI.services.dahsboards;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;

public interface Dashboard {
    DashboardInfo execute(String name);
}
