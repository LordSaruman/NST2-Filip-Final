/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.dao;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.Mesto;

/**
 *
 * @author filip
 */
public interface MestoDao {

    Mesto findById(Integer id);

    List<Mesto> findAll();

    void persist(Mesto mesto);

    void update(Mesto mesto);

    void deleteMestoById(int id);
}
