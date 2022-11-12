package com.dicapisar.dashboardManagerAPI.services.dahsboards;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;
import com.dicapisar.dashboardManagerAPI.dtos.TypeDashboard;
import com.dicapisar.dashboardManagerAPI.models.Provider;
import com.dicapisar.dashboardManagerAPI.repository.ProviderRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class CountProvidersDashboard implements Dashboard{

    private ProviderRepository providerRepository;

    public CountProvidersDashboard(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public DashboardInfo execute(String name) {
        List<Provider> providerList = providerRepository.getProvidersByActiveIsTrue();
        Map<String, Object> data = new HashMap<>();
        data.put("count", providerList.size());
        return new DashboardInfo(name, TypeDashboard.count, data);
    }

}
