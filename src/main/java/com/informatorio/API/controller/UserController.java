package com.informatorio.API.controller;

import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;

import com.informatorio.API.exception.ApiException;
import com.informatorio.API.repository.IUserRepository;
import com.informatorio.API.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iUserService;
    @Autowired
    IUserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody User user)throws ApiException {
        User user1;
        try {
            user1=iUserService.createUser(user);

        }catch(Exception e) {
             throw new ApiException("User denegated");
        }
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public Collection<UserDTO> listUsers(){
        return iUserService.getAll();
    }
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) throws ApiException {
        if (!userRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        return iUserService.findUser(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws ApiException {
        if (!userRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        iUserService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User eliminated");
    }
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateUser(@PathVariable Long id) throws ApiException {
        if (!userRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        iUserService.deactivateUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deactivated");
    }
    @PutMapping("/activate/{id}")
    public ResponseEntity<?> activateUser(@PathVariable Long id) throws ApiException {
        if (!userRepository.findById(id).isPresent()){
            throw new ApiException("id does not exist");
        }
        iUserService.activateUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User activated");
    }
    @GetMapping("/list/city")
    public Set<UserDTO> getUsersByCity(@RequestParam("city") String city){
        return iUserService.getUsersByCity(city);
    }
    @GetMapping("/list/date")
    public Set<UserDTO> getUsersByDate(@RequestParam("date") Date date){
        return iUserService.getUserByDate(date);
    }

    @PutMapping("/userId/{id}/update")
    public ResponseEntity<?> upDateByIdUser (@Valid @PathVariable("id")Long id, @Valid @RequestBody User user) throws ApiException{
        User user1 = null;
        Optional<User>user2=userRepository.findById(id);
        if (!user2.isPresent()){
            throw new ApiException("id does not exist");
        }
        try {
            user1=iUserService.updateIdUser(id,user);
            //return new ResponseEntity<>(user1,HttpStatus.CREATED);
        }catch(Exception e){
             throw new ApiException("Error: ya se encuentra resgistrado el mail:");
        }
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }
}
