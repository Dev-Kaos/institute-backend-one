package com.institute.one.users.business.service.interfaces;

import org.springframework.stereotype.Service;

import com.institute.one.users.presentation.dto.UserDTO;

@Service
public interface IUserService {   

    // TODO: CRUD

    UserDTO save(UserDTO userDTO);

    UserDTO update(Long id, UserDTO userDTO);

    String delete(Long id);

}
