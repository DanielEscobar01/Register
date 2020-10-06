/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s")
    , @NamedQuery(name = "Subjects.findByIdSubject", query = "SELECT s FROM Subjects s WHERE s.idSubject = :idSubject")
    , @NamedQuery(name = "Subjects.findByNameSubject", query = "SELECT s FROM Subjects s WHERE s.nameSubject = :nameSubject")
    , @NamedQuery(name = "Subjects.findByNumberClassmates", query = "SELECT s FROM Subjects s WHERE s.numberClassmates = :numberClassmates")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id_Subject")
    private Integer idSubject;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "name_Subject")
    private String nameSubject;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "number_classmates")
    private int numberClassmates;

    public Subjects() {
    }

    public Subjects(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public Subjects(Integer idSubject, String nameSubject, int numberClassmates) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.numberClassmates = numberClassmates;
    }

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getNumberClassmates() {
        return numberClassmates;
    }

    public void setNumberClassmates(int numberClassmates) {
        this.numberClassmates = numberClassmates;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubject != null ? idSubject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.idSubject == null && other.idSubject != null) || (this.idSubject != null && !this.idSubject.equals(other.idSubject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Subjects[ idSubject=" + idSubject + " ]";
    }
    
}
