package com.institute.one.permissions.presentation.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.institute.one.permissions.bussiness.service.interfaces.IPermissionRequestService;
import com.institute.one.permissions.bussiness.service.interfaces.IPermissionService;
import com.institute.one.permissions.presentation.dto.PermissionInfoDTO;
import com.institute.one.utilities.enums.StateEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/permisos")
@PreAuthorize("denyAll()")
public class PermissionController {

    @Autowired
    private IPermissionRequestService permissionRequestService;
    
    @Autowired
    private IPermissionService permissionService;
    
    //TODO: REQUEST
    // find all permisos info

    @GetMapping("/info")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfo() {

        return new ResponseEntity<>(this.permissionRequestService.verPermissionInfo(), HttpStatus.OK);

    }

    // find all permisos info by id
    @GetMapping("/verId/{id}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<PermissionInfoDTO> verPermissionInfoById(@PathVariable Long id) {

        return new ResponseEntity<>(this.permissionRequestService.verPermissionInfoById(id), HttpStatus.OK);

    }

    // find all permisos info by name containing
    @GetMapping("/verNombre/{name}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfoByName(@PathVariable String name) {

        return new ResponseEntity<>(this.permissionRequestService.verPermissionInfoByName(name), HttpStatus.OK);

    }

    // find all permisos info by name containing
    @GetMapping("/verEstado/{state}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfoByState(@PathVariable String state) {

        StateEnum[] states = StateEnum.values();
        for (StateEnum state1 : states) {
            if (state1.name().equals(state)) {

                StateEnum stateEnum = StateEnum.valueOf(state);

                return new ResponseEntity<>(this.permissionRequestService.verPermissionInfoByState(stateEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    //TODO: CRUD
    // create user
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('CREAR')")
    public ResponseEntity<PermissionInfoDTO> savePermission(@RequestBody PermissionInfoDTO permissionInfoDTO) {

        return new ResponseEntity<>(this.permissionService.save(permissionInfoDTO), HttpStatus.CREATED);

    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('ACTUALIZAR')")
    public ResponseEntity<PermissionInfoDTO> updatePermission(@RequestBody PermissionInfoDTO permissionInfoDTO,
            @PathVariable Long id) {

        return new ResponseEntity<>(this.permissionService.update(id, permissionInfoDTO), HttpStatus.OK);

    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasAuthority('BORRAR')")
    public ResponseEntity<String> deletePermission(@PathVariable Long id) {
        String message = this.permissionService.delete(id); // Call service method
        return ResponseEntity.ok(message); // Return message in response body
    }

}
