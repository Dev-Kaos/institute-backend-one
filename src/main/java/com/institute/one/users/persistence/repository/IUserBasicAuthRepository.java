package com.institute.one.users.persistence.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.one.users.domain.entity.UserBasicAuthEntity;

@Repository
public interface IUserBasicAuthRepository extends JpaRepository<UserBasicAuthEntity, Long> {

    Optional<UserBasicAuthEntity> findByUsername(String username);
}
