package com.overstandapp.hateoas_backend.exceptions.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundResponse {
    public  String userNotFound;
    public UserNotFoundResponse(String userNotFound) {
        this.userNotFound = userNotFound;

    }
}
