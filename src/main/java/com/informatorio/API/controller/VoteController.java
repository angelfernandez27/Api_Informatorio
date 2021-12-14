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
import java.util.List;
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
    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable Long id){
        return voteService.findById(id);
    }
    @GetMapping("/voteUser/{id}")
    public Set<Vote> getVoteByUser(@PathVariable("id") Long id){
        return voteService.getVoteByUser(id);
    }




   /*@GetMapping("/generate")
   public Set<Vote> getVoteByLikeName(@RequestParam String generate){

      Set<Vote>voteSet= voteService.getVoteByLikeName(generate);
      return  voteSet;
   }
   @GetMapping("/list")
   public Collection<Vote> listVotes(){
       return voteService.getAll();
   }

   @GetMapping("/{userId}")
   public ResponseEntity<?> getVotesFromAUser(
           @PathVariable("userId") Long userId) {
       return new ResponseEntity<>(voteService.findByUserId(userId), HttpStatus.OK);
   }
   @GetMapping("/{id}")
   public List<Vote> getUserByUd(@PathVariable Long id) {
       List<Vote>voteSet= voteService.getUserByUd(id);
       return  voteSet;
   }
   @GetMapping(value = "/{id}")
   public ResponseEntity<?> getProductById(@PathVariable Long id) {
       Vote vote = voteService.findById(id);
       return new ResponseEntity<Vote>(vote, HttpStatus.OK);
   }
   @GetMapping("/{id}")
   public Vote getVote(@PathVariable Long id){
       return voteService.findVote(id);
   }
    @GetMapping("/votesUsers/{id}")
    public Set<Vote>findVotesByIdUser(@PathVariable Long id){
        return voteService.findVotesUserId(id);
    }*/
}
