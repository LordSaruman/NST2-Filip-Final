/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.controller.rest;

import com.nst2project.model.Listening;
import com.nst2project.service.ListeningService;
import com.nst2project.service.SchoolYearService;
import com.nst2project.service.StudentService;
import com.nst2project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class ListeningRestController {

    @Autowired
    private ListeningService listeningService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private SchoolYearService schoolYearService;

    @RequestMapping(value = "/listening/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Listening> saveNewSubject(@RequestBody Listening listening) {
        listening.setSchoolYear(schoolYearService.findById(listening.getSchoolYear().getId()));
        listening.setStudent(studentService.findById(listening.getStudent().getId()));
        listening.setSubject(subjectService.findById(listening.getSubject().getId()));
        try {
            listeningService.persist(listening);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listening, HttpStatus.OK);
    }
}
