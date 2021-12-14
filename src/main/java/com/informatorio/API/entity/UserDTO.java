package com.informatorio.API.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter @Setter
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Date creationDate;
    private String city;
    private String province;
    private String country;
    private Type type;
    private Set<Vote> voteSet;
}
