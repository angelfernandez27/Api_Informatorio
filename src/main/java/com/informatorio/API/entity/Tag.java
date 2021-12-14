package com.informatorio.API.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Tag")
@Getter @Setter @ToString
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Startup> startupSet = new HashSet<Startup>();
}
