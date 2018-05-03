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
@Table(name = "ispitnirok")
public class IspitniRok {
    
    @Id
    @Column(name = "SifraIspitnogRoka", unique = true, nullable = false)
    private int sifraIspitnogRoka;
    
    @Column(name = "NazivIspitnogRoka", unique = true, nullable = false)
    private String nazivIspitnogRoka;

    public IspitniRok() {
    }

    public IspitniRok(int sifraIspitnogRoka, String nazivIspitnogRoka) {
        this.sifraIspitnogRoka = sifraIspitnogRoka;
        this.nazivIspitnogRoka = nazivIspitnogRoka;
    }

    public String getNazivIspitnogRoka() {
        return nazivIspitnogRoka;
    }

    public void setNazivIspitnogRoka(String nazivIspitnogRoka) {
        this.nazivIspitnogRoka = nazivIspitnogRoka;
    }

    public int getSifraIspitnogRoka() {
        return sifraIspitnogRoka;
    }

    public void setSifraIspitnogRoka(int sifraIspitnogRoka) {
        this.sifraIspitnogRoka = sifraIspitnogRoka;
    }
    
    
}
