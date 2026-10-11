package br.edu.ifsp.bra.rest_exemplo.controller;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import br.edu.ifsp.bra.rest_exemplo.model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {
    // // GET /user -> http://localhost:8080/api/v1/user
    // @GetMapping("/user/{id}")
    // public User getUser(
    //     @RequestParam("user-name")
    //     String userName,
    //     @RequestParam("user-pwd")
    //     String userPwd,
    //     @PathVariable("id")
    //     Long id,
    //     @RequestHeader("User-Agent")
    //     String clientName
    // ) {
    //     System.out.println(clientName);
    //     return new User(userName+" - id: "+id, userPwd);
    // }
    // // POST /user -> http://localhost:8080/api/v1/user
    // @PostMapping("/user")
    // @ResponseStatus(code = HttpStatus.CREATED)
    // public User createUser( @RequestBody 
    //                         User user) {
    //                             user.setLogin(user.getLogin() + " - Recebido");        
    //     return user;
    // }    
    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        return ResponseEntity.status(HttpStatus.OK).body(
            new User("ifsp", "1234")
        );
    }
    @GetMapping("/user/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable String login) {
        return ResponseEntity.ok().body(
            new User(login, "1234")
        );
    }
    
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(
        @RequestBody User user) {
    }

    @PutMapping("user/{login}")
    public ResponseEntity<User> updateUser(@PathVariable String login, @RequestBody User updatUser) {
        
        return ResponseEntity.created(null).body(updatUser);
    }
    
    @DeleteMapping("/user/{login}")
    public void updateUser (@PathVariable String login){

    }
    
}
