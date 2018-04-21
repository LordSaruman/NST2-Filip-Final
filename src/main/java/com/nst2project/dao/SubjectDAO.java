/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.dao;

import com.nst2project.model.Subject;
import java.util.List;

/**
 *
 * @author filip
 */
public interface SubjectDAO {

    Subject findByID(Integer id);

    List<Subject> findAll();

    void persist(Subject subject);

    void update(Subject subject);

    void deleteByID(Integer id);
}
