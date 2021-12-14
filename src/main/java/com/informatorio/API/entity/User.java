package com.informatorio.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "el campo name no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo name debe tener entre 2 y 255 caracteres")
    private String name;
    @NotEmpty(message = "el campo last name no puede estar vacio")
    @Size(min=1, max = 255, message = "el campo lastName debe tener entre 2 y 255 caracteres")
    private String lastName;
    @NotEmpty(message = "el campo email no puede estar vacio")
    @Size(min=4, max = 255, message = "el campo email debe tener entre 2 y 255 caracteres")
    private String email;
    @NotEmpty(message = "el campo password no puede estar vacio")
    @Size(min=4, max = 255, message = "el campo password debe tener entre 2 y 255 caracteres")
    private String password;
    private Date creationDate;
    @NotEmpty(message = "el campo city no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo city debe tener entre 2 y 255 caracteres")
    private String city;
    @NotEmpty(message = "el campo province no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo province debe tener entre 2 y 255 caracteres")
    private String province;
    @NotEmpty(message = "el campo country no puede estar vacio")
    @Size(min=2, max = 255, message = "el campo country debe tener entre 2 y 255 caracteres")
    private String country;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @OneToMany(mappedBy = "user")
    private Set<Vote> voteSet=new HashSet<>();
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Startup> startupSet = new HashSet<>();

    //@OneToMany(mappedBy = "user")
    //private Set<Event>eventSet;
    public void addStartup(Startup startup) {
        startupSet.add(startup);
        startup.setCreator(this);
    }
    public void removeStartup(Startup startup) {
        startupSet.remove(startup);
        startup.setCreator(null);
    }
    public void addVote(Vote vote){
        voteSet.add(vote);
        vote.setUser(this);
    }
    public void removeVote(Vote vote){
        voteSet.remove(vote);
        vote.setUser(null);
    }
}
