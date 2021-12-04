package com.informatorio.API.controller;

import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;

import com.informatorio.API.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        iUserService.createUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/list")
    public Collection<UserDTO> listUsers(){
        return iUserService.getAll();
    }
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return iUserService.findUser(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        iUserService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado");
    }


}
