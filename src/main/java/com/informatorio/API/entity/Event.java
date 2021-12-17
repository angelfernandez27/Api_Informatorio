package com.informatorio.API.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private boolean active;
    @NotEmpty(message = "el campo stateno puede estar vacio")
    @Size(min=1, max = 255, message = "el campo state debe tener entre 2 y 255 caracteres")
    private String state;
    @Min(value = 0,message="El campo objetive debe ser mayor o igual a cero")
    private double prize;
    @ManyToMany(mappedBy = "events")
    @JsonIgnoreProperties({"creator","description","content","dateCreation","objective","published","tags"})
    @OrderBy("counterVote DESC")
    private Set<Startup> startupSet;
    public void addStartup(Startup startup){
        startupSet.add(startup);
        startup.addEvent(this);
    }
    public void removeStartup(Startup startup){
        startupSet.remove(startup);
        startup.addEvent(null);
    }
}
