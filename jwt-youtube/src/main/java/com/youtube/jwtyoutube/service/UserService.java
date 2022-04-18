package com.youtube.jwtyoutube.service;

import com.youtube.jwtyoutube.dao.RoleDAO;
import com.youtube.jwtyoutube.dao.UserDAO;
import com.youtube.jwtyoutube.entity.Role;
import com.youtube.jwtyoutube.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
        Role role = roleDao.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public void initRolesAndUser(){
        //write the logic to store 2 roles and 2 users
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        /*User user = new User();
        user.setUserFirstName("odell");
        user.setUserLastName("davis");
        user.setUserName("ode123");
        user.setUserPassword(getEncodedPassword("ode@pass"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);*/

    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
