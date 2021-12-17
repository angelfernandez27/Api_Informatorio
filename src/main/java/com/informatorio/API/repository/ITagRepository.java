package com.informatorio.API.repository;

import com.informatorio.API.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ITagRepository extends JpaRepository<Tag,Long> {
    @Query("FROM Tag t WHERE t.name LIKE %:name%")
    Set<Tag> findByLike(@Param("name") String name);
}
