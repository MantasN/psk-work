/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.services;

import com.mantasn.second.psk.entities.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

@Stateless
public class BookCRUD {
    @PersistenceContext(type=PersistenceContextType.TRANSACTION, synchronization=SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;
    
    public void persistBook(Book book) {
        em.persist(book);
    }
    
    public List<Book> findByIsbn(String isbn){
        return em.createNamedQuery("Book.findByIsbn")
                .setParameter("isbn", isbn)
                .getResultList();
    }
}

