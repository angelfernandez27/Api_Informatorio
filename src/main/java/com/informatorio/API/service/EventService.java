package com.informatorio.API.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatorio.API.entity.Event;
import com.informatorio.API.entity.EventDTO;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.Vote;
import com.informatorio.API.repository.IEventRepository;
import com.informatorio.API.repository.IStartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class EventService implements IEventService{
    @Autowired
    IEventRepository eventRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }
    @Override
    public Optional<Event> rankingEventId(Long id) {
        return eventRepository.findById(id);
    }
    @Override
    public Set<EventDTO> getAll() {
         List<Event>events=eventRepository.findAll();
         Set<EventDTO>eventDTOSet=new HashSet<>();
        for (Event event : events) {
            eventDTOSet.add(mapper.convertValue(event,EventDTO.class));
        }
        return eventDTOSet;
    }
    @Override
    public void UpDateEvent(Event event) {
        eventRepository.save(event);
    }
    @Override
    public void deactivateEvent(Long id) {
        Event event=eventRepository.getById(id);
        event.setActive(false);
        eventRepository.save(event);
    }
    @Override
    public void activateEvent(Long id) {
        Event event=eventRepository.getById(id);
        event.setActive(true);
        eventRepository.save(event);
    }
}
