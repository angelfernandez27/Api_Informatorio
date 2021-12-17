package com.informatorio.API.service;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.StartupDTO;
import java.util.Collection;
import java.util.Set;
public interface IStartupService {
    Collection<StartupDTO> getAllStartups();
    StartupDTO findStartup(Long id);
    void deactivateStartup(Long id);
    void activateStartup(Long id);
    void upDateStartup(Startup startup);
    Startup save(Long userId, Startup startup);
    Set<StartupDTO> findByLike(String name);
    Set<StartupDTO> getStartupByPublished(boolean published);
}
