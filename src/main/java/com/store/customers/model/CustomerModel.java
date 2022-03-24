package com.store.customers.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customerstable")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotEmpty
    @Size(min =2, message = "must be at least 2 characters long")
    private String name;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="phone")
    @Size(min=10,max=11)
    private String phone;

    @Column(name="city")
    private String city;





    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
