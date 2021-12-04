package com.informatorio.API.repository;
import com.informatorio.API.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrlRepository extends JpaRepository<Url,Long> {
}
