/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mantasn.second.psk.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author m.neviera
 */
@Entity
@Table(name = "LIBRARY_CARD")
@NamedQueries({
    @NamedQuery(name = "LibraryCard.findAll", query = "SELECT l FROM LibraryCard l"),
    @NamedQuery(name = "LibraryCard.findById", query = "SELECT l FROM LibraryCard l WHERE l.id = :id"),
    @NamedQuery(name = "LibraryCard.findByRegistrationNo", query = "SELECT l FROM LibraryCard l WHERE l.registrationNo = :registrationNo"),
    @NamedQuery(name = "LibraryCard.findByLibraryNo", query = "SELECT l FROM LibraryCard l WHERE l.libraryNo = :libraryNo")})
public class LibraryCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "REGISTRATION_NO")
    private String registrationNo;
    @Column(name = "LIBRARY_NO")
    private Integer libraryNo;
    @OneToMany(mappedBy = "libraryCardId")
    private List<Book> bookList;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Student studentId;

    public LibraryCard() {
    }

    public LibraryCard(Integer id) {
        this.id = id;
    }

    public LibraryCard(Integer id, String registrationNo) {
        this.id = id;
        this.registrationNo = registrationNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Integer getLibraryNo() {
        return libraryNo;
    }

    public void setLibraryNo(Integer libraryNo) {
        this.libraryNo = libraryNo;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        return registrationNo.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof LibraryCard)) {
            return false;
        }
        
        LibraryCard other = (LibraryCard) object;
        
        if (!registrationNo.equals(other.registrationNo)) {
            return false;
        }
        
        return true;
    }


    @Override
    public String toString() {
        return "com.mantasn.second.psk.entities.LibraryCard[ id=" + id + " ]";
    }
    
}
