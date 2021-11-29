package com.learn.banking.services;

import com.learn.banking.models.User;
import com.learn.banking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
       return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User Not Found"
                ));
    }

    public User findByidBarang(String idBarang){
        return userRepository.findByidBarang(idBarang);
    }

    public User Create(User user){
        if (user.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,String.format("User %s already exist", user.getId()));
        }

        return userRepository.save(user);
    }

    public User Update(Long id, User user){
        getById(id);
        user.setId(id);

        return userRepository.save(user);
    }

    public User Delete(Long id, User user){
        user = getById(id);
        userRepository.deleteById(user.getId());
        return user;
    }
}
