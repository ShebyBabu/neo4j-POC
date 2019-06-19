package com.stackroute.i2ps.controller;

import com.stackroute.i2ps.domain.Movie;
import com.stackroute.i2ps.domain.User;
import com.stackroute.i2ps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value= "/api/v1/i2ps/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @PostMapping(value = "/user/saveUser")
    public User saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        return userService.saveUser(user.getId(), user.getName(), user.getAge());
        //responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);

    }

//    @DeleteMapping("/user/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "Deleted User";
//
//
//    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted User";


    }

    @GetMapping("/getUser/{name}")
    public User getUser(@PathVariable String name) {

        return userService.findByName(name);
    }

    @DeleteMapping("/deleteUsers")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "Deleted All Users";


    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(id,user.getName(),user.getAge());

    }


    @GetMapping("/user/actedMoviesList")
    public User ratedMoviesList(@RequestBody User user) {
        return userService.actedMoviesList();
    }

//    @PostMapping("/user/{id}")
//    public ResponseEntity actedMovies(@PathVariable Long id)   {
//        ResponseEntity responseEntity;
//        userService.actedMovies(id);
//        responseEntity=new ResponseEntity("Created",HttpStatus.CREATED);
//        return responseEntity;
//    }

//    @PostMapping("/user/{uName}/{mName}")
//    public ResponseEntity actedMovies(@PathVariable String uName, @PathVariable String mName)   {
//        ResponseEntity responseEntity;
//        userService.actedMovies(uName,mName);
//        responseEntity=new ResponseEntity("Created",HttpStatus.CREATED);
//        return responseEntity;
//    }

    @PostMapping("/map")
    public ResponseEntity actedMovies()   {
        ResponseEntity responseEntity;
        userService.createRelation();
        responseEntity=new ResponseEntity("Created",HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/deleteMap")
    public String deleteAllMapping() {
        userService.deleteRelation();
        return "Deleted All Relation";


    }

}

