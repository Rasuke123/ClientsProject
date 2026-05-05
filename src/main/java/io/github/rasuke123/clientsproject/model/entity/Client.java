package io.github.rasuke123.clientsproject.model.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length=150)
    private String name;

    @Column(nullable=false, length=11)
    private String TIN; /// tax identification number

    @Column(name = "registration_date")
    private LocalDate dateRegistration;


    public Client(Integer id, String name, String TIN, LocalDate dateRegistration) {
        this.id = id;
        this.name = name;
        this.TIN = TIN;
        this.dateRegistration = dateRegistration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public LocalDate getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDate dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
