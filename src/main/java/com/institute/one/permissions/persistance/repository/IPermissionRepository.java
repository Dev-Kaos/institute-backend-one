package com.institute.one.permissions.persistance.repository;

import java.util.Optional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.institute.one.permissions.domain.entity.PermissionEntity;
import com.institute.one.utilities.enums.StateEnum;

@Repository
public interface IPermissionRepository extends JpaRepository<PermissionEntity, Long> {

    Optional<PermissionEntity> findById(Long id);

    List<PermissionEntity> findByNameContaining(String name);

    @Query("SELECT p FROM PermissionEntity p WHERE p.state = :state")
    List<PermissionEntity> findByState(StateEnum state);

}
