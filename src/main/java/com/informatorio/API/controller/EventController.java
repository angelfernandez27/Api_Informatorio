package com.informatorio.API.controller;

import com.informatorio.API.entity.Event;
import com.informatorio.API.entity.EventDTO;
import com.informatorio.API.exception.ApiException;
import com.informatorio.API.repository.IEventRepository;
import com.informatorio.API.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    IEventService eventService;
    @Autowired
    IEventRepository eventRepository;


    @PostMapping
    private ResponseEntity<?> createEvent(@RequestBody Event event){
        eventService.createEvent(event);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/ranking/{id}")
    public Optional<Event> rankingEventById(@PathVariable("id") Long id) throws ApiException {
        if (!eventRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        return  eventService.rankingEventId(id);
    }
    @GetMapping("/list")
    public Set<EventDTO> getAll(){
        return eventService.getAll();
    }
    @PutMapping("/update/{idEvent}")
    public ResponseEntity<?> updateEvent(@Valid @PathVariable("idEvent") Long idEvent,@Valid @RequestBody Event event) throws ApiException {
        if (eventRepository.getById(idEvent).getId()!=event.getId()){
         throw new ApiException("id does not match");
        }
        eventService.UpDateEvent(event);
        return ResponseEntity.status(HttpStatus.OK).body("Update Event");
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateEvent(@PathVariable Long id) throws ApiException {
        if (!eventRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        eventService.deactivateEvent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Event deactivated");
    }
    @PutMapping("/activate/{id}")
    public ResponseEntity<?> activateEvent(@PathVariable Long id) throws ApiException {
        if (!eventRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        eventService.activateEvent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Event activated");
    }
}
