/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.dao;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.Ispit;
import rs.fon.silab.spring.springdata.domen.IspitniRok;
import rs.fon.silab.spring.springdata.domen.Polaganje;
import rs.fon.silab.spring.springdata.domen.Student;

/**
 *
 * @author filip
 */
public interface PolaganjeDao {

    Polaganje findById(Integer id);

    List<Polaganje> findAll();

    List<Polaganje> findAllForIspit(Ispit ispit);

    List<Polaganje> findAllForIspitniRok (IspitniRok ispitniRok);

    List<Polaganje> findAllForStudent(Student student);

    void persist(Polaganje polaganje);

    void update(Polaganje polaganje);
}
