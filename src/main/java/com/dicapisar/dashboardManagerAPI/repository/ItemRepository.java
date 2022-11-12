package com.dicapisar.dashboardManagerAPI.repository;

import com.dicapisar.dashboardManagerAPI.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i where i.isActive = true")
    List<Item> getItemsByActiveIsTrue();
}
