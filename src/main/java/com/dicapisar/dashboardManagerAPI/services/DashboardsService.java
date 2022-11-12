package com.dicapisar.dashboardManagerAPI.services;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;
import com.dicapisar.dashboardManagerAPI.dtos.response.DashboardsInfoDTO;
import com.dicapisar.dashboardManagerAPI.repository.ContactRepository;
import com.dicapisar.dashboardManagerAPI.repository.ItemRepository;
import com.dicapisar.dashboardManagerAPI.repository.ProviderRepository;
import com.dicapisar.dashboardManagerAPI.repository.UserRepository;
import com.dicapisar.dashboardManagerAPI.services.dahsboards.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DashboardsService implements IDashboardsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ItemRepository itemRepository;


    private String countUsersDashboard = "countUsersDashboard";
    private String countProvidersDashboard = "countProvidersDashboard";
    private String countContactsDashboard = "countContactsDashboard";
    private String countItemsDashboard = "countItemsDashboard";
    private String countUsersByRolDashboard = "countUsersByRolDashboard";
    /*
    private String top10ProvidersLastMonthDashboard = "top10ProvidersLastMonthDashboard";
    private String countOfItemOutputPerItemTypeLastWeekDashboard = "countOfItemOutputPerItemTypeLastWeekDashboard";
    private String countOfItemOutputPerItemTypeLastMonthDashboard = "countOfItemOutputPerItemTypeLastMonthDashboard";
    private String top10BrandsLastMonthDashboard = "top10BrandsLastMonthDashboard";
    private String top10TypeItemLastMonthDashboard = "top10TypeItemLastMonthDashboard";
     */


    private Map<String, Dashboard> getDashboards() {
        Map<String, Dashboard> dashboard = new HashMap<>();
        dashboard.put(countUsersDashboard, new CountUsersDashboard(userRepository));
        dashboard.put(countProvidersDashboard, new CountProvidersDashboard(providerRepository));
        dashboard.put(countContactsDashboard, new CountContactsDashboard(contactRepository));
        dashboard.put(countItemsDashboard, new CountItemsDashboard(itemRepository));
        dashboard.put(countUsersByRolDashboard, new CountUsersByRolDashboard(userRepository));
        return dashboard;
    }

    public DashboardsInfoDTO getDashboardsInfo() {
        Map<String, Dashboard> dashboards = this.getDashboards();
        DashboardsInfoDTO dashboardsInfoDTO = new DashboardsInfoDTO();
        List<DashboardInfo> dashboardInfoList = new ArrayList<>();

        for (Map.Entry<String, Dashboard> entry : dashboards.entrySet()) {
            DashboardInfo dashboardInfo = entry.getValue().execute(entry.getKey());
            dashboardInfoList.add(dashboardInfo);
        }

        dashboardsInfoDTO.setDashboards(dashboardInfoList);

        return dashboardsInfoDTO;
    }
}
