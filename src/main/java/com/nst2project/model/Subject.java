/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author filip
 */
@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_of_the_subject", unique = true, nullable = false)
    private String nameOfTheSubject;

    @Column(name = "year", unique = true, nullable = false)
    private int year;

    @Column(name = "course", unique = true, nullable = false)
    private String course;

    @Column(name = "espb", unique = true, nullable = false)
    private int espb;

    @Column(name = "number_of_lectures", unique = true, nullable = false)
    private int numberOfLectures;

    public Subject() {
    }

    public Subject(int id, String nameOfTheSubject, int year, String course, int espb, int numberOfLectures) {
        this.id = id;
        this.nameOfTheSubject = nameOfTheSubject;
        this.year = year;
        this.course = course;
        this.espb = espb;
        this.numberOfLectures = numberOfLectures;
    }

    public int getNumberOfLectures() {
        return numberOfLectures;
    }

    public void setNumberOfLectures(int numberOfLectures) {
        this.numberOfLectures = numberOfLectures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTheSubject() {
        return nameOfTheSubject;
    }

    public void setNameOfTheSubject(String nameOfTheSubject) {
        this.nameOfTheSubject = nameOfTheSubject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

}
