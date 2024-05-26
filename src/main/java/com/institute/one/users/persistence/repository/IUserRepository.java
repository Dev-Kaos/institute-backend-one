package com.institute.one.users.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.utilities.enums.StateEnum;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {


    
    @Query(name = "getNameAndUsernameNamedQuery",nativeQuery = true)
    List<UserDTO> getNameAndUsername();
    // @Query("SELECT new com.example.UserDTO(u.name,u.surname,u.doc_type,u.doc_number, u.birthdate, u.email, u.phone, u.gender, u.profile_image, u.nickname, u.state, ua.username, ua.is_enabled, ua.account_no_expired, ua.account_no_locked,ua.credential_no_expired) FROM UserEntity u JOIN u.UserBasicAuthEntity b")
    // List<UserDTO> findUsersAndAuth();
    // List<UserDTO> verUsuarios();
    // @Query("SELECT u.name,u.surname,u.doc_type,u.doc_number, u.birthdate, u.email, u.phone, u.gender, u.profile_image, u.nickname, u.state, ua.username, ua.is_enabled, ua.account_no_expired, ua.account_no_locked,ua.credential_no_expired FROM users u JOIN u.user_Auth ua")
    // List<UserDTO> findUsersInfo();
    // List<UserEntity> findAllByNameContaining(String name);

    // List<UserEntity> findAllBySurnameContaining(String surname);

    // List<UserEntity> findByDocType(DocTypeEnum docTypeEnum);

    // List<UserEntity> findByDocNumberContaining(String docNumber);

    // List<UserEntity> findByEmailContaining(String email);

    // List<UserEntity> findByPhoneContaining(String phone);

    // List<UserEntity> findByGender(GenderEnum genderEnum);

    // List<UserEntity> findByNicknameContaining(String phone);

    // // TODO: hacer el metodo para fecha de nacimiento

    // List<UserEntity> findByState(StateEnum stateEnum);
    // List<UserEntity> findByStateAndDocType(StateEnum stateEnum, DocTypeEnum
    // docTypeEnum);
    // List<UserEntity> findByStateAndDocNumberContaining(StateEnum stateEnum,
    // String docNumber);

}
