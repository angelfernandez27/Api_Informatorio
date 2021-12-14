package com.informatorio.API.service;

import com.informatorio.API.entity.Event;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService implements IEventService{
    @Autowired
    IEventRepository eventRepository;
    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);

    }

    @Override
    public Event findEventById(Long id) {
        return eventRepository.getById(id);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }


    @Override
    public void UpDateEvent(Event event) {
        eventRepository.save(event);

    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);

    }

    @Override
    public Set<Event> getEventOrderByDesc() {
        return eventRepository.getEventOrderByDesc();
    }

}
