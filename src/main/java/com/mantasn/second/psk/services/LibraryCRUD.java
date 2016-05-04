/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.services;

import com.mantasn.second.psk.entities.Library;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LibraryCRUD {
    @PersistenceContext
    private EntityManager em;
        
    public Library getLibrary(int id) {
        return em.find(Library.class, id);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateLibrary(Library library) {
        em.merge(library);
    }
}

