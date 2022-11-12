package com.dicapisar.dashboardManagerAPI.dtos.response;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DashboardsInfoDTO {
    private List<DashboardInfo> dashboards;
}
