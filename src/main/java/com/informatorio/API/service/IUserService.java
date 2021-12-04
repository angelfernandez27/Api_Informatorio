package com.informatorio.API.service;

import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;

import java.util.Collection;

public interface IUserService {

    public void createUser(User user);
    public Collection<UserDTO> getAll();
    public UserDTO findUser(Long id);
    public void deleteUser(Long id);
}
