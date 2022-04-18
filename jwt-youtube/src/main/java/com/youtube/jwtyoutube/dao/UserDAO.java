package com.youtube.jwtyoutube.dao;

import com.youtube.jwtyoutube.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, String> {
}
