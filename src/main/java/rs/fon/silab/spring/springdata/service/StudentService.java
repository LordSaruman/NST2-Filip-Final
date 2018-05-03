/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.Mesto;
import rs.fon.silab.spring.springdata.domen.Student;

/**
 *
 * @author filip
 */
public interface StudentService {

    Student findById(String id);

    List<Student> findAll();

    List<Student> findAllForMesto(Mesto mesto);

    void persist(Student student);

    void update(Student dbStudent, Student student);
}
