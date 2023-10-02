package com.formationspring.sncfchatp3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }
    @GetMapping(path = "/byby2")
    public ResponseEntity<String> byby(){
        return ResponseEntity.ok("byby1");
    }
    @GetMapping(path = "/route3")
    public ResponseEntity<String>direction(@RequestParam(value="prenom",required = false) String name,
                                           @RequestParam(value="age",required = false) Integer annee){
        if (name==null){
          return ResponseEntity.ok("autrerouteur");
        }
        else{
            if (annee>18){
                return ResponseEntity.ok( "routeur "+name +" "+annee);

            } else {
                return ResponseEntity.ok("routeur "+name);
            }


        }


    }
    @PostMapping(path = "/route3")
    public ResponseEntity<String>direction(@RequestBody String body){
        return ResponseEntity.ok("routeur "+body);



    }
}

