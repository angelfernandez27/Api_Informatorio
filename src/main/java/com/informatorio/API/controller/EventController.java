package com.informatorio.API.controller;

import com.informatorio.API.entity.Event;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.service.IEventService;
import com.informatorio.API.service.IStartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    IEventService eventService;


    @PostMapping
    private ResponseEntity<?> createEvent(@RequestBody Event event){
        eventService.createEvent(event);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Event findById(@PathVariable("id") Long id){
        return eventService.findEventById(id);
    }
    @GetMapping("/list")
    public List<Event> getAll(){
        return eventService.getAll();
    }
    @PutMapping()
    public ResponseEntity<?> updateEvent(Event event){
        eventService.UpDateEvent(event);
        return ResponseEntity.status(HttpStatus.OK).body("Update Event");
    }
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") Long id){
        eventService.deleteEvent(id);
    }
    //Traigo el ranking de startup
    //@GetMapping("/orderStartup")
    //public Set<Startup> getStartupOrderByDesc(){
      //  return startupService.getStartupOrderByDesc();
    //}
    @GetMapping("/orderStartup")
    public Set<Event>getEventOrderByDesc(){
        return eventService.getEventOrderByDesc();
    }
}
