package com.spring.boot.crud.learn.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="Employees")
public class Employees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email")
    private String email;
    
    @Column(name="created_at")
    private Date createdAt;
    
    @Column(name="updated_at")
    private Date updatedAt;
    
    @Column(name="deleted_at")
    private Date deletedAt;
    
    public Employees() {}

    public Employees(String firstName, String lastName, String email, Date createdAt, Date updatedAt, Date deletedAt) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.deletedAt = deletedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
	return "Employees [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
		+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
    }
    
    
    
}
