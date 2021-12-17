package com.informatorio.API.service;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
public interface IUserService {

    User createUser(User user);
    Collection<UserDTO> getAll();
    UserDTO findUser(Long id);
    void deleteUser(Long id);
    Set<UserDTO> getUsersByCity(String city);
    Set<UserDTO> getUserByDate(Date date);
    User updateIdUser(Long id,User user);
    void deactivateUser(Long id);
    void activateUser(Long id);
}
