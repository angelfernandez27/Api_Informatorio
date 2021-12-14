package com.informatorio.API.service;

import com.informatorio.API.entity.Event;
import com.informatorio.API.entity.Startup;

import java.util.List;
import java.util.Set;

public interface IEventService {
    void createEvent(Event event);
    Event findEventById(Long id);
    List<Event> getAll();
    void UpDateEvent(Event event);
    void deleteEvent(Long id);
    Set<Event> getEventOrderByDesc();
}
