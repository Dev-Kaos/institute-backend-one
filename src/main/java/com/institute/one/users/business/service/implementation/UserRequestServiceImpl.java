package com.institute.one.users.business.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.institute.one.users.business.service.interfaces.IUserRequestService;
import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.persistence.repository.IUserRepository;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserRequestServiceImpl implements IUserRequestService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {

        Optional<UserEntity> userEntity = this.userRepository.findById(id);

        if (userEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            UserEntity currentUser = userEntity.get();

            return modelMapper.map(currentUser, UserDTO.class);

        } else {

            return new UserDTO();

        }
    }

    @Override
    public List<UserDTO> findAllByNameContaining(String name) {

        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findAllBySurnameContaining(String surname) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllBySurnameContaining'");
    }

    @Override
    public List<UserDTO> findByDocType(DocTypeEnum docTypeEnum) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDocType'");
    }

    @Override
    public List<UserDTO> findByDocNumberContaining(String docNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDocNumberContaining'");
    }

    @Override
    public List<UserDTO> findByEmailContaining(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmailContaining'");
    }

    @Override
    public List<UserDTO> findByPhoneContaining(String phone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPhoneContaining'");
    }

    @Override
    public List<UserDTO> findByGender(GenderEnum genderEnum) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByGender'");
    }

    @Override
    public List<UserDTO> findByNicknameContaining(String phone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNicknameContaining'");
    }

    @Override
    public List<UserDTO> findByState(StateEnum stateEnum) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByState'");
    }

}
