package com.informatorio.API.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter @Setter
public class UrlDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
}
