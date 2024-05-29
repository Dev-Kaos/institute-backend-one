package com.institute.one.users.presentation.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.institute.one.permissions.bussiness.service.interfaces.IPermissionRequestService;
import com.institute.one.permissions.bussiness.service.interfaces.IPermissionService;
import com.institute.one.permissions.presentation.dto.PermissionInfoDTO;
import com.institute.one.users.business.service.interfaces.IRoleRequestService;
import com.institute.one.users.business.service.interfaces.IUserRequestService;
import com.institute.one.users.business.service.interfaces.IUserService;
import com.institute.one.users.persistence.repository.INewRoleRepository;
import com.institute.one.users.presentation.dto.RoleRequestDTO;
import com.institute.one.users.presentation.dto.UserDTO;
import com.institute.one.users.presentation.dto.UserInfoDTO;
import com.institute.one.utilities.enums.StateEnum;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/usuarios")
@PreAuthorize("denyAll()")
public class UserController {
    

    @Autowired
    private IRoleRequestService roleRequestService;

    @Autowired
    private IUserRequestService userRequestService;

    @Autowired
    private IUserService userService;
 

    // // find role By Id
    // @GetMapping("/roles/role/{roleEnum}")
    // @PreAuthorize("hasAuthority('LEER')")
    // public ResponseEntity<List<UserDTO>> verRol() {

    // return new ResponseEntity<>(this.userRequestService.ver(), HttpStatus.OK);

    // }

    // TODO: Roles
    // find all roles
    @GetMapping("/roles")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<RoleRequestDTO>> verRoles() {

        return new ResponseEntity<>(this.roleRequestService.findAll(), HttpStatus.OK);

    }

    // find all roles
    @GetMapping("/rolesInfo")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<RoleRequestDTO>> verRolesInfo() {

        return new ResponseEntity<>(this.roleRequestService.findAll(), HttpStatus.OK);

    }

    // find roles by Id
    @GetMapping("/roles/{id}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<RoleRequestDTO> verRol(@PathVariable Long id) {

        return new ResponseEntity<>(this.roleRequestService.findById(id), HttpStatus.OK);

    }

    // find role By Id
    @GetMapping("/roles/role/{roleEnum}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserDTO>> verRol() {

        return new ResponseEntity<>(this.userRequestService.ver(), HttpStatus.OK);

    }

    // TODO: Usuarios

    // find all

    @GetMapping("/verTodo")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verTodo() {

        return new ResponseEntity<>(this.userRequestService.verTodo(), HttpStatus.OK);

    }

    // find all
    @GetMapping("/verUsuarios")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserDTO>> verUsuarios() {

        return new ResponseEntity<>(this.userRequestService.verUsuarios(), HttpStatus.OK);

    }

    // // find all
    // @GetMapping("/verInfo")
    // @PreAuthorize("hasAuthority('LEER')")
    // public ResponseEntity<List<UserInfoDTO>> verUsuarios() {

    // return new ResponseEntity<>(this.userRequestService.verUsuarios(),
    // HttpStatus.OK);

    // }

    // find by id
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/ver/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {

        return new ResponseEntity<>(this.userRequestService.findById(id), HttpStatus.OK);

    }

    // create user
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {

        return new ResponseEntity<>(this.userService.save(userDTO), HttpStatus.CREATED);

    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable Long id) {

        return new ResponseEntity<>(this.userService.update(id, userDTO), HttpStatus.OK);

    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.delete(id), HttpStatus.NO_CONTENT);
    }

}
