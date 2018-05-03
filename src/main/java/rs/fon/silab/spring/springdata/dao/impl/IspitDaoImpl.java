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
import rs.fon.silab.spring.springdata.dao.IspitDao;
import rs.fon.silab.spring.springdata.domen.Ispit;

/**
 *
 * @author filip
 */
@Repository
public class IspitDaoImpl implements IspitDao {

    public IspitDaoImpl() {
    }

    protected EntityManager entityManager;

    @PersistenceContext(name = "nst_master")
    public void setEntityManager(EntityManager entityManager) {
        System.out.println("IspitDaoImpl: public void setEntityManager(EntityManager entityManager)");
        this.entityManager = entityManager;
    }

    @Override
    public Ispit findById(Integer id) {
        return (Ispit) entityManager.createQuery("select obj from Ispit obj where obj.sifraIspita=:a")
                .setParameter("a", id).getSingleResult();
    }

    @Override
    public List<Ispit> findAll() {
        return entityManager.createQuery("select obj from Ispit obj").getResultList();
    }

    @Override
    public void persist(Ispit ispit) {
        entityManager.persist(ispit);
    }

    @Override
    public void update(Ispit ispit) {
        entityManager.createQuery("update Ispit set nazivIspita =:naziv where sifraIspita =:id")
                .setParameter("naziv",ispit.getNazivIspita())
                .setParameter("id", ispit.getSifraIspita())
                .executeUpdate();
    }

    @Override
    public void deleteIspitById(int id) {
        entityManager.createQuery("delete from Ispit where sifraIspita =:a").setParameter("a", id).executeUpdate();
    }

}
