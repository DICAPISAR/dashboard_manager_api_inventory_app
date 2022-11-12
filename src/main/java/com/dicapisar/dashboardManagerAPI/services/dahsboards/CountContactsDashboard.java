package com.dicapisar.dashboardManagerAPI.services.dahsboards;

import com.dicapisar.dashboardManagerAPI.dtos.DashboardInfo;
import com.dicapisar.dashboardManagerAPI.dtos.TypeDashboard;
import com.dicapisar.dashboardManagerAPI.models.Contact;
import com.dicapisar.dashboardManagerAPI.repository.ContactRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class CountContactsDashboard implements Dashboard{

    private ContactRepository contactRepository;

    public CountContactsDashboard(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public DashboardInfo execute(String name) {
        List<Contact> contactList = contactRepository.getContactsByActiveIsTrue();
        Map<String, Object> data = new HashMap<>();
        data.put("count", contactList.size());
        return new DashboardInfo(name, TypeDashboard.count, data);
    }

}
