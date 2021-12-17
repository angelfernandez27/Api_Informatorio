package com.informatorio.API.controller;

import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.StartupDTO;
import com.informatorio.API.entity.User;
import com.informatorio.API.exception.ApiException;
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
    @Autowired
    IStartupRepository startupRepository;
    @GetMapping("/{id}")
    public StartupDTO findStartup(@PathVariable Long id){
        return startupService.findStartup(id);
    }
    @GetMapping("/list")
    public Collection<StartupDTO> getAllStartups(){
        return startupService.getAllStartups();
    }
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateStartup(@PathVariable Long id) throws ApiException {
        if (!startupRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        startupService.deactivateStartup(id);
        return ResponseEntity.status(HttpStatus.OK).body("Startup deactivated");
    }
    @PutMapping("/activate/{id}")
    public ResponseEntity<?> activateStartup(@PathVariable Long id) throws ApiException {
        if (!startupRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        startupService.activateStartup(id);
        return ResponseEntity.status(HttpStatus.OK).body("Startup activated");
    }
    @PutMapping("/update")
    public ResponseEntity<?> upDateStartup(@RequestBody Startup startup){
        startupService.upDateStartup(startup);
        return ResponseEntity.status(HttpStatus.OK).body("Startup modifique");
    }
    @GetMapping("/list/published")
    public Set<StartupDTO> getStartupByNotPublished(@RequestParam boolean published){
        return startupService.getStartupByPublished(published);
    }
    @PostMapping(value = "/user/{id}/startup")
    public ResponseEntity<?> saveStartup(@PathVariable("id") Long userId,
                                                  @RequestBody Startup startup) throws ApiException {
        if (!startupRepository.findById(userId).isPresent()){
            throw new ApiException("id does not exist");
        }
        Startup startup1;
        try {
            startup1=startupService.save(userId, startup);

        }catch(Exception e) {
            throw new ApiException("Startup denegated");
        }
        return new ResponseEntity<>(startup1,HttpStatus.CREATED);
    }

    @GetMapping("/like")
    public Set<StartupDTO> getAllStartupsByLike(@RequestParam(name = "name",required = false)String name) throws ApiException {
        if (startupService.findByLike(name).size()<1){
            throw new ApiException("name not found");
        }
        return  startupService.findByLike(name);
    }



}
