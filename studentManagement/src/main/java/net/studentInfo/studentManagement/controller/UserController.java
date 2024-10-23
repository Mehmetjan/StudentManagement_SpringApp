package net.studentInfo.studentManagement.controller;

import net.studentInfo.studentManagement.entity.User;
import net.studentInfo.studentManagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // build create user RestApi
  @PostMapping
    public ResponseEntity<User>  createuser(@RequestBody User user){

        User saveuser= userService.createUser(user);
        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);

    }

    @GetMapping("{id}")

    public ResponseEntity<User> getuserById(@PathVariable("id") int userId){
        User user= userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    // build get all users restAPI
  @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // update user
   @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int userId, @RequestBody  User user){
          user.setId(userId);
         User updatedUser= userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    // delete user by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User has deleted", HttpStatus.OK);
    }

}
