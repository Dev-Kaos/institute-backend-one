package com.institute.one.users.business.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.institute.one.users.business.service.interfaces.IRoleRequestService;
import com.institute.one.users.business.service.interfaces.IUserRequestService;
import com.institute.one.users.presentation.dto.RoleRequestDTO;
import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.users.presentation.dto.UserInfoDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.RoleEnum;
import com.institute.one.utilities.enums.StateEnum;
import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.persistence.repository.INewRoleRepository;
import com.institute.one.users.persistence.repository.IUserRepository;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleRequestServiceImpl implements IRoleRequestService {

    @Autowired
    private INewRoleRepository newRoleRepository;
    @Override
    public List<RoleRequestDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();
        return this.newRoleRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, RoleRequestDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public RoleRequestDTO findById(Long id) {

        Optional<RoleEntity> roleEntity = this.newRoleRepository.findById(id);

        if (roleEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            RoleEntity currentRoleEntity = roleEntity.get();

            return modelMapper.map(currentRoleEntity, RoleRequestDTO.class);

        } else {

            return new RoleRequestDTO();

        }

    }

    @Override
    public RoleRequestDTO findByRoleEnum(RoleEnum roleEnum) {

        Optional<RoleEntity> roleEntity = this.newRoleRepository.findByRoleEnum(roleEnum);

        if (roleEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            RoleEntity currentRoleEntity = roleEntity.get();

            return modelMapper.map(currentRoleEntity, RoleRequestDTO.class);

        } else {

            return new RoleRequestDTO();

        }

    }

}
