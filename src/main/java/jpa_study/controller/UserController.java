package jpa_study.controller;

import jpa_study.dto.AddUserReqDto;
import jpa_study.dto.EditUserReqDto;
import jpa_study.service.PostService;
import jpa_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    ResponseEntity<?>getUserAll(@RequestBody AddUserReqDto addUserReqDto){
        return ResponseEntity.ok(userService.addUser(addUserReqDto));
    }
    @GetMapping("/all")
    ResponseEntity<?>getUserAll(){
        return ResponseEntity.ok(userService.getUserAll());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?>getUserByUserId(@RequestBody Integer userId){
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }
    @GetMapping("/get/user")
    public ResponseEntity<?>getUserListByUserId(@RequestParam Integer userId){
        return ResponseEntity.ok(userService.getUserListByUserId(userId));
    }
    @PostMapping("/edit")
    public ResponseEntity<?>editUser(@RequestBody EditUserReqDto editUserReqDto){
        return ResponseEntity.ok(userService.editUser(editUserReqDto));
    }
    @PostMapping("/remove")
    public ResponseEntity<?> removeUser(@RequestBody Integer userId){
        return ResponseEntity.ok(userService.removeUser(userId));
    }
}
