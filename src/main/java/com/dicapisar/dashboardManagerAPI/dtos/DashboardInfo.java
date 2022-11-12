package com.dicapisar.dashboardManagerAPI.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DashboardInfo {
    private String name;
    private TypeDashboard type;
    private Map<String, Object> data;
}


