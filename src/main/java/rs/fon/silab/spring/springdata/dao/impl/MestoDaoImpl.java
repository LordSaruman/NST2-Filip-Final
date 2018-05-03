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
import rs.fon.silab.spring.springdata.dao.MestoDao;
import rs.fon.silab.spring.springdata.domen.Mesto;

/**
 *
 * @author user
 */
@Repository
public class MestoDaoImpl implements MestoDao {

    public MestoDaoImpl() {
        System.out.println("Constructor MestoDaoImpl....");
    }

    protected EntityManager entityManager;

    @PersistenceContext(name = "nst_master")
    public void setEntityManager(EntityManager entityManager) {
        System.out.println("MestoDaoImpl: public void setEntityManager(EntityManager entityManager)");
        this.entityManager = entityManager;
    }

    @Override
    public List<Mesto> findAll() {
        System.out.println("MestoDaoImpl: public List<Mesto> getAll()");
        return entityManager.createQuery("select obj from Mesto obj").getResultList();
    }

    @Override
    public Mesto findById(Integer id) {
        return (Mesto) entityManager.createQuery("select obj from Mesto obj where obj.Ptt=:a").setParameter("a", id).getSingleResult();
    }

    @Override
    public void persist(Mesto mesto) {
        entityManager.persist(mesto);
    }

    @Override
    public void update(Mesto mesto) {
        entityManager.createQuery("update Mesto set naziv =:naziv where Ptt =:id")
                .setParameter("naziv", mesto.getNaziv())
                .setParameter("id", mesto.getPtt())
                .executeUpdate();
    }

    @Override
    public void deleteMestoById(int id) {
        entityManager.createQuery("delete from Mesto where Ptt =:a").setParameter("a", id).executeUpdate();
    }
}
