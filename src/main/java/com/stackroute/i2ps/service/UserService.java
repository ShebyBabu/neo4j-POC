package com.stackroute.i2ps.service;

import com.stackroute.i2ps.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserService {
    public Collection<User> getAll();

    public User saveUser(Long userId, String userName, int userAge);
    public void deleteUser(Long id);
   public User findByName(String name);
   public void deleteAllUsers();
   public User updateUser(Long id, String name, int age);
   public User actedMoviesList();
   public User createRelation();
   public void deleteRelation();


}
