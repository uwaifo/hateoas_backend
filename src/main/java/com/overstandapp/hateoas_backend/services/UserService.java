package com.overstandapp.hateoas_backend.services;

 import com.overstandapp.hateoas_backend.domain.User;
 import com.overstandapp.hateoas_backend.exceptions.user.UserException;
 import com.overstandapp.hateoas_backend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(()-> new UserException("User with ID: " + id + " Not found"));

    };

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(
                userIndex -> {
                    userIndex.setFirstName(user.getFirstName());
                    userIndex.setLastName(user.getLastName());
                    userIndex.setContactEmailAddress(user.getContactEmailAddress());
                    userIndex.setContactPhoneNumber(user.getContactPhoneNumber());

                    return userRepository.save(userIndex);
                }
        ).orElseGet(()-> {
            return userRepository.save(user);
        });
    }

    public void deleteUser(Long id) {
        userRepository.delete(
                userRepository.findById(id)
                .orElseThrow(() -> new UserException("User with ID: " + id + "Not found"))
        );
    }

    public ResponseEntity<?> errorMap(BindingResult result) {
        var errorMap = new HashMap<>();
        for(FieldError error: result.getFieldErrors()) {
            errorMap.put(error.getField(),error.getDefaultMessage());
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}



