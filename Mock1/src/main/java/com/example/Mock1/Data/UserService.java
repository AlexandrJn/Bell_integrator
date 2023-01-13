package com.example.Mock1.Data;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    public User getUserWithDate(User receivedUser) throws ServiceException {
        if (receivedUser==null) {
            System.out.println("Request body is empty");
            throw new ServiceException("Request body is empty");
        } else if (receivedUser.getLogin()==null) {
            System.out.println("There is no login in request body");
            throw new ServiceException("There is no login in request body");
        }
        return new User(receivedUser.getLogin(), LocalDateTime.now().toString());
    }


}
