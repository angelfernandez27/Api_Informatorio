package com.informatorio.API.service;

import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IUserService {

    public void createUser(User user);
    public Collection<UserDTO> getAll();
    public UserDTO findUser(Long id);
    public void deleteUser(Long id);
    Set<UserDTO> getUsersByCity(String city);
    Set<UserDTO> getUserByDate(Date date);
    void upDateUser(User user);
    void updateIdUser(Long id,User user);

}
