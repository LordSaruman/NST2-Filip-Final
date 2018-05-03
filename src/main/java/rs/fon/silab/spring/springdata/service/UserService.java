/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.User;

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
