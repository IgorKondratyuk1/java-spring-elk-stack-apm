package com.example.elastic.contoller;

import co.elastic.apm.api.*;
import com.example.elastic.dto.request.CreateUserDto;
import com.example.elastic.dto.response.ViewUserDto;
import com.example.elastic.service.UserService;
import com.example.elastic.util.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    @CaptureTransaction("GET /users getAllUsers")
//    public List<ViewUserDto> getAllUsers() {
//        log.info("getAllUsers");
//        return UserMapper.mapEntityListToViewList(this.userService.getAllUsers());
//    }

    // Manual transaction create
    @GetMapping
    public List<ViewUserDto> getAllUsers() {
        Transaction transaction = ElasticApm.startTransaction();
        try (Scope scope = transaction.activate()) {
            transaction.setName("GET /users getAllUsers");
            transaction.setType(Transaction.TYPE_REQUEST);

            log.info("getAllUsers");
            return UserMapper.mapEntityListToViewList(this.userService.getAllUsers());
        } catch (Exception e) {
            transaction.captureException(e);
            throw e;
        } finally {
            transaction.end();
        }
    }

    // By default transaction creates automatically
    @PostMapping
    public ViewUserDto createUser(@RequestBody CreateUserDto createUserDto) {
        ElasticApm.currentTransaction().setName("POST /users createUser");
        return UserMapper.mapEntityToView(this.userService.createUser(createUserDto));
    }
}
