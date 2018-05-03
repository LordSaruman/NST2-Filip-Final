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
import rs.fon.silab.spring.springdata.dao.PolaganjeDao;
import rs.fon.silab.spring.springdata.domen.Ispit;
import rs.fon.silab.spring.springdata.domen.IspitniRok;
import rs.fon.silab.spring.springdata.domen.Polaganje;
import rs.fon.silab.spring.springdata.domen.Student;
import rs.fon.silab.spring.springdata.service.PolaganjeService;

/**
 *
 * @author filip
 */
@Service
@Transactional
public class PolaganjeServiceImpl implements PolaganjeService {

    @Autowired
    private PolaganjeDao polaganjeDao;

    public PolaganjeServiceImpl() {
    }

    @Override
    public Polaganje findById(Integer id) {
        return polaganjeDao.findById(id);
    }

    @Override
    public List<Polaganje> findAll() {
        return polaganjeDao.findAll();
    }

    @Override
    public List<Polaganje> findAllForStudent(Student student) {
        return polaganjeDao.findAllForStudent(student);
    }

    @Override
    public List<Polaganje> findAllForIspit(Ispit ispit) {
        return polaganjeDao.findAllForIspit(ispit);
    }

    @Override
    public List<Polaganje> findAllForIspitniRok(IspitniRok ispitniRok) {
        return polaganjeDao.findAllForIspitniRok(ispitniRok);
    }

    @Override
    public void persist(Polaganje polaganje) {
        polaganjeDao.persist(polaganje);
    }

    @Override
    public void update(Polaganje polaganje) {
        polaganjeDao.update(polaganje);
    }

}
