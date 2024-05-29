package com.institute.one.permissions.presentation.dto;

import com.institute.one.utilities.enums.StateEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionInfoDTO {

    
    private Long id;

    private String name;

    private StateEnum state;

}
