package com.formationspring.sncfchatp3.service;

import com.formationspring.sncfchatp3.domain.Role;
import com.formationspring.sncfchatp3.domain.Train;
import com.formationspring.sncfchatp3.repository.RoleRepository;
import com.formationspring.sncfchatp3.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;
    public List<Train> findAllTrains(){
        return trainRepository.findAll();
    }
    public Train saveTrain(Train rapid){
      return trainRepository.save(rapid);
    }
}
