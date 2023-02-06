package com.example.Mock1.Controller;

import com.example.Mock1.Data.User;
import org.springframework.web.bind.annotation.*;
import com.example.Mock1.Data.JDBCPostgres;



@RestController
public class Controller{

    @GetMapping("/home/{login}")
    public User getUser(@PathVariable String login) throws Exception{
        User user = new User();
        JDBCPostgres jdbcPostgres = new JDBCPostgres();
        try {
            user = jdbcPostgres.select(login);
            if (user.getLogin() == null || user.getLogin().isEmpty()){
                throw new JDBCPostgres.ServiceExceptionGet();
            }

        } catch (JDBCPostgres.ServiceExceptionGet e) {
            throw new JDBCPostgres.ServiceExceptionGet();
        }
        return user;
    }

    @PostMapping("/home")
    public String postUser(@RequestBody User user1) throws Exception{
        String result = new String();
        JDBCPostgres jdbcPostgres = new JDBCPostgres();
        try {
            if (user1.getLogin()==null){
                throw new JDBCPostgres.ServiceExceptionPost();
            }
            result = jdbcPostgres.insert(user1.getLogin(), user1.getPassword(), user1.getEmail());
            return result;
        } catch (JDBCPostgres.ServiceExceptionPost e1) {
            throw new JDBCPostgres.ServiceExceptionPost();
        }

    }
}
