/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Enroll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
@Stateless
public class EnrollFacade extends AbstractFacade<Enroll> implements EnrollFacadeLocal {

    @PersistenceContext(unitName = "laboratorio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnrollFacade(){
        super(Enroll.class);
    }

    @Override
    public Object getEnroll(int id) {
        Query q = em.createQuery("SELECT e FROM Enroll e WHERE e.idStudent =: idStudent");
        q.setParameter("idStudent", id);
        return q.getResultList();
    }
    
    
    
}
