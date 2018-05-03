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
import rs.fon.silab.spring.springdata.dao.IspitDao;
import rs.fon.silab.spring.springdata.domen.Ispit;
import rs.fon.silab.spring.springdata.service.IspitService;

/**
 *
 * @author filip
 */
@Service
@Transactional
public class IspitServiceImpl implements IspitService {

    @Autowired
    private IspitDao ispitDao;

    public IspitServiceImpl() {
    }

    @Override
    public Ispit findById(int id) {
        return ispitDao.findById(id);
    }

    @Override
    public List<Ispit> findAllIspit() {
        return ispitDao.findAll();
    }

    @Override
    public void saveIspit(Ispit ispit) {
        ispitDao.persist(ispit);
    }

    @Override
    public void updateIspit(Ispit dbIspit, Ispit ispit) {
        dbIspit.setNazivIspita(ispit.getNazivIspita());
        
        ispitDao.persist(dbIspit);
    }

    @Override
    public void deleteSIspitById(int id) {
        ispitDao.deleteIspitById(id);
    }

}
