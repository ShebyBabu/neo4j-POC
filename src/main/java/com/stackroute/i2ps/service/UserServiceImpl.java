package com.stackroute.i2ps.service;

import com.stackroute.i2ps.domain.User;
import com.stackroute.i2ps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;



    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }



    @Override
    public User saveUser(Long userId, String userName, int userAge) {
        User savedUser = null;
        savedUser = userRepository.saveNode(userId,userName,userAge);


        return savedUser;
    }


    @Override
    public void deleteUser(Long id) {
//Long userId=id;
//User u=

        userRepository.delete(id);

    }

    @Override
    public User findByName(String name) {

        return userRepository.findByName(name);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public User updateUser(Long id, String name, int age)   {

        return userRepository.updateUser(id,name,age);
    }

    @Override
    public User actedMoviesList()  {
        return userRepository.getActedMoviesList();
    }

    @Override
    public User createRelation()   {
        return userRepository.createRelationship();
    }

    @Override
    public void deleteRelation()    {
        userRepository.deleteRelationship();
    }


}
