package com.informatorio.API.controller;

import com.informatorio.API.entity.StartupDTO;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import com.informatorio.API.entity.Vote;
import com.informatorio.API.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    IVoteService voteService;

    @PostMapping
    public ResponseEntity<?> createVote(Vote vote){
        voteService.createVote(vote);
        return ResponseEntity.status(HttpStatus.OK).body("Vote created");
    }
   // @GetMapping("{id}")
    //public Set<Vote> getVotesByIdUser(Long id){
      //  return voteService.getVotesByIdUser(id);
    //}
    //@GetMapping("{id}")
    //public Set<User> findByReviewId(Long id){
      //return voteService.findByReviewId(id);
    //}

   @GetMapping("/generate")
   public Set<Vote> getVoteByLikeName(@RequestParam String generate){

      Set<Vote>voteSet= voteService.getVoteByLikeName(generate);
      return  voteSet;
   }
   @GetMapping("/list")
   public Collection<Vote> listVotes(){
       return voteService.getAll();
   }



}
