/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.dao;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.IspitniRok;

/**
 *
 * @author filip
 */
public interface IspitniRokDao {

    IspitniRok findById(Integer id);

    List<IspitniRok> findAll();

    void persist(IspitniRok ispitniRok);

    void update(IspitniRok ispitniRok);

    void deleteIspitniRokById(int id);
}
