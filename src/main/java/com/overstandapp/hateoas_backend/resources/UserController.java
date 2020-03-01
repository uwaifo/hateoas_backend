package com.overstandapp.hateoas_backend.resources;


import com.overstandapp.hateoas_backend.assembler.UserResourceAssembler;
import com.overstandapp.hateoas_backend.domain.User;
import com.overstandapp.hateoas_backend.services.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//import java.util.List;
import java.util.stream.Collectors;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/userboard")
@CrossOrigin
public class UserController {

    public UserService userService;

    public UserResourceAssembler assembler;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public CollectionModel<EntityModel<User>> getAllUsers() {

        return new CollectionModel<>(userService.getAllUser().stream()
        .map(user -> assembler.toModel(user)).collect(Collectors.toList()),
                new Link("http://localhost:8080/userboard/").withRel("createAUser")
        );

        /*
        List users = (List) userService.getAllUser().stream()
        .map(user -> new EntityModel(user,
                linkTo(methodOn(UserController.class).getAUser(user.getId())).withRel("getThisUser"),
                linkTo(methodOn(UserController.class).getAllUsers()).withRel("getAllUser")
                )).collect(Collectors.toList());

        return  new CollectionModel<>(users);
        */
        //List<CollectionModel<User>> users = use
    }

    @GetMapping("/{id}")
    public EntityModel<?> getAUser(@PathVariable Long id) {
        return new EntityModel<>(assembler.toModel(userService.findUserById(id)));

        /*User user = userService.findUserById(id);
        return new EntityModel<>(user,
                linkTo(methodOn(UserController.class).getAUser(id)).withRel("getThisUser")
        );*/
    }

    @PostMapping
    public Object createUser(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()) return userService.errorMap(result);

        return new EntityModel<>(assembler.toModel(userService.saveUser(user)));

    }

    @PutMapping("/{id}")
    public Object updateUser(@PathVariable Long id, @Valid @RequestBody User user, BindingResult result) {
        if(result.hasErrors()) return userService.errorMap(result);

        return new EntityModel<>(assembler.toModel(userService.updateUser(id, user)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }


}
