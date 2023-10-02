package com.formationspring.sncfchatp3.controllers;

import com.formationspring.sncfchatp3.domain.Role;
import com.formationspring.sncfchatp3.domain.Train;
import com.formationspring.sncfchatp3.domain.User;
import com.formationspring.sncfchatp3.service.RoleService;
import com.formationspring.sncfchatp3.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/trains")
public class TrainController {
    @Autowired
    private TrainService service;

    @GetMapping
    public ResponseEntity<List<Train>> getTrains(){
        List<Train> trains = service.findAllTrains();

        return ResponseEntity.ok(trains);
    }

    @PostMapping
    public ResponseEntity<Train> createTrain(@RequestBody Train train){
        Train fast = service.saveTrain(train);

        return ResponseEntity.ok(fast);
    }

}
