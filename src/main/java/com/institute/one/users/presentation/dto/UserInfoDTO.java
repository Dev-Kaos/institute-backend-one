package com.institute.one.users.presentation.dto;

import java.util.List;
import java.util.Set;

import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    private String username;    

    private List<String> roles;

    // TODO: Others

    private String name;

    private String surname;

    private DocTypeEnum DocType;

    private String DocNumber;

    private LocalDate birthDate;

    private String email;

    private String phone;

    private GenderEnum gender;

    private String profileImage;

    private String nickname;

    private StateEnum state;
}
