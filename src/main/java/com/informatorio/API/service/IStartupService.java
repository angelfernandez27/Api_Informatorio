package com.informatorio.API.service;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.StartupDTO;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Set;
public interface IStartupService {
    void createStartup(Startup startup);
    Collection<StartupDTO> getAllStartups();
    StartupDTO findStartup(Long id);
    void deleteStartup(Long id);
    void upDateStartup(Startup startup);
    Set<StartupDTO> getStartupByLikeName(String name);
    Set<StartupDTO> getStartupByNotPublished(boolean published);
}
