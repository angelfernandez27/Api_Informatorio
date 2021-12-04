package com.informatorio.API.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "urls")
@Getter @Setter
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "el campo url no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo url debe tener entre 2 y 255 caracteres")
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_id",nullable = false) //Averiguar si es obligatorio y para que sirve
    private Startup startUp;
}
