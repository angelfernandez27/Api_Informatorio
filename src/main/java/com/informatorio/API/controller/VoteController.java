package com.informatorio.API.controller;
import com.informatorio.API.entity.Vote;
import com.informatorio.API.exception.ApiException;
import com.informatorio.API.repository.IVoteRepository;
import com.informatorio.API.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    IVoteService voteService;
    @Autowired
    IVoteRepository voteRepository;

    @PostMapping("/createVote/userId/{userId}/startupId/{startupId}")
    public ResponseEntity<?> createVote(@PathVariable("userId") Long userId, @PathVariable("startupId") Long startupId,@RequestBody Vote vote) throws ApiException {
        List<Vote>votes=voteRepository.findAll();
        for (Vote vote1 : votes) {
            if (vote1.getStartUp().getId() == startupId && vote1.getUser().getId() == userId) {
                throw new ApiException("Error. Vote already exists.");
            }
        }
        voteService.createVote(userId,startupId,vote);
        return ResponseEntity.status(HttpStatus.OK).body("Vote created");
    }
    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable Long id) throws ApiException {
        if (!voteRepository.findById(id).isPresent()){
           throw  new ApiException("Id does not exist");
        }
        return voteService.findById(id);
    }
    @GetMapping("/voteUser/idUser/{id}")
    public Set<Vote> getVoteByUser(@PathVariable("id") Long id) throws ApiException {
        if (voteService.getVoteByUser(id).isEmpty()){
            throw new ApiException("user id has no votes");
        }
        return voteService.getVoteByUser(id);
    }
}
