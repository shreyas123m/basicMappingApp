package com.demo.basicApp.service;

import com.demo.basicApp.dao.UserDAO;
import com.demo.basicApp.dto.UserDTO;
import com.demo.basicApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;


    public List<UserDTO> getAllUsers (List<User> userList) {
//        UserDTO userDTO = new UserDTO();
        List<UserDTO> userDTOS = new ArrayList<>();
        userDAO.saveAll(userList).forEach(user -> userDTOS.add(marshal(user)));
        return userDTOS;
    }

    //Get single user by id
    public User getSingleUser (long id) {
        Optional<User> byId = userDAO.findById(id);
        User user = byId.get();
        return user;
//        return unMarshal(userDAO.findById(id));
    }

    //Getting the user by name
    public User getUserByName(String name) {
        Optional<User> userByName = userDAO.findUserByName(name);
        User user = userByName.get();
        return user;
    }

    //Adding user
    public User insertUser(User user) {
        return userDAO.save(user);
    }


    public UserDTO marshal(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public User unMarshal(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        return user;
    }

}
