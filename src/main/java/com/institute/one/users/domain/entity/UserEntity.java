package com.institute.one.users.domain.entity;

import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedNativeQuery(

                name = "getNameAndUsernameNamedQuery", query = "SELECT u.name, " + //
                                "u.surname, " + //
                                "u.doc_type, " + //
                                "u.doc_number, " + //
                                "u.birth_date, " + //
                                "u.email, " + //
                                "u.phone, " + //
                                "u.gender, " + //
                                "u.profile_image, " + //
                                "u.nickname, " + //
                                "u.state, " + //
                                "ua.username, " + //
                                "r.role_name " + //
                                "FROM users u " + //
                                "JOIN user_auth ua ON u.id = ua.user_id " + //
                                "JOIN user_roles ur ON ua.user_id = ur.user_id " + //
                                "JOIN roles r ON ur.role_id = r.id " + //
                                "", resultSetMapping = "UserDTOMapping")
@SqlResultSetMapping(

                name = "UserDTOMapping", classes = @ConstructorResult(columns = {
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "surname", type = String.class),
                                @ColumnResult(name = "doc_type", type = String.class),
                                @ColumnResult(name = "doc_number", type = String.class),
                                @ColumnResult(name = "birth_date", type = LocalDate.class),
                                @ColumnResult(name = "email", type = String.class),
                                @ColumnResult(name = "phone", type = String.class),
                                @ColumnResult(name = "gender", type = String.class),
                                @ColumnResult(name = "profile_image", type = String.class),
                                @ColumnResult(name = "nickname", type = String.class),
                                @ColumnResult(name = "state", type = String.class),
                                @ColumnResult(name = "username", type = String.class),
                                @ColumnResult(name = "role_name", type = String.class),
                // @ColumnResult(name = "is_enabled", type = Boolean.class),
                // @ColumnResult(name = "account_no_expired", type = Boolean.class),
                // @ColumnResult(name = "account_no_locked", type = Boolean.class),
                // @ColumnResult(name = "credential_no_expired", type = Boolean.class),

                }, targetClass = UserDTO.class)

)
public class UserEntity {

        // SELECT u.name, ua.username FROM users u JOIN user_auth ua ON u.id =
        // ua.user_id sql native
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        // TODO: Others

        @Column(name = "name")
        private String name;

        @Column(name = "surname")
        private String surname;

        @Enumerated(EnumType.STRING)
        @Column(name = "doc_type")
        private DocTypeEnum docType;

        @Column(name = "doc_number")
        private String docNumber;

        @Column(name = "birth_date")
        private LocalDate birthDate;

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

        // @JsonManagedReference
        @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
        @PrimaryKeyJoinColumn
        private UserBasicAuthEntity userAuth;
}
