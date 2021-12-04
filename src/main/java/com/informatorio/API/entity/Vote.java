package com.informatorio.API.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "votes")
@Getter @Setter
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "el campo generateBy no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo generateBy debe tener entre 2 y 255 caracteres")
    private String generateBy;
    private Date creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false) //Averiguar si es obligatorio y para que sirve
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_id",nullable = false) //Averiguar si es obligatorio y para que sirve
    private Startup startUp;

}
