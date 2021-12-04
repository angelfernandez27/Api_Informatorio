package com.informatorio.API.service;

import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import com.informatorio.API.entity.Vote;
import com.informatorio.API.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class VoteService implements IVoteService{
    @Autowired
    IVoteRepository voteRepository;
    @Override
    public void createVote(Vote vote) {
        voteRepository.save(vote);

    }

    @Override
    public Set<Vote> getVoteByLikeName(String name) {
        return voteRepository.getVoteByLikeName(name);
    }
    //@Override
    //public Set<Vote> getVotesByIdUser(Long id) {
      //  return voteRepository.getVotesByIdUser(id);
    //}
    //public Set<User> findByReviewId(Long id){
      //  return  voteRepository.findByReviewId(id);
    //}
    @Override
    public Collection<Vote> getAll(){
        List<Vote>votes=voteRepository.findAll();
        return votes;
    };

}
