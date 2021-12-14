package com.informatorio.API.entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@Getter @Setter
public class StartupDTO {
    private Long id;
    private String name;
    private String description;
    private double objective;
    private boolean published;
    private String content;
    private Set<Url> urls;
    private Tag tag;
    private Date creationDate;
}
