package com.informatorio.API.repository;
import com.informatorio.API.entity.Startup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Set;
@Repository
public interface IStartupRepository extends JpaRepository<Startup,Long> {
    @Query("FROM Startup su WHERE su.published = :false")
    Set<Startup> getStartupByPublished(@Param("false") boolean published);
}
