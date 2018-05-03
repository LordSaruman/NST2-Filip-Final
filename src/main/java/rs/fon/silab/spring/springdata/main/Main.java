/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.main;

import java.util.LinkedList;
import java.util.List;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import rs.fon.silab.spring.springdata.config.MySpringDataPersistenceJPAConfig;
import rs.fon.silab.spring.springdata.domen.Mesto;
import rs.fon.silab.spring.springdata.domen.Student;
import rs.fon.silab.spring.springdata.service.MestoService;
import rs.fon.silab.spring.springdata.service.StudentService;

/**
 *
 * @author filip
 */
@Component
public class Main {

    private List<Mesto> list;

    public Main() {
        list = new LinkedList<Mesto>();
    }

//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(MySpringDataPersistenceJPAConfig.class);
//        Main main = (Main) context.getBean(Main.class);
//        main.findAll();
//        //main.findById(11000);
//        //Mesto m = new Mesto(12000, "FILIPPPP");
//        //main.persist(m);
//
//        //int k = 12000;
//        //main.delete(k);
//        //Mesto m1 = new Mesto();
//        //m1 = main.mestoService.findById(12000);
//        //main.update(m1, m);
//        //STUDENT TESTIRANJE
//        //main.studentFindAll();
//        //main.studentFindById("2017/3713");
//        //Mesto m = new Mesto(11000, "Beograd");
//        //main.studentForAllMesto(m);
////        Student s = new Student("2016/3333", "JANKO", "JANGO", m);
////        main.persistStudent(s);
//        System.out.println("End..");
//
//    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private MestoService mestoService;

    //TESTIRANJE
    //mesto -- sve radi! (:
    private void findAll() {
        List<Mesto> mesta = mestoService.findAllMesto();
        for (Mesto mesto : mesta) {
            System.out.println(mesto.getNaziv());
            System.out.println(mesto.getPtt());
        }

        this.list = mesta;
    }

    private void findById(int i) {
        Mesto mesto = mestoService.findById(i);
        System.out.println(mesto.getNaziv());
        System.out.println(mesto.getPtt());
    }

    //persist
    private void persist(Mesto mesto) {
        System.out.println("PERSIST");
        mestoService.saveMesto(mesto);
    }

    //delete
    private void delete(int id) {
        mestoService.deleteMestoById(id);
    }

    private void update(Mesto dbMesto, Mesto mesto) {
        mestoService.updateMesto(dbMesto, mesto);
    }

    //STUDENT TESTIRANJE
    //ne radi kako treba - vraca samo 1 studenta i to njih 5 (koliko ima rows u bazi)
    private void studentFindAll() {
        List<Student> list = studentService.findAll();

        for (Student student : list) {
            System.out.println(student.getIme());
            System.out.println(student.getPrezime());
        }
    }

    //radi
    private void studentFindById(String i) {
        Student s = studentService.findById(i);
        System.out.println(s.getIme());
        System.out.println(s.getPrezime());
        System.out.println(s.getBrInd());
    }

    //opet ne radi kako treba - vraca sve studente
    private void studentForAllMesto(Mesto m) {
        List<Student> list = studentService.findAllForMesto(m);

        for (Student student : list) {
            System.out.println(student.getIme());
            System.out.println(student.getPrezime());
        }
    }

    //radi
    private void persistStudent(Student s) {
        studentService.persist(s);
    }

    public List<Mesto> returnAllMesta() {
        findAll();
        return list;
    }
}
