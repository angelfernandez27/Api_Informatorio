package com.informatorio.API.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
}
