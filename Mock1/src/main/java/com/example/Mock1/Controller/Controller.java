package com.example.Mock1.Controller;

import com.example.Mock1.Data.ServiceException;
import com.example.Mock1.Data.User;
import com.example.Mock1.Data.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.ReentrantLock;


@RestController
public class Controller {
    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public User getUser() {
        return new User("jojo","bean", "33", "Neville");
    }

    @PostMapping("/home")
    public ResponseEntity<?> postUser(@RequestBody User receivedUser) {
        try {
            return ResponseEntity.ok(userService.getUserWithDate(receivedUser));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
