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
    public User createUser(User user) {
         return userRepository.save(user);
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
    public User updateIdUser(Long id,User user) {
        User userM= userRepository.getById(id);
        if (!user.getName().trim().isEmpty()) { userM.setName(user.getName());}
        if (!user.getLastName().trim().isEmpty()) { userM.setLastName(user.getLastName()); }
        if (!user.getEmail().trim().isEmpty()){userM.setEmail(user.getEmail());}
        if (!user.getPassword().trim().isEmpty()){userM.setPassword(user.getPassword());}
        if (!user.getCity().trim().isEmpty()){userM.setCity(user.getCity());}
        if (!user.getProvince().trim().isEmpty()){userM.setProvince(user.getProvince());}
        if (!user.getCountry().trim().isEmpty()){userM.setCountry(user.getCountry());}
        if (user.getType() != null){ userM.setType(user.getType());}
        userM.setCreationDate(user.getCreationDate());
        return userRepository.save(userM);
    }

    @Override
    public void deactivateUser(Long id) {
        User user=userRepository.getById(id);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public void activateUser(Long id) {
        User user=userRepository.getById(id);
        user.setActive(true);
        userRepository.save(user);
    }


}
