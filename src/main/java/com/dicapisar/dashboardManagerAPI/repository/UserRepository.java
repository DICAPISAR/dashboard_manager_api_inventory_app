package com.dicapisar.dashboardManagerAPI.repository;

import com.dicapisar.dashboardManagerAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.isActive = true")
    List<User> getUsersByActiveIsTrue();
}
