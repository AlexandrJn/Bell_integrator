package com.example.Mock1.Controller;

import com.example.Mock1.Data.ActualUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class Controller {

    @GetMapping("/home")
    User getUser() {
        return new User("jojo","bean", "33", "Neville");
    }

    @PostMapping("/home")
    ActualUser postUser(@RequestBody User receivedUser) {
        if(receivedUser==null) {
        throw new BadDataException();
        }
        return new ActualUser(receivedUser.getLogin(), LocalDateTime.now().toString());
    }
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "You`ve sent wrong data in request body")
    public class BadDataException extends RuntimeException {
        public BadDataException(){}

    }
}
