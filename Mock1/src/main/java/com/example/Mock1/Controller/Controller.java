package com.example.Mock1.Controller;

import com.example.Mock1.Data.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class Controller{

    private final JmeterService jmeterService;

    public Controller(JmeterService jmeterService) {
        this.jmeterService = jmeterService;
    }

    @GetMapping("/home")
    public ResponseEntity<?> getFromJmeter(@RequestParam String login) throws Exception{
        try {
            JDBCPostgres methodSelect = new JDBCPostgres();
            methodSelect.driverJdbcPostgres();
            methodSelect.select(login);
            return ResponseEntity.ok("Select OK");
        } catch (ServiceException getException) {
            return ResponseEntity.badRequest().body(getException.getMessage());
        }
    }

    @PostMapping("/home")
    public ResponseEntity<?> postUser(@RequestBody User receivedFromJmeter) throws Exception{
        try {
            JDBCPostgres methodInsert = new JDBCPostgres();
            methodInsert.driverJdbcPostgres();
            methodInsert.insert(receivedFromJmeter.getLogin(), receivedFromJmeter.getPassword(), receivedFromJmeter.getEmail());
            return ResponseEntity.ok("Insert OK");
        } catch (ServiceException postException) {
            return ResponseEntity.internalServerError().body(postException.getMessage());
        }
    }
}
