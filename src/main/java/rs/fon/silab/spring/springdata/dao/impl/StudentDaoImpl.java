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
import rs.fon.silab.spring.springdata.dao.StudentDao;
import rs.fon.silab.spring.springdata.domen.Mesto;
import rs.fon.silab.spring.springdata.domen.Student;

/**
 *
 * @author filip
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    public StudentDaoImpl() {
    }

    protected EntityManager entityManager;

    @PersistenceContext(name = "nst_master")
    public void setEntityManager(EntityManager entityManager) {
        System.out.println("StudentDaoImpl: public void setEntityManager(EntityManager entityManager)");
        this.entityManager = entityManager;
    }

    @Override
    public Student findById(String id) {
        return (Student) entityManager.createQuery("select obj from Student obj inner join obj.mesto as m on obj.mesto = m where obj.brInd=:a")
                .setParameter("a", id).getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("select obj from Student obj").getResultList();
    }

    @Override
    public List<Student> findAllForMesto(Mesto mesto) {
        return entityManager.createQuery("select obj from Student obj where obj.mesto =:a")
                .setParameter("a", mesto)
                .getResultList();
    }

    @Override
    public void persist(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.createQuery("update Student set ime =:ime, prezime =:prezime, mesto =:mesto where brInd =:id")
                .setParameter("ime", student.getIme())
                .setParameter("prezime", student.getPrezime())
                .setParameter("mesto", student.getMesto())
                .setParameter("id", student.getBrInd())
                .executeUpdate();
    }

}
