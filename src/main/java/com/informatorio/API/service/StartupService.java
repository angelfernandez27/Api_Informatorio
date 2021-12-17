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
    public void deactivateStartup(Long id) {
        Startup startup=startupRepository.getById(id);
        startup.setPublished(false);
        startupRepository.save(startup);
    }

    @Override
    public void activateStartup(Long id) {
        Startup startup=startupRepository.getById(id);
        startup.setPublished(true);
        startupRepository.save(startup);
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
    public Set<StartupDTO> findByLike(String name) {
        Set<Tag> tag=tagRepository.findByLike(name);
         //Set<Startup> startups=tag.getStartupSet();
        Set<Startup>startups=new HashSet<>();
        Set<StartupDTO>startupDTOS=new HashSet<>();
        for (Tag tag1 : tag) {
            startups=tag1.getStartupSet();
        }
        for (Startup startup : startups) {
            startupDTOS.add(mapper.convertValue(startup,StartupDTO.class));
        }
        return startupDTOS;
    }
    @Override
    public Set<StartupDTO> getStartupByPublished(boolean published) {
       Set<Startup>startups=startupRepository.getStartupByPublished(published);
       Set<StartupDTO>startupDTOS=new HashSet<>();
        for (Startup startup : startups) {
            startupDTOS.add(mapper.convertValue(startup,StartupDTO.class));
        }
        return startupDTOS;
    }
}
