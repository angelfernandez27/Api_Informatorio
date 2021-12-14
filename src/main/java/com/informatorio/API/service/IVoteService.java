package com.informatorio.API.service;

import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import com.informatorio.API.entity.Vote;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IVoteService {
    void createVote(Vote vote);
   // Set<Vote> getVotesByIdUser(Long id);
   //Set<User> findByReviewId(Long id);
   //Set<Vote> getVoteByLikeName(String name);
    //Collection<Vote> getAll();
   //List<Vote> getUserByUd(Long id);
   //List<Vote> findByUserId(Long id);
    Vote findById(Long id);
  // public Vote findVote(Long id);
  //Set<Vote> findVotesUserId(Long id);
  Set<Vote> getVoteByUser(Long id);


}
