package com.informatorio.API.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

    private Date creationDate;
    @Min(value = 0,message="El campo objetive debe ser mayor o igual a cero")
    private double objective;
    //@NotEmpty(message = "el campo published no puede estar vacio")
    private boolean published;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tag> tags = new HashSet<Tag>();

    @OneToMany(mappedBy ="startUp")
    @JsonIgnore
    private Set<Vote> voteSet;
    @OneToMany(mappedBy ="startUp")
    @JsonIgnore
    private Set<Url> urls;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "event_id", nullable = false) //Averiguar si es obligatorio y para que sirve
    //@JsonIgnore
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //private Event event;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Event> events;
    public void addUrl(Url url){
        urls.add(url);
        url.setStartUp(this);
    }
    public void removeUrl(Url url){
        urls.remove(url);
        url.setStartUp(null);
    }
    public void addEvent(Event event) {
        if (this.events == null) {
            this.events = new HashSet<>();
        }
        this.events.add(event);
    }
    public void addTags(Tag tag) {
        tags.add(tag);
        tag.getStartupSet().add(this);
    }
}
