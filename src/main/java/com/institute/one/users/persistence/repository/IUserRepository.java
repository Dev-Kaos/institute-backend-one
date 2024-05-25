package com.institute.one.users.persistence.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    

    // List<UserEntity> findAllByNameContaining(String name);

    // List<UserEntity> findAllBySurnameContaining(String surname);

    // List<UserEntity> findByDocType(DocTypeEnum docTypeEnum);

    // List<UserEntity> findByDocNumberContaining(String docNumber);

    // List<UserEntity> findByEmailContaining(String email);

    // List<UserEntity> findByPhoneContaining(String phone);

    // List<UserEntity> findByGender(GenderEnum genderEnum);

    // List<UserEntity> findByNicknameContaining(String phone);

    // // TODO: hacer el metodo para fecha de nacimiento

    List<UserEntity> findByState(StateEnum stateEnum);
    // List<UserEntity> findByStateAndDocType(StateEnum stateEnum, DocTypeEnum
    // docTypeEnum);
    // List<UserEntity> findByStateAndDocNumberContaining(StateEnum stateEnum,
    // String docNumber);

}
