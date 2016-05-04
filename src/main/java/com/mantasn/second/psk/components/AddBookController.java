/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.components;

import com.mantasn.second.psk.entities.Author;
import com.mantasn.second.psk.entities.Book;
import com.mantasn.second.psk.services.AuthorCRUD;
import com.mantasn.second.psk.services.BookCRUD;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

@Named
@ConversationScoped
@Stateful
public class AddBookController {

    @PersistenceContext(type=PersistenceContextType.EXTENDED, synchronization=SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;
    
    @Inject
    private Conversation conversation;
    
    @Inject
    private BookCRUD bookCRUD;
    
    @Inject
    private AuthorCRUD authorCRUD;
    
    private Book book;

    private List<Author> authors;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    
    public String confirmBook(){
        if(conversation.isTransient()){
            conversation.begin();
            em.isOpen();
            bookCRUD.persistBook(book);
            return "authorInfo";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veiksmas negalimas!", ""));
            return null;
        }
    }
    
    public void addAuthor(){
        authors.add(new Author());
    }
        
    public String confirmAuthors(){
        if(!conversation.isTransient()){
            authors.stream().forEach((author) -> {
                authorCRUD.persistAuthor(author);
            });
            return "bookAddConfirmation";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veiksmas negalimas!", ""));
            return null;
        }
    }
    
    public String confirm(){
        if(!conversation.isTransient()){
            em.joinTransaction();
            book.setAuthorList(authors);
            em.flush();
            conversation.end();
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veiksmas negalimas!", ""));
            return null;
        }
    }
    
    public String rollback(){
        return "index";
    }
    
    @PostConstruct
    public void init() {
        book = new Book();
        book.setRegistrationNo(UUID.randomUUID().toString());
        authors = new ArrayList<>();
    }
}
