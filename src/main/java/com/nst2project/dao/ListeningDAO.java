/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.dao;

import com.nst2project.model.Listening;
import com.nst2project.model.Student;
import com.nst2project.model.Subject;
import java.util.List;

/**
 *
 * @author filip
 */
public interface ListeningDAO{

    Listening findById(Integer id);

    List<Listening> findAll();

    List<Listening> findAllForStudent(Student student);
    
    List<Listening> findAllForStudent(Subject subject);

    void persist(Listening listening);

    void update(Listening listening);
}
