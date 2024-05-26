package com.institute.one.users.presentation.dto;

import com.institute.one.users.domain.entity.UserBasicAuthEntity;
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

    private String name;

    private String surname;

    private DocTypeEnum docType;

    private String docNumber;

    private LocalDate birthDate;

    private String email;

    private String phone;

    private GenderEnum gender;

    private String profileImage;

    private String nickname;

    private StateEnum state;
    
}
