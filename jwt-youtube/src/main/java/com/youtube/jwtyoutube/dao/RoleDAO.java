package com.youtube.jwtyoutube.dao;

import com.youtube.jwtyoutube.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends CrudRepository<Role, String> {

}
