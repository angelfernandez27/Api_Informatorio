package com.informatorio.API.repository;

import com.informatorio.API.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
