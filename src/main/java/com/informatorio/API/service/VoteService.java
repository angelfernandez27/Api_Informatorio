package com.informatorio.API.service;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.Vote;
import com.informatorio.API.repository.IStartupRepository;
import com.informatorio.API.repository.IUserRepository;
import com.informatorio.API.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class VoteService implements IVoteService{
    @Autowired
    IVoteRepository voteRepository;
    @Autowired
    IStartupRepository startupRepository;
    @Autowired
    IUserRepository userRepository;
    @Override
    public Vote createVote(Long userId,Long startupId, Vote vote){
        User user = userRepository.getById(userId);
        Startup startup=startupRepository.getById(startupId);
        startup.setCounterVote(startup.getCounterVote()+1);
        vote.setUser(user);
        vote.setStartUp(startup);
       return voteRepository.save(vote);
    }
    @Override
    public Vote findById(Long id) {
        return voteRepository.getById(id);
    }
    @Override
    public Set<Vote> getVoteByUser(Long id) {
        return voteRepository.getVoteByUser(id);
    }
}
