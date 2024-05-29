package com.institute.one.users.business.service.interfaces;

import org.springframework.stereotype.Service;

import com.institute.one.users.presentation.dto.PermissionInfoDTO;

@Service
public interface IPermissionService {

    // TODO: CRUD

    PermissionInfoDTO save(PermissionInfoDTO permissionInfoDTO);

    PermissionInfoDTO update(Long id, PermissionInfoDTO permissionInfoDTO);

    String delete(Long id);

}
