package com.dicapisar.dashboardManagerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "providers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_active", nullable = false)
    private boolean isActive;

}
