package com.informatorio.API.repository;

import com.informatorio.API.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IVoteRepository extends JpaRepository<Vote,Long> {
    //Método para traer todos los votos de usuario
    //@Query("from votes v  inner join fetch v.user_id where v.user_id = :id")
    //Set<User> findByReviewId(@Param("id") Long id);

    //Segundo intento que tampoco anduvo
    //@Query("FROM Vote v WHERE v.generateBy LIKE %:name%")
    //Set<Vote> getVoteByLikeName(@Param("name") String name);
    //@Query("FROM vote v WHERE v.user.id = :id")
    //List<Vote> getUserByUd(@Param("id") Long id);
   // @Query("FROM vote v WHERE v.user.getID() = :id")
    //List<Vote> findByUserId(@Param("id") Long id);
    //@Query("FROM Vote v WHERE v.=:id")
    //Set<Vote> findVotesUserId(@Param("id")Long id);
    @Query("FROM Vote v inner join User u on u.id= v.user.id WHERE v.user.id= :id")
    Set<Vote> getVoteByUser(@Param("id") Long id);




}
