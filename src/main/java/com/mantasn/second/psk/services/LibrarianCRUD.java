/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.services;

import com.mantasn.second.psk.entities.Librarian;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LibrarianCRUD {
    @PersistenceContext
    private EntityManager em;
    
    public void persistLibrarian(Librarian librarian) {
        em.persist(librarian);
    }
}

