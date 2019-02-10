package com.demo.basicApp.dao;

import com.demo.basicApp.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserDAO extends CrudRepository <User, Long>{
    Optional<User> findUserByName(String userName);
}
