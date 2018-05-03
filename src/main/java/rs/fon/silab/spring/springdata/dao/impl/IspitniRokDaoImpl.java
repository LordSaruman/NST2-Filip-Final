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
import rs.fon.silab.spring.springdata.dao.IspitniRokDao;
import rs.fon.silab.spring.springdata.domen.IspitniRok;

/**
 *
 * @author filip
 */
@Repository
public class IspitniRokDaoImpl implements IspitniRokDao {

    public IspitniRokDaoImpl() {
    }

    protected EntityManager entityManager;

    @PersistenceContext(name = "nst_master")
    public void setEntityManager(EntityManager entityManager) {
        System.out.println("IspitniRokDaoImpl: public void setEntityManager(EntityManager entityManager)");
        this.entityManager = entityManager;
    }

    @Override
    public IspitniRok findById(Integer id) {
        return (IspitniRok) entityManager.createQuery("select obj from IspitniRok obj where obj.sifraIspitnogRoka=:a")
                .setParameter("a", id).getSingleResult();
    }

    @Override
    public List<IspitniRok> findAll() {
        return entityManager.createQuery("select obj from IspitniRok obj").getResultList();
    }

    @Override
    public void persist(IspitniRok ispitniRok) {
        entityManager.persist(ispitniRok);
    }

    @Override
    public void update(IspitniRok ispitniRok) {
        entityManager.createQuery("update IspitniRok set nazivIspitnogRoka =:naziv where sifraIspitnogRoka =:id")
                .setParameter("naziv", ispitniRok.getNazivIspitnogRoka())
                .setParameter("id", ispitniRok.getSifraIspitnogRoka())
                .executeUpdate();
    }

    @Override
    public void deleteIspitniRokById(int id) {
        entityManager.createQuery("delete from IspitniRok where sifraIspitnogRoka =:a").setParameter("a", id).executeUpdate();
    }

}
