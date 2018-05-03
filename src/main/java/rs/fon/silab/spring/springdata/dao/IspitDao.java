/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.dao;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.Ispit;

/**
 *
 * @author filip
 */
public interface IspitDao {

    Ispit findById(Integer id);

    List<Ispit> findAll();

    void persist(Ispit ispit);

    void update(Ispit ispit);

    void deleteIspitById(int id);
}
