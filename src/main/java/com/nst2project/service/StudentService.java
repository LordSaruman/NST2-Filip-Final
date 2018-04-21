/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.service;

import com.nst2project.model.Student;
import java.util.List;

/**
 *
 * @author filip
 */
public interface StudentService {

    Student findById(int id);

    List<Student> findAllStudents();

    void saveStudent(Student student);

    void updateStudent(Student dbStudent, Student student);

    void deleteStudentById(int id);
}
