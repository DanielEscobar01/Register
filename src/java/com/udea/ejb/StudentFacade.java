/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "laboratorio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public boolean checkLogin(String u, String p) {
        return false;
    }

    @Override
    public Object getStudent(int id) {
        Query q = em.createQuery("select a from Student a "+ "where a.id=:id");
        q.setParameter("id", id);
        return q.getResultList().get(0);
    }
    
    
    @Override
    public boolean checkLogin(int u, String p) {
           Query q =  em.createQuery("select a from Student a "+
               "where a.id=:u and a.password=:p");
       q.setParameter("u",u);
       q.setParameter("p",p);
       return q.getResultList().size()>0;
    }

  
    
    
}
