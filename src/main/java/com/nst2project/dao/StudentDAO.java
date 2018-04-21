/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.dao;

import com.nst2project.model.Student;
import java.util.List;

/**
 *
 * @author filip
 */
public interface StudentDAO {
    
    Student findByID(Integer id);
    
    List<Student> findAll();
    
    void persist(Student student);
    
    void update(Student student);
    
    void deleteByID(Integer id);    
}
