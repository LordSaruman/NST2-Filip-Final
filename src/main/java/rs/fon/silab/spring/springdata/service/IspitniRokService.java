/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.service;

import java.util.List;
import rs.fon.silab.spring.springdata.domen.IspitniRok;

/**
 *
 * @author filip
 */
public interface IspitniRokService {

    IspitniRok findById(int id);

    List<IspitniRok> findAllIspitniRok();

    void saveIspitniRok(IspitniRok ispitniRok);

    void updateIspitniRok(IspitniRok dbIspitniRok, IspitniRok ispitniRok);

    void deleteIspitniRokById(int id);
}
