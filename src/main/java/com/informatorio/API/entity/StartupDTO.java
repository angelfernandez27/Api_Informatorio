package com.informatorio.API.entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Getter @Setter
public class StartupDTO {
    private Long id;
    private String name;
    private String description;
    private double objective;
    private boolean published;
    private String content;
    private Set<Url> urls=new HashSet<Url>();
    private Set<Tag> tags;
    private Date creationDate;
}
