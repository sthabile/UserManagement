package sn.pp.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.pp.usermanagement.model.User;
import sn.pp.usermanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser (@RequestBody User newUser){
        try{
            User userToSave = new User(newUser);
           return ResponseEntity.ok().body(userService.saveUser(userToSave));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser (@RequestBody User updatedUser){
        try{
            return ResponseEntity.ok().body(userService.updateUser(updatedUser));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
