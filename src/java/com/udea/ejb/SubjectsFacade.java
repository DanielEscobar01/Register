/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Subjects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
@Stateless
public class SubjectsFacade extends AbstractFacade<Subjects> implements SubjectsFacadeLocal {

    @PersistenceContext(unitName = "laboratorio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public SubjectsFacade() {
        super(Subjects.class);
    }

    @Override
    public Object getSubject(int id) {
        Query q = em.createQuery("SELECT s FROM Subjects s WHERE s.idSubject = :idSubject");
        q.setParameter("idSubject", id);
        return q.getResultList().get(0);
    }
    
    
    
    
    
    
}
