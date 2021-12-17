package com.informatorio.API.service;
import com.informatorio.API.entity.Vote;
import java.util.Set;
public interface IVoteService {
    Vote createVote(Long userId,Long StartupId, Vote vote);
    Vote findById(Long id);
    Set<Vote> getVoteByUser(Long id);
}
