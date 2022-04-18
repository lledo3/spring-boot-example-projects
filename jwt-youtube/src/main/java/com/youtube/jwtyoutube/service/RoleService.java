package com.youtube.jwtyoutube.service;

import com.youtube.jwtyoutube.dao.RoleDAO;
import com.youtube.jwtyoutube.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDao;

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
