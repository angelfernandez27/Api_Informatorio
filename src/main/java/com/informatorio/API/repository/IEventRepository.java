package com.informatorio.API.repository;
import com.informatorio.API.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IEventRepository extends JpaRepository<Event,Long> {

}
