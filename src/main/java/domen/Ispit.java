/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milenkovic
 */
@Entity
@Table(name = "ispit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ispit.findAll", query = "SELECT i FROM Ispit i"),
    @NamedQuery(name = "Ispit.findBySifraIspita", query = "SELECT i FROM Ispit i WHERE i.sifraIspita = :sifraIspita"),
    @NamedQuery(name = "Ispit.findByNazivIspita", query = "SELECT i FROM Ispit i WHERE i.nazivIspita = :nazivIspita")})
public class Ispit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SifraIspita")
    private Integer sifraIspita;
    @Size(max = 30)
    @Column(name = "NazivIspita")
    private String nazivIspita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ispit")
    private List<Polaganje> polaganjeList;

    public Ispit() {
    }

    public Ispit(Integer sifraIspita) {
        this.sifraIspita = sifraIspita;
    }

    public Integer getSifraIspita() {
        return sifraIspita;
    }

    public void setSifraIspita(Integer sifraIspita) {
        this.sifraIspita = sifraIspita;
    }

    public String getNazivIspita() {
        return nazivIspita;
    }

    public void setNazivIspita(String nazivIspita) {
        this.nazivIspita = nazivIspita;
    }

    @XmlTransient
    public List<Polaganje> getPolaganjeList() {
        return polaganjeList;
    }

    public void setPolaganjeList(List<Polaganje> polaganjeList) {
        this.polaganjeList = polaganjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraIspita != null ? sifraIspita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ispit)) {
            return false;
        }
        Ispit other = (Ispit) object;
        if ((this.sifraIspita == null && other.sifraIspita != null) || (this.sifraIspita != null && !this.sifraIspita.equals(other.sifraIspita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Ispit[ sifraIspita=" + sifraIspita + " ]";
    }
    
}
