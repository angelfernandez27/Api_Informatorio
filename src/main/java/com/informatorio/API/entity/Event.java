package com.informatorio.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "events")
@Getter @Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "el campo name no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo name debe tener entre 2 y 255 caracteres")
    private String descriptionEvent;
    private Date creationDate;
    private Date closureDate;
    @NotEmpty(message = "el campo stateno puede estar vacio")
    @Size(min=1, max = 255, message = "el campo state debe tener entre 2 y 255 caracteres")
    private String state;
    //Falta lista de emprendimientos subscribers

    @Min(value = 0,message="El campo objetive debe ser mayor o igual a cero")
    private double prize;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id", insertable = true, nullable = false, updatable = false) //Averiguar si es obligatorio y para que sirve
    //@JsonIgnore
    //private User user;
    //@OneToMany(mappedBy ="event")
    //@JsonIgnore
    //private Set<Startup> startupSet;

    @ManyToMany(mappedBy = "events")
    private Set<Startup> startupSet;



    /*public void addStartup(Startup startup){
        startupSet.add(startup);
        startup.setEvent(this);
    }
    public void removeStartup(Startup startup){
        startupSet.remove(startup);
        startup.setEvent(null);
    }*/
}
