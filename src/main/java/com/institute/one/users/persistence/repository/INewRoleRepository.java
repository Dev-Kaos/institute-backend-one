package com.institute.one.users.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserEntity;

import java.util.List;


public interface INewRoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findById(Long id);
    // Optional<UserEntity> findByUsername(String username);
}
