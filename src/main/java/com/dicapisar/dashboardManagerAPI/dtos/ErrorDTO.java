package com.dicapisar.dashboardManagerAPI.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDTO {
    private String errorName;
    private String message;
}
