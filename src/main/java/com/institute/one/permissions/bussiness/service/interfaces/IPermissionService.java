package com.institute.one.permissions.bussiness.service.interfaces;

import org.springframework.stereotype.Service;

import com.institute.one.permissions.presentation.dto.PermissionInfoDTO;

@Service
public interface IPermissionService {

    // TODO: CRUD

    PermissionInfoDTO save(PermissionInfoDTO permissionInfoDTO);

    PermissionInfoDTO update(Long id, PermissionInfoDTO permissionInfoDTO);

    String delete(Long id);

}
