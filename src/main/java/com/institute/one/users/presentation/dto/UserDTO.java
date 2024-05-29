package com.institute.one.users.presentation.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

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
