package com.informatorio.API.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatorio.API.entity.Startup;
import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;
import com.informatorio.API.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void createUser(User user) {
         userRepository.save(user);

    }

    @Override
    public Collection<UserDTO> getAll() {
        List<User> users= userRepository.findAll();
        Set<UserDTO> userDTOS= new HashSet<>();
        for (User user: users){
            userDTOS.add(mapper.convertValue(user, UserDTO.class));
        }
        return userDTOS;
    }

    @Override
    public UserDTO findUser(Long id) {
        UserDTO userDTO=null;
        Optional<User> user=userRepository.findById(id);
        if (user.isPresent()){
            userDTO=mapper.convertValue(user,UserDTO.class);
        }
        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
   public Set<UserDTO> getUsersByCity(String city) {
        Set<User>users=userRepository.getUserByCity(city);
        Set<UserDTO>userDTOSet=new HashSet<>();
        for (User user : users) {
           userDTOSet.add(mapper.convertValue(user,UserDTO.class));
        }
        return userDTOSet;
    }

    @Override
    public Set<UserDTO> getUserByDate(Date date) {
        Set<User>users=userRepository.getUserByDate(date);
        Set<UserDTO>userDTOSet=new HashSet<>();
        for (User user : users) {
            userDTOSet.add(mapper.convertValue(user,UserDTO.class));
        }
        return userDTOSet;
    }

    @Override
    public void upDateUser(User user) {
        userRepository.save(user);
    }
    //no anda
    @Override
    public void updateIdUser(Long id,User user) {
        Optional<User>user1=userRepository.findById(id);
        if (user1.isPresent()){
            user=mapper.convertValue(user1,User.class);
            userRepository.save(user);
        }


    }



}
