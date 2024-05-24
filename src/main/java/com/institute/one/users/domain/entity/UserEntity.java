package com.institute.one.users.domain.entity;

import java.util.HashSet;
import java.util.Set;

import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // TODO: Security

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_no_expired")
    private boolean AccountNoExpired;

    @Column(name = "account_no_locked")
    private boolean AccountNoLocked;

    @Column(name = "credential_no_expired")
    private boolean CredentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    // TODO: Others

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "doc_type")
    private DocTypeEnum DocType;

    @Column(name = "doc_number")
    private String DocNumber;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "nickname")
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateEnum state;

}
