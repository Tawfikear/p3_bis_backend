package com.formationspring.sncfchatp3.controllers;

import com.formationspring.sncfchatp3.domain.Role;
import com.formationspring.sncfchatp3.domain.User;
import com.formationspring.sncfchatp3.service.RoleService;
import com.formationspring.sncfchatp3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles(){
        List<Role> roles = service.findAllRoles();

        return ResponseEntity.ok(roles);

    }

}
