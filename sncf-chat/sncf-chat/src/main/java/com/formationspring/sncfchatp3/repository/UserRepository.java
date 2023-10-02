package com.formationspring.sncfchatp3.repository;

import com.formationspring.sncfchatp3.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final List<User> tableauDeListe= new ArrayList<>();
    private final AtomicLong atomicLong = new AtomicLong();
    public User saveUser(User user){
    user.setId(atomicLong.incrementAndGet());
        tableauDeListe.add(user);
        return user;

    }

    public List<User> findAllUsers() {
        return tableauDeListe;
    }

    public void deleteAllUsers(){
        tableauDeListe.clear();

    }

    public User findUserById(Long id){
       return tableauDeListe.stream()
               .filter(user ->user.getId()==id )
               .findFirst()
               .orElse(null);

    }

    public void deleteUserById(Long monId){
        tableauDeListe.removeIf(user -> user.getId()==monId);
    }

    public User updateUser(Long id, User user){
       User miseAjour = tableauDeListe.stream().filter(u -> u.getId()==id).findFirst().orElse(null);
       if (null != miseAjour ){
           miseAjour.setAge(user.getAge());
           miseAjour.setFirstname(user.getFirstname());
           miseAjour.setName(user.getName());
       }
       return miseAjour;

    }

    public List<User> chercheMineur (Boolean minored){
        return tableauDeListe.stream().filter(user -> user.isMinored()==minored).toList();

    }

}
