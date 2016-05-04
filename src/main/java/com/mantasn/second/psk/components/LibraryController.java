/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.components;

import com.mantasn.second.psk.entities.Librarian;
import com.mantasn.second.psk.entities.Library;
import com.mantasn.second.psk.services.LibraryCRUD;
import com.mantasn.second.psk.services.LibrarianCRUD;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateful
@RequestScoped
public class LibraryController {
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private LibrarianCRUD librarianCRUD;
    
    @Inject
    private LibraryCRUD libraryCRUD;
    
    private Librarian librarian;
    
    private Library library;

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    
    public String updateLibrary() {
        em.isOpen();
        librarian.setLibraryId(library);
        librarianCRUD.persistLibrarian(librarian);
        libraryCRUD.updateLibrary(library);
        return "index";
    }
    
    @PostConstruct
    public void init() {
        librarian = new Librarian();
        library = libraryCRUD.getLibrary(1);
    }
}
