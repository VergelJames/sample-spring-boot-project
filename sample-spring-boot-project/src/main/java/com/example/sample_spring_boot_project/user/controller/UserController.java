package com.example.sample_spring_boot_project.user.controller;


import com.example.sample_spring_boot_project.user.controller.request.UserRequest;
import com.example.sample_spring_boot_project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    ResponseEntity<Object> findAllUsers(){
        return new ResponseEntity<>(this.userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("paged")
    ResponseEntity<Object> findAllUsers(Pageable pageable){
        return new ResponseEntity<>(this.userService.findAllUsers(pageable), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Object> addUser(@RequestBody UserRequest request){
        return new ResponseEntity<>(this.userService.addUser(request), HttpStatus.CREATED);
    }

    @PutMapping("{uuid}")
    ResponseEntity<Object> updateUser(@PathVariable(name = "uuid") UUID uuid, @RequestBody UserRequest request){
        return new ResponseEntity<>(this.userService.updateUser(uuid, request), HttpStatus.OK);
    }

}
