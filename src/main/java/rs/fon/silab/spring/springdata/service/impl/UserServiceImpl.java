/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.fon.silab.spring.springdata.dao.UserDao;
import rs.fon.silab.spring.springdata.domen.User;
import rs.fon.silab.spring.springdata.service.UserService;

/**
 *
 * @author filip
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findUserByName(username);
    }
    
    @Override
    public void saveUser(User user) {
        userDao.persist(user);
    }

    @Override
    public void updateUser(User dbUser, User user) {
        dbUser.setPassword(user.getPassword());
        dbUser.setUsername(user.getUsername());
        
        userDao.update(dbUser);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public boolean isUserExist(User user) {
        return userDao.findUserByName(user.getUsername()) != null;
    }

}
