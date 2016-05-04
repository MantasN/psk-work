/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.services;

import com.mantasn.second.psk.entities.Author;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

@Stateless
public class AuthorCRUD {
    @PersistenceContext(type=PersistenceContextType.TRANSACTION, synchronization=SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;
    
    public void persistAuthor(Author author) {
        em.persist(author);
    }
}

