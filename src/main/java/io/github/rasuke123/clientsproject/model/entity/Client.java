package io.github.rasuke123.clientsproject.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length=150)
    @NotEmpty(message = "{field.name.mandatory}")
    private String name;

    @Column(nullable=false, length=11)
    @NotNull(message = "{field.TIN.mandatory}")
    @Pattern(regexp = "\\d{11}", message = "{field.TIN.invalid}")
    private String TIN; /// tax identification number

    @Column(name = "registration_date", updatable=false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegistration;

    public Client(){

    }


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

    @PrePersist
    public void prePersist(){
        setDateRegistration(LocalDate.now());
    }
}
