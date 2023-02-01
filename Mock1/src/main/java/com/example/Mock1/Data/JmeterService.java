package com.example.Mock1.Data;

import org.springframework.stereotype.Service;

@Service
public class JmeterService {

    public User jmeterDataIn(User receivedFromJmeter) throws ServiceException {
        if (receivedFromJmeter.getLogin()==null) {
            System.out.println("No login in request");
            throw new ServiceException("No login in request");
        } else if (receivedFromJmeter.getPassword()==null || receivedFromJmeter.getEmail()==null) {
            System.out.println("Request need login, password, email");
            throw new ServiceException("Request need login, password, email");
        }
        return new User(receivedFromJmeter.getLogin(), receivedFromJmeter.getPassword(), receivedFromJmeter.getEmail());
    }
    public SqlToJmeter jmeterDataOut(SqlToJmeter sendToJmeter) {
        return new SqlToJmeter(sendToJmeter.getLogin(), sendToJmeter.getPassword(), sendToJmeter.getEmail());
    }

}
