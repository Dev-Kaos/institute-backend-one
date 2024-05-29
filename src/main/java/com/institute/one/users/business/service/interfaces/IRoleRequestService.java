package com.institute.one.users.business.service.interfaces;

import java.util.List;
import org.springframework.stereotype.Service;

import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.presentation.dto.RoleRequestDTO;
import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.users.presentation.dto.UserInfoDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.RoleEnum;
import com.institute.one.utilities.enums.StateEnum;

@Service
public interface IRoleRequestService {

    List<RoleRequestDTO> findAll();
    
    RoleRequestDTO findById(Long id);

    RoleRequestDTO findByRoleEnum(RoleEnum roleEnum);

}
