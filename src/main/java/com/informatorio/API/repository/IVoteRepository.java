package com.informatorio.API.repository;

import com.informatorio.API.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IVoteRepository extends JpaRepository<Vote,Long> {
    //Trae todos los votos de un idUser
   // @Query("FROM votes v Where v.user_id = :id")
    //Set<Vote>getVotesByIdUser(@Param("id") Long id);
    //@Query("from votes v  inner join fetch v.user_id where v.user_id = :id")
    //Set<User> findByReviewId(@Param("id") Long id);
    @Query("FROM Vote v WHERE v.generateBy LIKE %:name%")
    Set<Vote> getVoteByLikeName(@Param("name") String name);
}
