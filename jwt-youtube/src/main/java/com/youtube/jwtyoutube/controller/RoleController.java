package com.youtube.jwtyoutube.controller;

import com.youtube.jwtyoutube.entity.Role;
import com.youtube.jwtyoutube.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createRoleName"})
    public Role createNewRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }
}
