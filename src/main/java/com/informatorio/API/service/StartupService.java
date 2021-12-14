package com.informatorio.API.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.StartupDTO;
import com.informatorio.API.entity.Tag;
import com.informatorio.API.entity.User;
import com.informatorio.API.repository.IStartupRepository;
import com.informatorio.API.repository.ITagRepository;
import com.informatorio.API.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TableGenerator;
import java.util.*;

@Service
public class StartupService implements IStartupService {

    @Autowired
    IStartupRepository startupRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    ITagRepository tagRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void createStartup(Startup startup) {
        startupRepository.save(startup);
    }

    @Override
    public Collection<StartupDTO> getAllStartups() {
        List<Startup> startupList=startupRepository.findAll();
        Set<StartupDTO>startupDTOS=new HashSet<>();
        for (Startup startup : startupList) {
            startupDTOS.add(mapper.convertValue(startup,StartupDTO.class));
        }
        return startupDTOS;
    }

    @Override
    public StartupDTO findStartup(Long id) {
        StartupDTO startupDTO=null;
        Optional<Startup>startup=startupRepository.findById(id);
        if (startup.isPresent()){
            startupDTO=mapper.convertValue(startup,StartupDTO.class);
        }
        return startupDTO;
    }

    @Override
    public void deleteStartup(Long id) {
        startupRepository.deleteById(id);

    }

    @Override
    public void upDateStartup(Startup startup) {
        startupRepository.save(startup);

    }
    @Override
    public Startup save(Long userId, Startup startup) {
        User user = userRepository.getById(userId);
        startup.setCreator(user);
        return startupRepository.save(startup);
    }

    @Override
    public Set<Startup> startupsByTagName(String name) {
        Tag tag= tagRepository.findByName(name);
        return tag.getStartupSet();
    }

    /*@Override
    public Set<StartupDTO> getStartupByLikeName(String name) {
        Set<Startup>startups=startupRepository.getStartupByLikeName(name);
        Set<StartupDTO>startupDTOS=new HashSet<>();
        for (Startup startup : startups) {
            startupDTOS.add(mapper.convertValue(startup,StartupDTO.class));
        }
        return startupDTOS;
    }*/
    @Override
    public Set<StartupDTO> getStartupByNotPublished(boolean published) {
       Set<Startup>startups=startupRepository.getStartupByNotPublished(published);
       Set<StartupDTO>startupDTOS=new HashSet<>();
        for (Startup startup : startups) {
            startupDTOS.add(mapper.convertValue(startup,StartupDTO.class));
        }
        return startupDTOS;
    }



    //public Set<Startup> getStartupOrderByDesc() {
      //  return startupRepository.getStartupOrderByDesc();
    //}
}
