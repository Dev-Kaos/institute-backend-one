package com.institute.one.users.business.service.interfaces;

import java.util.List;
import org.springframework.stereotype.Service;

import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.users.presentation.dto.UserInfoDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.StateEnum;

@Service
public interface IUserRequestService {



    List<UserDTO> ver();
    
    List<UserInfoDTO> verTodo();
    

    List<UserDTO> verUsuarios();   

    UserDTO findById(Long id);

    List<UserDTO> findAllByNameContaining(String name);

    List<UserDTO> findAllBySurnameContaining(String surname);

    List<UserDTO> findByDocType(DocTypeEnum docTypeEnum);

    List<UserDTO> findByDocNumberContaining(String docNumber);

    List<UserDTO> findByEmailContaining(String email);

    List<UserDTO> findByPhoneContaining(String phone);

    List<UserDTO> findByGender(GenderEnum genderEnum);

    List<UserDTO> findByNicknameContaining(String phone);

    // TODO: hacer el metodo para fecha de nacimiento

    List<UserDTO> findByState(StateEnum stateEnum);

}
