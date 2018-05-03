/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author filip
 */
@Entity
@Table(name = "ispit")
public class Ispit {
    
    @Id
    @Column(name = "SifraIspita", unique = true, nullable = false)
    private int sifraIspita;
    
    @Column(name = "NazivIspita", unique = true, nullable = false)
    private String nazivIspita;

    public Ispit() {
    }

    public Ispit(int sifraIspita, String nazivIspita) {
        this.sifraIspita = sifraIspita;
        this.nazivIspita = nazivIspita;
    }

    public String getNazivIspita() {
        return nazivIspita;
    }

    public void setNazivIspita(String nazivIspita) {
        this.nazivIspita = nazivIspita;
    }

    public int getSifraIspita() {
        return sifraIspita;
    }

    public void setSifraIspita(int sifraIspita) {
        this.sifraIspita = sifraIspita;
    }
    
    
}
