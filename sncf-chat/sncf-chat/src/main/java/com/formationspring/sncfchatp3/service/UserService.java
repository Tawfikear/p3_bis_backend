package com.formationspring.sncfchatp3.service;

import com.formationspring.sncfchatp3.domain.User;
import com.formationspring.sncfchatp3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(String name,String firstname, int age){
        User pieceIdentite = new User(name,firstname,age);
        return userRepository.saveUser(pieceIdentite) ;
    }

    public User createUser(User user){

        return userRepository.saveUser(user) ;
    }

    public List<User> getUsers() {
        return userRepository.findAllUsers();
    }

    public void serviceDeleteAllUsers(){
        userRepository.deleteAllUsers();
    }

    public User findById(Long id){
       return userRepository.findUserById(id);

    }

    public void deleteById(Long myId){
        userRepository.deleteUserById(myId);
    }

    public User updateById(Long id, User user ){
        return userRepository.updateUser(id,user);
    }

    public List<User> chercheMineur(Boolean minored){ return userRepository.chercheMineur(minored);}
}

