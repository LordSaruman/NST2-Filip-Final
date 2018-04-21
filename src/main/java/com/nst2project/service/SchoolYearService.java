/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.service;

import com.nst2project.model.SchoolYear;
import java.util.List;

/**
 *
 * @author filip
 */
public interface SchoolYearService {

    SchoolYear findById(int id);

    List<SchoolYear> findAllSchoolYear();

    void saveSchoolYear(SchoolYear schoolYear);

    void updateSchoolYear(SchoolYear dbSchoolYeare, SchoolYear schoolYear);

    void deleteSchoolYearById(int id);
}
