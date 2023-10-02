package com.formationspring.sncfchatp3.controllers;

import com.formationspring.sncfchatp3.domain.User;
import com.formationspring.sncfchatp3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService cni;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> films = cni.getUsers();

        return ResponseEntity.ok(films);

    }
    @GetMapping(path="/new")
    public ResponseEntity<User> nomDeLaMethodeGetUser2(@RequestParam(value="prenom",required = false) String firstname,
                                                       @RequestParam(value="age",required = false) Integer annee,
                                                       @RequestParam(value= "nom",required=false) String name){

        User personnage = cni.createUser(name,firstname,annee);


        return ResponseEntity.ok(personnage);





    }
    @DeleteMapping(path ="/deleteUsers")
    public ResponseEntity<Void> deleteTousLesUsers(){
        cni.serviceDeleteAllUsers();
        return ResponseEntity.ok().build();
    }

    @GetMapping(path= "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
       User recupererId = cni.findById(id);
       return ResponseEntity.ok(recupererId);


    }
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        cni.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path= "/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User user){
       User update = cni.updateById(id,user);
       return ResponseEntity.ok(update);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User personnage = cni.createUser(user);

        return ResponseEntity.ok(personnage);
    }

    @GetMapping (path = "/search")
    public ResponseEntity<List<User>> cherche(@RequestParam (value="mineur",required = false) Boolean minored ){

        List<User> search = cni.chercheMineur(minored);

        return ResponseEntity.ok(search);
    }


}
