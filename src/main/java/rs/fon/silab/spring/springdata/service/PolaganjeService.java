/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.Ispit;
import rs.fon.silab.spring.springdata.domen.IspitniRok;
import rs.fon.silab.spring.springdata.domen.Polaganje;
import rs.fon.silab.spring.springdata.domen.Student;

/**
 *
 * @author filip
 */
public interface PolaganjeService {

    Polaganje findById(Integer id);

    List<Polaganje> findAll();

    List<Polaganje> findAllForStudent(Student student);
    
    List<Polaganje> findAllForIspit(Ispit ispit);
    
    List<Polaganje> findAllForIspitniRok(IspitniRok ispitniRok);

    void persist(Polaganje polaganje);

    void update(Polaganje polaganje);
}
