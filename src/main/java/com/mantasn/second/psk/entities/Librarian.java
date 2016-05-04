/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mantasn.second.psk.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "LIBRARIAN")
@NamedQueries({
    @NamedQuery(name = "Librarian.findAll", query = "SELECT l FROM Librarian l"),
    @NamedQuery(name = "Librarian.findById", query = "SELECT l FROM Librarian l WHERE l.id = :id"),
    @NamedQuery(name = "Librarian.findByFirstName", query = "SELECT l FROM Librarian l WHERE l.firstName = :firstName"),
    @NamedQuery(name = "Librarian.findByLastName", query = "SELECT l FROM Librarian l WHERE l.lastName = :lastName"),
    @NamedQuery(name = "Librarian.findByPersonalNo", query = "SELECT l FROM Librarian l WHERE l.personalNo = :personalNo"),
    @NamedQuery(name = "Librarian.findByAddress", query = "SELECT l FROM Librarian l WHERE l.address = :address"),
    @NamedQuery(name = "Librarian.findByPhoneNumber", query = "SELECT l FROM Librarian l WHERE l.phoneNumber = :phoneNumber")})
public class Librarian implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PERSONAL_NO")
    private String personalNo;
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
    @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Library libraryId;

    public Librarian() {
    }

    public Librarian(Integer id) {
        this.id = id;
    }

    public Librarian(Integer id, String personalNo, int optLock) {
        this.id = id;
        this.personalNo = personalNo;
        this.optLock = optLock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
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

    public Library getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Library libraryId) {
        this.libraryId = libraryId;
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
        if (!(object instanceof Librarian)) {
            return false;
        }
        Librarian other = (Librarian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mantasn.second.psk.entities.Librarian[ id=" + id + " ]";
    }

}
