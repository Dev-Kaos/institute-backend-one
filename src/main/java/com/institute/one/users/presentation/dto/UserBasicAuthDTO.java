package com.institute.one.users.presentation.dto;

import java.util.HashSet;
import java.util.Set;

import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicAuthDTO {

    private Long userId;

    private UserEntity user;

    // TODO: Security

    private String username;

    private String password;

    private boolean isEnabled;

    private boolean AccountNoExpired;

    private boolean AccountNoLocked;

    private boolean CredentialNoExpired;

    private Set<RoleEntity> roles = new HashSet<>();
}
