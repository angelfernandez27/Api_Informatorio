package com.informatorio.API.repository;

import com.informatorio.API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    @Query("FROM User u WHERE u.city = :city")
    Set<User> getUserByCity(@Param("city") String city);
    @Query("FROM User u WHERE u.creationDate > :date")
    Set<User> getUserByDate(@Param("date")Date date);
   //ist<User> updateIdUser(User user);//
}
