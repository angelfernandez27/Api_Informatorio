package com.informatorio.API.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "startups")
@Getter @Setter
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "el campo name no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo name debe tener entre 2 y 255 caracteres")
    private String name;
    @NotEmpty(message = "el campo last name no puede estar vacio")
    @Size(min=1, max = 255, message = "el campo lastName debe tener entre 2 y 255 caracteres")
    private String description;
    @NotEmpty(message = "el campo content no puede estar vacio")
    @Size(min=3, max = 255, message = "el campo content debe tener entre 4 y 255 caracteres")
    private String content;

    private Date creationDate;
    @Min(value = 0,message="El campo objetive debe ser mayor o igual a cero")
    private double objective;
    //@NotEmpty(message = "el campo published no puede estar vacio")
    private boolean published;
    @NotEmpty(message = "el campo Tags no puede estar vacio")
    @Size(min=3, max = 255, message = "el campo Tags debe tener entre 4 y 255 caracteres")
    private String tags;

    @OneToMany(mappedBy ="startUp")
    @JsonIgnore
    private Set<Vote> voteSet;
    @OneToMany(mappedBy ="startUp")
    private Set<Url> urls;
    @OneToMany(mappedBy = "startUp")
    @JsonIgnore
    private Set<Event> eventSet;


}
