/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.Mesto;

/**
 *
 * @author user
 */
public interface MestoService {

    Mesto findById(int id);

    List<Mesto> findAllMesto();

    void saveMesto(Mesto mesto);

    void updateMesto(Mesto dbMesto, Mesto mesto);

    void deleteMestoById(int id);
}
