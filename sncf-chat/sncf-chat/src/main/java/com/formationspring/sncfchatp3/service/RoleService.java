package com.formationspring.sncfchatp3.service;

import com.formationspring.sncfchatp3.domain.Role;
import com.formationspring.sncfchatp3.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }
}
