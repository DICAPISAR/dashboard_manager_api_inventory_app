package com.dicapisar.dashboardManagerAPI.repository;

import com.dicapisar.dashboardManagerAPI.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("select c from Contact c where c.isActive = true")
    List<Contact> getContactsByActiveIsTrue();
}
