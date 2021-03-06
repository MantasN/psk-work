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
@Table(name = "STUDENT")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Student.findByPersonalNo", query = "SELECT s FROM Student s WHERE s.personalNo = :personalNo"),
    @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address"),
    @NamedQuery(name = "Student.findByPhoneNumber", query = "SELECT s FROM Student s WHERE s.phoneNumber = :phoneNumber")})
public class Student implements Serializable {

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
    @OneToMany(mappedBy = "studentId")
    private List<LibraryCard> libraryCardList = new ArrayList<>();

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(Integer id, String personalNo, int optLock) {
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

    public List<LibraryCard> getLibraryCardList() {
        return libraryCardList;
    }

    public void setLibraryCardList(List<LibraryCard> libraryCardList) {
        this.libraryCardList = libraryCardList;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mantasn.second.psk.entities.Student[ id=" + id + " ]";
    }

}
