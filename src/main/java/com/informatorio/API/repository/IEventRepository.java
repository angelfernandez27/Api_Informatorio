package com.informatorio.API.repository;

import com.informatorio.API.entity.Event;
import com.informatorio.API.entity.Startup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IEventRepository extends JpaRepository<Event,Long> {
    @Query("FROM Event e order by e.prize DESC")
    Set<Event> getEventOrderByDesc();

}
