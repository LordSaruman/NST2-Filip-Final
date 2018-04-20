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
@Table(name = "school_year")
public class SchoolYear implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "school_year", unique = true, nullable = false)
    private int schoolYear;

    @Column(name = "active_school_year", unique = true, nullable = false)
    private boolean activeSchoolYear;

    public SchoolYear() {
    }

    public SchoolYear(int id, int schoolYear, boolean activeSchoolYear) {
        this.id = id;
        this.schoolYear = schoolYear;
        this.activeSchoolYear = activeSchoolYear;
    }

    public boolean isActiveSchoolYear() {
        return activeSchoolYear;
    }

    public void setActiveSchoolYear(boolean activeSchoolYear) {
        this.activeSchoolYear = activeSchoolYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

}
