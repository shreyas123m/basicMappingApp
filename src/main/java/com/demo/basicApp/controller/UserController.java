package com.demo.basicApp.controller;

import com.demo.basicApp.dto.ProductDTO;
import com.demo.basicApp.dto.UserDTO;
import com.demo.basicApp.model.Product;
import com.demo.basicApp.model.User;
import com.demo.basicApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1")
public class UserController {

    @Autowired
    UserService userService;

//    @RequestMapping("/hello")
//    public String testMethod() {
//        return "Hello World!!";
//    }


    @RequestMapping("/getUsers")
    public List<UserDTO> getAllUsers() {
        User user1 = new User();
        user1.setName("Shreyas");
        user1.setEmail("shreyas@Test.com");
        user1.setPassword("123");

        User user2 = new User();
        user2.setName("Sagar");
        user2.setEmail("Sagar@Test.com");
        user2.setPassword("456");

        User user3 = new User();
        user3.setName("Akshit");
        user3.setEmail("Akshit@Test.com");
        user3.setPassword("789");

        User user4 = new User();
        user4.setName("Rush");
        user4.setEmail("Rush@Test.com");
        user4.setPassword("573");

        List<User> userList = new ArrayList<>(Arrays.asList(
           user1,
           user2,
           user3,
           user4
        ));

        return userService.getAllUsers(userList);
    }


    //Get user by id
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id) {
//        int userId = Integer.parseInt(id);
        return userService.getSingleUser(id);
    }

    //Get user by name
    @RequestMapping(value = "/userName/{name}", method = RequestMethod.GET)
    public  User getUserByUserName(@PathVariable("name")  String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping(value = "/userName/{name}", method = RequestMethod.POST)
    public  User getUserByUserName1(@PathVariable("name")  String name) {
        return userService.getUserByName(name);
    }

    //Save User and their products
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) {
        Product product1 = new Product();
        product1.setProductName("Car");
        product1.setProductPrice(2550.00);

        Product product2 = new Product();
        product2.setProductName("Phone");
        product2.setProductPrice(233.87);

        Product product3 = new Product();
        product3.setProductName("Book");
        product3.setProductPrice(12.50);

        user.setProductList(Arrays.asList(
                product1,
                product2,
                product3
        ));
        return userService.insertUser(user);
    }

}
