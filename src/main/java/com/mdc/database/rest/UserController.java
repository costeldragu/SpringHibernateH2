package com.mdc.database.rest;

import com.mdc.database.dto.UserDto;
import com.mdc.database.jpa.UserRepository;
import com.mdc.database.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> listAllUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(userService.mapToDto(user));
        });
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestBody UserDto user) {
        userRepository.save(userService.mapFromDto(user));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/add/bulk")
    public ResponseEntity<?> addBulNewUser(@RequestBody List<UserDto> users) {
        users.forEach(user -> userRepository.save(userService.mapFromDto(user)));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable("userID") Long userId) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/audit/{userID}")
    public ResponseEntity<?> userAudit(@PathVariable("userID") Long userId) {
        return new ResponseEntity<>(userService.getAllRevision(userId), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto user) {
        userRepository.save(userService.mapFromDto(user));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
