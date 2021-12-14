package com.informatorio.API.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import com.informatorio.API.entity.Vote;
import com.informatorio.API.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VoteService implements IVoteService{
    @Autowired
    IVoteRepository voteRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void createVote(Vote vote) {
        voteRepository.save(vote);

    }
    @Override
    public Vote findById(Long id) {
        return voteRepository.getById(id);
    }

    @Override
    public Set<Vote> getVoteByUser(Long id) {
        return voteRepository.getVoteByUser(id);
    }

    /*@Override
    public Set<Vote> findVotesUserId(Long id) {
        return voteRepository.findVotesUserId(id);
    }

    @Override
    public Vote findVote(Long id) {
       return voteRepository.getById(id);
    }

    @Override
    public List<Vote> getUserByUd(Long id) {
        Optional<Vote> vote=voteRepository.findById(id);
        List<Vote> votes=new ArrayList<>();
        if (vote.isPresent()){
            votes.add(vote.get());
        }
        return votes;
    }

    @Override
    public List<Vote> findByUserId(Long id) {
        return  voteRepository.findByUserId(id);
    }



    @Override
    public Set<Vote> getVoteByLikeName(String name) {
        return voteRepository.getVoteByLikeName(name);
    }
    //@Override
    //public Set<Vote> getVotesByIdUser(Long id) {
      //  return voteRepository.getVotesByIdUser(id);
    //}

    @Override
    public Collection<Vote> getAll(){
        List<Vote>votes=voteRepository.findAll();
        return votes;
    };*/

}
