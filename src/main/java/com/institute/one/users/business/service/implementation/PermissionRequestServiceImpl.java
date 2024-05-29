package com.institute.one.users.business.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.institute.one.users.business.service.interfaces.IPermissionRequestService;
import com.institute.one.users.business.service.interfaces.IRoleRequestService;
import com.institute.one.users.business.service.interfaces.IUserRequestService;
import com.institute.one.users.presentation.dto.PermissionInfoDTO;
import com.institute.one.users.presentation.dto.RoleRequestDTO;
import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.users.presentation.dto.UserInfoDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.RoleEnum;
import com.institute.one.utilities.enums.StateEnum;
import com.institute.one.users.domain.entity.PermissionEntity;
import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.persistence.repository.INewRoleRepository;
import com.institute.one.users.persistence.repository.IPermissionRepository;
import com.institute.one.users.persistence.repository.IUserRepository;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PermissionRequestServiceImpl implements IPermissionRequestService {

    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public List<PermissionInfoDTO> verPermissionInfo() {

        ModelMapper modelMapper = new ModelMapper();
        return this.permissionRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, PermissionInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public PermissionInfoDTO verPermissionInfoById(Long id) {

        Optional<PermissionEntity> permissionEntity = this.permissionRepository.findById(id);

        if (permissionEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            PermissionEntity currentPermissionEntity = permissionEntity.get();

            return modelMapper.map(currentPermissionEntity, PermissionInfoDTO.class);

        } else {

            return new PermissionInfoDTO();

        }
    }

    @Override
    public List<PermissionInfoDTO> verPermissionInfoByName(String name) {

        ModelMapper modelMapper = new ModelMapper();

        return this.permissionRepository.findByNameContaining(name)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, PermissionInfoDTO.class))
                .collect(Collectors.toList());

        // List<PermissionInfoDTO> dtos =
        // this.permissionRepository.findByNameContaining(name)
        // .stream()
        // .filter(permission -> permission.getName().contains(name)) // Filtrar por
        // nombre
        // .map(entity -> {
        // if (entity != null) { // Verificar si la entidad no es nula
        // return modelMapper.map(entity, PermissionInfoDTO.class);
        // } else {
        // return null; // Retornar null si la entidad es nula
        // }
        // })
        // .collect(Collectors.toList());

        // return dtos;

        // List<PermissionInfoDTO> permissionList =
        // this.permissionRepository.findByNameContaining(name)
        // .stream()
        // .map(entity -> modelMapper.map(entity, PermissionInfoDTO.class))
        // .collect(Collectors.toList());

        // if (permissionList.isEmpty()) {

        // }

        // return permissionList;

    }

    @Override
    public List<PermissionInfoDTO> verPermissionInfoByState(StateEnum state) {

        ModelMapper modelMapper = new ModelMapper();

        return this.permissionRepository.findByState(state)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, PermissionInfoDTO.class))
                .collect(Collectors.toList());
    }

}
