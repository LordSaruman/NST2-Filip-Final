/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.fon.silab.spring.springdata.dao.StudentDao;
import rs.fon.silab.spring.springdata.domen.Mesto;
import rs.fon.silab.spring.springdata.domen.Student;
import rs.fon.silab.spring.springdata.service.StudentService;

/**
 *
 * @author filip
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public StudentServiceImpl() {
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> findAllForMesto(Mesto mesto) {
        return studentDao.findAllForMesto(mesto);
    }

    @Override
    public void persist(Student student) {
        studentDao.persist(student);
    }

    @Override
    public void update(Student dbStudent, Student student) {
        dbStudent.setIme(student.getIme());
        dbStudent.setMesto(student.getMesto());
        dbStudent.setPrezime(student.getPrezime());
        
        studentDao.persist(student);
    }

}
