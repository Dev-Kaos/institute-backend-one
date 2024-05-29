package com.institute.one.permissions.bussiness.service.implementation;

import java.util.List;

import com.institute.one.permissions.bussiness.service.interfaces.IPermissionService;
import com.institute.one.permissions.domain.entity.PermissionEntity;
import com.institute.one.permissions.persistance.repository.IPermissionRepository;
import com.institute.one.permissions.presentation.dto.PermissionInfoDTO;
import com.institute.one.users.business.service.interfaces.IUserService;
import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.persistence.repository.IUserRepository;
import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public PermissionInfoDTO save(PermissionInfoDTO permissionInfoDTO) {

        try {

            ModelMapper modelMapper = new ModelMapper();
            PermissionEntity permissionEntity = modelMapper.map(permissionInfoDTO, PermissionEntity.class);
            this.permissionRepository.save(permissionEntity);
            return permissionInfoDTO;

        } catch (Exception e) {

            throw new UnsupportedOperationException("Error al guardar el Permiso");
        }

    }

    @Override
    public PermissionInfoDTO update(Long id, PermissionInfoDTO permissionInfoDTO) {

        Optional<PermissionEntity> permissionEntityOptional = permissionRepository.findById(id);

        if (permissionEntityOptional.isPresent()) {
            PermissionEntity permissionEntity = permissionEntityOptional.get();

            // Update using Setters (if values are allowed to be updated)
            if (permissionInfoDTO.getName() != null) { // Check if name update is allowed
                throw new IllegalArgumentException("Name cannot be updated"); // Since name is updatable=false
            }
            permissionEntity.setState(StateEnum.valueOf(permissionInfoDTO.getState().name()));

            permissionRepository.save(permissionEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(permissionEntity, PermissionInfoDTO.class);
        } else {
            throw new IllegalArgumentException("Permission not found");
        }

        // Optional<PermissionEntity> permissionEntity =
        // permissionRepository.findById(id);

        // if (permissionEntity.isPresent()) {
        // PermissionEntity currentPermissionEntity = permissionEntity.get();
        // currentPermissionEntity.setName(permissionInfoDTO.getName());

        // try {
        // StateEnum state = StateEnum.valueOf(permissionInfoDTO.getState().name());
        // currentPermissionEntity.setState(state);
        // } catch (IllegalArgumentException e) {
        // throw new IllegalArgumentException("Invalid state value: " +
        // permissionInfoDTO.getState().name());
        // }

        // try {
        // permissionRepository.save(currentPermissionEntity);
        // } catch (DataIntegrityViolationException e) {
        // throw new IllegalArgumentException("Error updating permission: " +
        // e.getMessage());
        // }

        // ModelMapper modelMapper = new ModelMapper();
        // return modelMapper.map(currentPermissionEntity, PermissionInfoDTO.class);
        // } else {
        // throw new IllegalArgumentException("Permission not found");
        // }

    }

    @Override
    public String delete(Long id) {

        // Optional<PermissionEntity> permissionEntity =
        // this.permissionRepository.findById(id);

        // if (permissionEntity.isPresent()) {

        // PermissionEntity currentPermissionEntity = permissionEntity.get();

        // this.permissionRepository.delete(currentPermissionEntity);

        // return "la jornada con " + id + " ha sido eliminada";

        // } else {
        // return "la jornada con " + id + " no existe";
        // }

        Optional<PermissionEntity> permissionEntity = permissionRepository.findById(id);

        if (permissionEntity.isPresent()) {

            PermissionEntity entityToDelete = permissionEntity.get();
            String name = entityToDelete.getName();

            this.permissionRepository.delete(entityToDelete);


            return "EL permiso " + name + " ha sido borrado.";

        } else {

            return "No se encontro el permiso que deseas elminar.";
            
        }

    }

}
