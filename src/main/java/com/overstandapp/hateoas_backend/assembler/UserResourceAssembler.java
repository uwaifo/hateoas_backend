package com.overstandapp.hateoas_backend.assembler;


import com.overstandapp.hateoas_backend.domain.User;
import com.overstandapp.hateoas_backend.resources.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserResourceAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User entity) {
        //return null;
        return new EntityModel<>(entity,
                linkTo(methodOn(UserController.class).getAUser(entity.getId())).withRel("getThisUser"),
                linkTo(methodOn(UserController.class).getAllUsers()).withRel("getAllUsers"),
                linkTo(methodOn(UserController.class).deleteUser(entity.getId())).withRel("deleteThisUser"),
                new Link("http://localhost:8080/userboard/" + entity.getId()).withRel("updateThisUser")
                );
    }
}
