package com.dicapisar.dashboardManagerAPI.services.dahsboards;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;
import com.dicapisar.dashboardManagerAPI.dtos.TypeDashboard;
import com.dicapisar.dashboardManagerAPI.models.User;
import com.dicapisar.dashboardManagerAPI.repository.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class CountUsersByRolDashboard implements Dashboard{

    private UserRepository userRepository;

    public CountUsersByRolDashboard(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DashboardInfo execute(String name) {
        return new DashboardInfo(name, TypeDashboard.bar, getDataCountUserByRol());
    }

    @Transactional
    public Map<String, Object> getDataCountUserByRol() {
        List<User> userList = userRepository.getUsersByActiveIsTrue();
        Map<String, Object> data = new HashMap<>();

        userList.forEach(user -> {
             Object rolNameVale =  data.get(user.getRol().getName());
             if (rolNameVale == null) {
                 data.put(user.getRol().getName(), 1);
             } else {
                 data.put(user.getRol().getName(), (Integer) rolNameVale + 1);
             }
        });

        return data;
    }

}
