package com.informatorio.API.service;
import com.informatorio.API.entity.Event;
import com.informatorio.API.entity.EventDTO;
import java.util.Optional;
import java.util.Set;
public interface IEventService {
    void createEvent(Event event);
    Optional<Event>rankingEventId(Long id);
    Set<EventDTO> getAll();
    void UpDateEvent(Event event);
    void deactivateEvent(Long id);
    void activateEvent(Long id);

}
