package com.informatorio.API.repository;
import com.informatorio.API.entity.Startup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Set;
@Repository
public interface IStartupRepository extends JpaRepository<Startup,Long> {
    //@Query("FROM Startup s inner join Tag t on s.tag.id=t.id where t.name like %:name%")
    //Set<Startup> getStartupByLikeName(@Param("name") String name);
    @Query("FROM Startup su WHERE su.published = :false")
    Set<Startup> getStartupByNotPublished(@Param("false") boolean published);
   // @Query("FROM Startup su ORDER BY su.objetive DESC")
   // Set<Startup> getStartupOrderByDesc();

}
