package com.pero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

    

 
@Entity()
@Table(name = "person")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Person implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;


    @Column(name = "last_name")
    public String lastName;
    
    @Column(name = "person")
    public String person;

    @Column(name = "first_name")
    public String firstName;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

 
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }



    
}
