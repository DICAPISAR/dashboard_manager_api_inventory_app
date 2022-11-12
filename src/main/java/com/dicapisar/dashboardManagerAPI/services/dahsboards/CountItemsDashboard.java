package com.dicapisar.dashboardManagerAPI.services.dahsboards;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;
import com.dicapisar.dashboardManagerAPI.dtos.TypeDashboard;
import com.dicapisar.dashboardManagerAPI.models.Item;
import com.dicapisar.dashboardManagerAPI.repository.ItemRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class CountItemsDashboard implements Dashboard{

    private ItemRepository itemRepository;

    public CountItemsDashboard(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public DashboardInfo execute(String name) {
        List<Item> itemList = itemRepository.getItemsByActiveIsTrue();
        Map<String, Object> data = new HashMap<>();
        data.put("count", itemList.size());
        return new DashboardInfo(name, TypeDashboard.count, data);
    }

}
