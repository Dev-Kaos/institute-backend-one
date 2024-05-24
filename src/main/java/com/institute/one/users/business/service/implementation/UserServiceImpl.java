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
