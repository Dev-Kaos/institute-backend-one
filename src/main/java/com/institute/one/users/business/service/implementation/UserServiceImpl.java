package com.institute.one.users.business.service.implementation;

import java.util.List;

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
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

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

    @Override
    public UserDTO save(UserDTO userDTO) {

        try {

            ModelMapper modelMapper = new ModelMapper();
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            this.userRepository.save(userEntity);
            return userDTO;

        } catch (Exception e) {

            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {

        // Optional<UserEntity> userEntity = this.userRepository.findById(id);

        // if (userEntity.isPresent()) {

        //     UserEntity currentUserEntity = userEntity.get();
        //     // TODO: SECURITY
            
        //     currentUserEntity.setUsername(userDTO.getUsername());
        //     currentUserEntity.setPassword(userDTO.getPassword());
        //     currentUserEntity.setEnabled(userDTO.isEnabled());
        //     currentUserEntity.setAccountNoExpired(userDTO.isAccountNoExpired());
        //     currentUserEntity.setAccountNoLocked(userDTO.isAccountNoLocked());
        //     currentUserEntity.setCredentialNoExpired(userDTO.isCredentialNoExpired());
        //     currentUserEntity.setRoles(userDTO.getRoles());

        //     // TODO: Others

        //     currentUserEntity.setName(userDTO.getName());
        //     currentUserEntity.setSurname(userDTO.getSurname());
        //     currentUserEntity.setDocType(userDTO.getDocType());
        //     currentUserEntity.setDocNumber(userDTO.getDocNumber());
        //     currentUserEntity.setBirthDate(userDTO.getBirthDate());
        //     currentUserEntity.setEmail(userDTO.getEmail());
        //     currentUserEntity.setPhone(userDTO.getPhone());
        //     currentUserEntity.setGender(userDTO.getGender());
        //     currentUserEntity.setProfileImage(userDTO.getProfileImage());
        //     currentUserEntity.setNickname(userDTO.getNickname());
        //     currentUserEntity.setState(userDTO.getState());

        //     this.userRepository.save(currentUserEntity);


        //     ModelMapper modelMapper = new ModelMapper();
        //     return modelMapper.map(currentUserEntity, UserDTO.class);

        // } else {

        //     throw new IllegalArgumentException("La jornada que se quiere actualizar no existe");

        // }
        return new UserDTO();
    }

    @Override
    public String delete(Long id) {
        
        Optional<UserEntity> userEntity = this.userRepository.findById(id);

        if (userEntity.isPresent()) {

            UserEntity currentUserEntity = userEntity.get();

            this.userRepository.delete(currentUserEntity);

            return "El usuario ha sido eliminado";

        } else {
            return "No se pudo eliminar el usuario";
        }
    }


}
