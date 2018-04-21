/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.service;

import com.nst2project.model.Subject;
import java.util.List;

/**
 *
 * @author filip
 */
public interface SubjectService {

    Subject findById(int id);

    List<Subject> findAllSubjects();

    void saveSubject(Subject subject);

    void updateSubject(Subject dbSubject, Subject subject);

    void deleteSubjectById(int id);
}
