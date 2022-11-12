package com.dicapisar.dashboardManagerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long id;

    @Column(name = "con_active", nullable = false)
    private boolean isActive;

}
