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
import rs.fon.silab.spring.springdata.dao.PolaganjeDao;
import rs.fon.silab.spring.springdata.domen.Ispit;
import rs.fon.silab.spring.springdata.domen.IspitniRok;
import rs.fon.silab.spring.springdata.domen.Polaganje;
import rs.fon.silab.spring.springdata.domen.Student;

/**
 *
 * @author filip
 */
@Repository
public class PolaganjeDaoImpl implements PolaganjeDao {

    public PolaganjeDaoImpl() {
    }

    protected EntityManager entityManager;

    @PersistenceContext(name = "nst_master")
    public void setEntityManager(EntityManager entityManager) {
        System.out.println("PolaganjeDaoImpl: public void setEntityManager(EntityManager entityManager)");
        this.entityManager = entityManager;
    }

    @Override
    public Polaganje findById(Integer id) {
        return (Polaganje) entityManager.createQuery("select obj from Polaganje obj inner join obj.student as s on obj.student inner join obj.ispit as isp on obj.ispit inner join obj.ispitniRok as ir on obj.ispitniRok = m where obj.idPolaganje=:a")
                .setParameter("a", id).getSingleResult();
    }

    @Override
    public List<Polaganje> findAll() {
        return entityManager.createQuery("select obj from Polaganje obj").getResultList();
    }

    @Override
    public List<Polaganje> findAllForIspit(Ispit ispit) {
        return entityManager.createQuery("select obj from Polaganje obj inner join obj.student as s on obj.student = s inner join obj.ispit as isp on obj.ispit = isp inner join obj.ispitniRok as ir on obj.ispitniRok = ir where obj.ispit=:a")
                .setParameter("a", ispit).getResultList();
    }

    @Override
    public List<Polaganje> findAllForIspitniRok(IspitniRok ispitniRok) {
        return entityManager.createQuery("select obj from Polaganje obj inner join obj.student as s on obj.student = s inner join obj.ispit as isp on obj.ispit = isp inner join obj.ispitniRok as ir on obj.ispitniRok = ir where obj.ispitniRok=:a")
                .setParameter("a", ispitniRok).getResultList();
    }

    @Override
    public List<Polaganje> findAllForStudent(Student student) {
        return entityManager.createQuery("select obj from Polaganje obj inner join obj.student as s on obj.student = s inner join obj.ispit as isp on obj.ispit = isp inner join obj.ispitniRok as ir on obj.ispitniRok = ir where obj.student=:a")
                .setParameter("a", student).getResultList();
    }

    @Override
    public void persist(Polaganje polaganje) {
        entityManager.persist(polaganje);
    }

    @Override
    public void update(Polaganje polaganje) {
        entityManager.createQuery("update Polaganje set student =:student, ispitniRok =:ispitniRok, ispit =:ispit, ocena =:ocena, datum =:datum where idPolaganje =:id")
                .setParameter("student", polaganje.getStudent())
                .setParameter("ispitniRok", polaganje.getIspitniRok())
                .setParameter("ispit", polaganje.getIspit())
                .setParameter("ocena", polaganje.getOcena())
                .setParameter("datum", polaganje.getDatum())
                .setParameter("id", polaganje.getIdPolaganje())
                .executeUpdate();
    }

}
