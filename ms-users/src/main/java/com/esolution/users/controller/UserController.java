package com.esolution.users.controller;

import com.esolution.users.dto.UserDto;
import com.esolution.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello there";
    }
//    @PreAuthorize("hasAuthority('SCOPE_DEMO')")
    @GetMapping("search/all")
    public List<UserDto> searchAll() {
        return userService.searchAll();
    }
    @GetMapping("search/{userId}")
    public UserDto search(@PathVariable("userId") String id) {
        return userService.search(id);
    }
    @PostMapping
    public UserDto add(@RequestBody UserDto dto) {
        return userService.add(dto);
    }
    @PutMapping
    public UserDto update(@RequestBody UserDto dto) {
        return userService.update(dto);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String userId) {
        userService.delete(userId);
    }
}
