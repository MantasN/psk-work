/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "LIBRARY")
@NamedQueries({
    @NamedQuery(name = "Library.findAll", query = "SELECT l FROM Library l"),
    @NamedQuery(name = "Library.findById", query = "SELECT l FROM Library l WHERE l.id = :id"),
    @NamedQuery(name = "Library.findByTitle", query = "SELECT l FROM Library l WHERE l.title = :title"),
    @NamedQuery(name = "Library.findByAddress", query = "SELECT l FROM Library l WHERE l.address = :address"),
    @NamedQuery(name = "Library.findByPhoneNumber", query = "SELECT l FROM Library l WHERE l.phoneNumber = :phoneNumber")})
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 200)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Version
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPT_LOCK")
    private int optLock;
    @OneToMany(mappedBy = "libraryId")
    private List<Librarian> librarianList = new ArrayList<>();

    public Library() {
    }

    public Library(Integer id) {
        this.id = id;
    }

    public Library(Integer id, int optLock) {
        this.id = id;
        this.optLock = optLock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOptLock() {
        return optLock;
    }

    public void setOptLock(int optLock) {
        this.optLock = optLock;
    }

    public List<Librarian> getLibrarianList() {
        return librarianList;
    }

    public void setLibrarianList(List<Librarian> librarianList) {
        this.librarianList = librarianList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Library)) {
            return false;
        }
        Library other = (Library) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mantasn.second.psk.entities.Library[ id=" + id + " ]";
    }

}
