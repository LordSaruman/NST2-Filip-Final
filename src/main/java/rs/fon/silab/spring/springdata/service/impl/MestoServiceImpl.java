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
import rs.fon.silab.spring.springdata.dao.MestoDao;
import rs.fon.silab.spring.springdata.domen.Mesto;
import rs.fon.silab.spring.springdata.service.MestoService;

/**
 *
 * @author user
 */
@Service
@Transactional
public class MestoServiceImpl implements MestoService {

    @Autowired
    private MestoDao mestoDao;

    public MestoServiceImpl() {
        System.out.println("Constructor MestoServiceImpl....");
    }

    @Override
    public Mesto findById(int id) {
        return mestoDao.findById(id);
    }

    @Override
    public List<Mesto> findAllMesto() {
        return mestoDao.findAll();
    }

    @Override
    public void saveMesto(Mesto mesto) {
        mestoDao.persist(mesto);
    }

    @Override
    public void updateMesto(Mesto dbMesto, Mesto mesto) {
        dbMesto.setNaziv(mesto.getNaziv());
        
        mestoDao.update(dbMesto);
    }

    @Override
    public void deleteMestoById(int id) {
        mestoDao.deleteMestoById(id);
    }

}
