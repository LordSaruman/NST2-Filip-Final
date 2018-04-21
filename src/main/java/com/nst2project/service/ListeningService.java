/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.service;

import com.nst2project.model.Listening;
import java.util.List;

/**
 *
 * @author filip
 */
public interface ListeningService {

    Listening findById(Integer id);

    List<Listening> findAll();

    List<Listening> findAllForStudent(Listening listening);

    void persist(Listening listening);

    void update(Listening listening);
}
