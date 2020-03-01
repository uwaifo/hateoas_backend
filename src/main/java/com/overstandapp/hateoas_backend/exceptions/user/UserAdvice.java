package com.overstandapp.hateoas_backend.exceptions.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
  import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class UserAdvice {
    @ResponseBody
    @ExceptionHandler(UserException.class)
    public  final ResponseEntity<UserNotFoundResponse> userNotFoundResponseResponseEntity(UserException ux) {
        UserNotFoundResponse response = new UserNotFoundResponse(ux.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
