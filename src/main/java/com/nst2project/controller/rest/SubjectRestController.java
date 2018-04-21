/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.controller.rest;

import com.nst2project.model.Subject;
import com.nst2project.service.SubjectService;
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
public class SubjectRestController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/subject/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subject> saveNewSubject(@RequestBody Subject subject) {
        subjectService.saveSubject(subject);

        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subject> editSubject(@PathVariable int id, @RequestBody Subject subject) {
        Subject subjectDB = subjectService.findById(id);
        if (subjectDB == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        subjectService.updateSubject(subjectDB, subject);

        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subject> deleteSubject(@PathVariable int id) {
        Subject subjectDB = subjectService.findById(id);
        if (subjectDB == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        subjectService.deleteSubjectById(id);

        return new ResponseEntity<>(subjectDB, HttpStatus.OK);
    }

}
