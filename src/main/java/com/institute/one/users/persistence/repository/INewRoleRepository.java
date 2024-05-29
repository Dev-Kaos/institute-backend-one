package com.institute.one.users.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.utilities.enums.RoleEnum;

@Repository
public interface INewRoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findById(Long id);
    
    Optional<RoleEntity> findByRoleEnum(RoleEnum roleEnum);
    
    // Optional<UserEntity> findByUsername(String username);
}
