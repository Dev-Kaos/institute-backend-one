package com.institute.one.users.presentation.dto;

import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserBasicAuthEntity;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;

    private String surname;

    private String docType;

    private String docNumber;

    private LocalDate birthDate;

    private String email;

    private String phone;

    private String gender;

    private String profileImage;

    private String nickname;

    private String state;

    // // TODO: Security    

    private String username;

    // private String password;

    // private boolean isEnabled;

    // private boolean accountNoExpired;

    // private boolean accountNoLocked;

    // private boolean credentialNoExpired;

    private String role;
    
}
