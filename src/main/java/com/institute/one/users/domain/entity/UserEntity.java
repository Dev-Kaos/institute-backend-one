package com.institute.one.users.domain.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

        name = "getNameAndUsernameNamedQuery",
        query = "SELECT u.name, ua.username FROM users u JOIN user_auth ua ON u.id = ua.user_id",
        resultSetMapping = "UserDTOMapping"
)
@SqlResultSetMapping(

        name = "UserDTOMapping", classes = @ConstructorResult(columns = {
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "username", type = String.class)
        }, targetClass = UserDTO.class)

)
public class UserEntity {


    // SELECT u.name, ua.username FROM users u JOIN user_auth ua ON u.id = ua.user_id sql native
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
