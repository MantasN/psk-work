/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.components;

import com.mantasn.second.psk.entities.Book;
import com.mantasn.second.psk.services.BookCRUD;
import java.util.List;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@Stateful
public class SearchController { 
    @Inject
    private BookCRUD bookCRUD;
    
    private String isbn;
    
    private String result;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public void search(){
        List<Book> bookList = bookCRUD.findByIsbn(isbn);
        
        if (bookList != null && !bookList.isEmpty()) {
            result = "egzistuoja";
        } else {
            result = "neegizstuoja";
        }
    }
    
}
