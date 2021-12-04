package com.informatorio.API.controller;

import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.StartupDTO;
import com.informatorio.API.repository.IStartupRepository;
import com.informatorio.API.service.IStartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/startup")
public class StartupController {
    @Autowired
    IStartupService startupService;

    @PostMapping
    public ResponseEntity<?> createStartup(@RequestBody Startup startup){
        startupService.createStartup(startup);
        return ResponseEntity.status(HttpStatus.OK).body("Startup created");
    }
    @GetMapping("/{id}")
    public StartupDTO findStartup(@PathVariable Long id){
        return startupService.findStartup(id);
    }
    @GetMapping("/list")
    public Collection<StartupDTO> getAllStartups(){
        return startupService.getAllStartups();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStartup(@PathVariable Long id){
        startupService.deleteStartup(id);
        return ResponseEntity.status(HttpStatus.OK).body("Startup elimited");
    }
    @PutMapping
    public ResponseEntity<?> upDateStartup(Startup startup){
        startupService.upDateStartup(startup);
        return ResponseEntity.status(HttpStatus.OK).body("Startup modifiqued");
    }
    @GetMapping("/listname")
    public Set<StartupDTO> getStartupByLikeName(@PathVariable String name){

        return startupService.getStartupByLikeName(name);
    }
    @GetMapping("/listpublished")
    public Set<StartupDTO> getStartupByNotPublished(@PathVariable boolean published){
        return startupService.getStartupByNotPublished(published);
    }



}