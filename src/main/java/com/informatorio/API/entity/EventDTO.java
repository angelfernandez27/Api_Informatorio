package com.informatorio.API.entity;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Set;
@Getter @Setter
public  class  EventDTO {
    private Long Id;
    private String descriptionEvent;
    private Date creationDate;
    private Date closureDate;
    private String state;
    private double prize;
    private Set<Startup> startupSet;
}
