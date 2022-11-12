package com.dicapisar.dashboardManagerAPI.repository;

import com.dicapisar.dashboardManagerAPI.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    @Query("select p from Provider p where p.isActive = true")
    List<Provider> getProvidersByActiveIsTrue();

}
