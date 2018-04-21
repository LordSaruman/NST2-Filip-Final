/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.controller.rest;

import com.nst2project.model.Student;
import com.nst2project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author filip
 */
@RestController
@RequestMapping("/private")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> saveNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> editStudent(@PathVariable int id, @RequestBody Student student) {
        Student studentDB = studentService.findById(id);
        if (studentDB == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        studentService.updateStudent(studentDB, student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Student studentDB = studentService.findById(id);
        if (studentDB == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        studentService.deleteStudentById(id);

        return new ResponseEntity<>(studentDB, HttpStatus.OK);
    }
}
