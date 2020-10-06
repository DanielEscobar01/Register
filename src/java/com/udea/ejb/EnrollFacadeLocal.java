/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Enroll;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface EnrollFacadeLocal {

    void create(Enroll enroll);

    void edit(Enroll enroll);

    void remove(Enroll enroll);

    Enroll find(Object id);

    List<Enroll> findAll();

    List<Enroll> findRange(int[] range);

    int count();

    Object getEnroll(int id);
    
}
