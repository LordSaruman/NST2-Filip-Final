/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import rs.fon.silab.spring.springdata.dao.UserDao;
import rs.fon.silab.spring.springdata.domen.User;

/**
 *
 * @author filip
 */
@Repository
public class UserDaoImpl implements UserDao{

    public UserDaoImpl() {
        System.out.println("Constructor UserDaoImpl....");
    }
    
    protected EntityManager entityManager;

    @PersistenceContext(name = "nst_master")
    public void setEntityManager(EntityManager entityManager) {
        System.out.println("UserDaoImpl: public void setEntityManager(EntityManager entityManager)");
        this.entityManager = entityManager;
    }

    @Override
    public User findById(Integer id) {
        return (User) entityManager.createQuery("select obj from User obj where obj.UserId=:a").setParameter("a", id).getSingleResult();
    }

    @Override
    public void persist(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.createQuery("update User set username =:user, password =:pass where UserId =:id")
                .setParameter("user", user.getUsername())
                .setParameter("pass", user.getPassword())
                .setParameter("id", user.getUserId())
                .executeUpdate();
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.createQuery("delete from User where UserId =:a").setParameter("a", id).executeUpdate();
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select obj from User obj").getResultList();
    }

    @Override
    public User findUserByName(String name) {
        return (User) entityManager.createQuery("select obj from User obj where obj.username:a").setParameter("a", name).getSingleResult();
    }
    
}
