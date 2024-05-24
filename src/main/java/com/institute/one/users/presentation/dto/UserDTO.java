package com.institute.one.users.presentation.dto;

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
public class UserDTO {

    private Long id;

    // TODO: Security

    private String username;

    private String password;

    private boolean isEnabled;

    private boolean AccountNoExpired;

    private boolean AccountNoLocked;

    private boolean CredentialNoExpired;

    private Set<RoleEntity> roles;

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
