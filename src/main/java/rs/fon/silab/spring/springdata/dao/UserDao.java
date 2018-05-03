/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.dao;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.User;

/**
 *
 * @author filip
 */
public interface UserDao {

    User findById(Integer id);

    void persist(User user);

    void update(User user);

    void deleteUserById(int id);

    List<User> findAll();

    User findUserByName(String name);
}
