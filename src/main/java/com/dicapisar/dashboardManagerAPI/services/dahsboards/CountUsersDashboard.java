package com.dicapisar.dashboardManagerAPI.services.dahsboards;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;
import com.dicapisar.dashboardManagerAPI.dtos.TypeDashboard;
import com.dicapisar.dashboardManagerAPI.models.User;
import com.dicapisar.dashboardManagerAPI.repository.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class CountUsersDashboard implements Dashboard{

    private UserRepository userRepository;

    public CountUsersDashboard(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DashboardInfo execute(String name) {
        List<User> userList = userRepository.getUsersByActiveIsTrue();
        Map<String, Object> data = new HashMap<>();
        data.put("count", userList.size());
        return new DashboardInfo(name, TypeDashboard.count, data);
    }

}
