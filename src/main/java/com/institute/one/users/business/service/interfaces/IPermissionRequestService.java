package com.institute.one.users.business.service.interfaces;

import java.util.List;
import org.springframework.stereotype.Service;

import com.institute.one.users.presentation.dto.PermissionInfoDTO;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.StateEnum;

@Service
public interface IPermissionRequestService {

    List<PermissionInfoDTO> verPermissionInfo();

    PermissionInfoDTO verPermissionInfoById(Long id);

    List<PermissionInfoDTO> verPermissionInfoByName(String name);

    List<PermissionInfoDTO> verPermissionInfoByState(StateEnum state);

}
