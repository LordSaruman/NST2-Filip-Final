/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.service;

import com.nst2project.model.User;
import java.util.List;

/**
 *
 * @author filip
 */
public interface UserService {

    User findById(int id);

    List<User> findAllUsers();

    User findByUsername(String username);

    void saveUser(User user);

    void updateUser(User dbUser, User user);

    void deleteUserById(int id);

    public boolean isUserExist(User user);
}
