package com.informatorio.API.controller;

import com.informatorio.API.entity.Url;
import com.informatorio.API.entity.UrlDTO;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import com.informatorio.API.service.IUrlService;
import com.informatorio.API.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/urls")
public class UrlController {
    @Autowired
    IUrlService urlService;

    @PostMapping
    public ResponseEntity<?> addUrl(@RequestBody Url url){
        urlService.crateUrl(url);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/list")
    public Collection<UrlDTO> listUrl(){
        return urlService.getAll();
    }
    @GetMapping("/{id}")
    public UrlDTO getUrl(@PathVariable Long id){
        return urlService.findUrl(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUrl(@PathVariable Long id){
        urlService.deleteUrl(id);
        return ResponseEntity.status(HttpStatus.OK).body("Url eliminated");
    }
}
