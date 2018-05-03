/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.Ispit;

/**
 *
 * @author filip
 */
public interface IspitService {

    Ispit findById(int id);

    List<Ispit> findAllIspit();

    void saveIspit(Ispit ispit);

    void updateIspit(Ispit dbIspit, Ispit ispit);

    void deleteSIspitById(int id);
}
