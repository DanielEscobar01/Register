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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "enroll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enroll.findAll", query = "SELECT e FROM Enroll e")
    , @NamedQuery(name = "Enroll.findByIDenroll", query = "SELECT e FROM Enroll e WHERE e.iDenroll = :iDenroll")
    , @NamedQuery(name = "Enroll.findByIdStudent", query = "SELECT e FROM Enroll e WHERE e.idStudent = :idStudent")
    , @NamedQuery(name = "Enroll.findByNameStudent", query = "SELECT e FROM Enroll e WHERE e.nameStudent = :nameStudent")
    , @NamedQuery(name = "Enroll.findBySubject", query = "SELECT e FROM Enroll e WHERE e.subject = :subject")})
public class Enroll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_enroll")
    private Integer iDenroll;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Student")
    private int idStudent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nameStudent")
    private String nameStudent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subject")
    private String subject;

    public Enroll() {
    }

    public Enroll(Integer iDenroll) {
        this.iDenroll = iDenroll;
    }

    public Enroll(Integer iDenroll, int idStudent, String nameStudent, String subject) {
        this.iDenroll = iDenroll;
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.subject = subject;
    }

    public Integer getIDenroll() {
        return iDenroll;
    }

    public void setIDenroll(Integer iDenroll) {
        this.iDenroll = iDenroll;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDenroll != null ? iDenroll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enroll)) {
            return false;
        }
        Enroll other = (Enroll) object;
        if ((this.iDenroll == null && other.iDenroll != null) || (this.iDenroll != null && !this.iDenroll.equals(other.iDenroll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Enroll[ iDenroll=" + iDenroll + " ]";
    }
    
}
