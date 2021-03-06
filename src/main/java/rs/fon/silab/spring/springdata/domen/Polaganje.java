/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.domen;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author filip
 */
@Entity
@Table(name = "polaganje")
public class Polaganje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PolaganjeId")
    private int idPolaganje;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BrInd")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SifraIspitnogRoka")
    private IspitniRok ispitniRok;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SifraIspita")
    private Ispit ispit;
    
    @Column(name = "Ocena", unique = true, nullable = false)
    private int ocena;
    
    @Column(name = "Datum", unique = true, nullable = false)
    private Date datum;

    public Polaganje() {
    }

    public Polaganje(int idPolaganje, Student student, IspitniRok ispitniRok, Ispit ispit, int ocena, Date datum) {
        this.idPolaganje = idPolaganje;
        this.student = student;
        this.ispitniRok = ispitniRok;
        this.ispit = ispit;
        this.ocena = ocena;
        this.datum = datum;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getIdPolaganje() {
        return idPolaganje;
    }

    public void setIdPolaganje(int idPolaganje) {
        this.idPolaganje = idPolaganje;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public IspitniRok getIspitniRok() {
        return ispitniRok;
    }

    public void setIspitniRok(IspitniRok ispitniRok) {
        this.ispitniRok = ispitniRok;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Polaganje other = (Polaganje) obj;
        if (this.idPolaganje != other.idPolaganje) {
            return false;
        }
        if (this.ocena != other.ocena) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.ispitniRok, other.ispitniRok)) {
            return false;
        }
        if (!Objects.equals(this.ispit, other.ispit)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        return true;
    }
    
    
}
