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
import rs.fon.silab.spring.springdata.dao.IspitniRokDao;
import rs.fon.silab.spring.springdata.domen.IspitniRok;
import rs.fon.silab.spring.springdata.service.IspitniRokService;

/**
 *
 * @author filip
 */
@Service
@Transactional
public class IspitniRokServiceImpl implements IspitniRokService{

    @Autowired
    private IspitniRokDao ispitniRokDao;

    public IspitniRokServiceImpl() {
    }
    
    
    @Override
    public IspitniRok findById(int id) {
        return ispitniRokDao.findById(id);
    }

    @Override
    public List<IspitniRok> findAllIspitniRok() {
        return ispitniRokDao.findAll();
    }

    @Override
    public void saveIspitniRok(IspitniRok ispitniRok) {
        ispitniRokDao.persist(ispitniRok);
    }

    @Override
    public void updateIspitniRok(IspitniRok dbIspitniRok, IspitniRok ispitniRok) {
        dbIspitniRok.setNazivIspitnogRoka(ispitniRok.getNazivIspitnogRoka());
        
        ispitniRokDao.persist(dbIspitniRok);
    }

    @Override
    public void deleteIspitniRokById(int id) {
        ispitniRokDao.deleteIspitniRokById(id);
    }
    
}
