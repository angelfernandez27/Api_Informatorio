package com.informatorio.API.controller;

import com.informatorio.API.entity.User;
import com.informatorio.API.entity.UserDTO;

import com.informatorio.API.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

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
    @GetMapping("/list/city")
    public Set<UserDTO> getUsersByCity(@RequestParam("city") String city){
        return iUserService.getUsersByCity(city);
    }
    @GetMapping("/list/date")
    public Set<UserDTO> getUsersByDate(@RequestParam("date") Date date){
        return iUserService.getUserByDate(date);
    }
    @PutMapping("/update")
    public ResponseEntity<?> upDateUser(@RequestBody User user){
        iUserService.upDateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User update");
    }
    @PutMapping("/{id}/ula")
    public ResponseEntity<?>upDateByIdUser(@PathVariable("id")Long id,@RequestBody User user){
        iUserService.updateIdUser(id,user);
        return ResponseEntity.status(HttpStatus.OK).body("Update exitoso pa");

    }


}
