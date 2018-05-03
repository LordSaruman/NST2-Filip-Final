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
@Table(name = "mesto")
public class Mesto {
    
    @Id
    @Column(name = "Ptt", unique = true, nullable = false)
    private int Ptt;
    
    @Column(name = "Naziv", unique = true, nullable = false)
    private String naziv;

    public Mesto() {
    }

    public Mesto(int Ptt, String naziv) {
        this.Ptt = Ptt;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPtt() {
        return Ptt;
    }

    public void setPtt(int Ptt) {
        this.Ptt = Ptt;
    }
    
    
}
