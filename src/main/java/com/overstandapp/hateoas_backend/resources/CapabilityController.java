package com.overstandapp.hateoas_backend.resources;


import com.overstandapp.hateoas_backend.assembler.CapabilityResourceAssembler;
import com.overstandapp.hateoas_backend.domain.Capability;
import com.overstandapp.hateoas_backend.services.CapabilityService;
import lombok.experimental.Delegate;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityController {

    private CapabilityService capabilityService;

    private CapabilityResourceAssembler assembler;


    public CapabilityController(CapabilityService capabilityService, CapabilityResourceAssembler assembler) {
        this.capabilityService = capabilityService;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Capability>> getAllCapabilities(){

        return  new CollectionModel<>(capabilityService.getAllCapabilities().stream()
            .map(capability -> assembler.toModel(capability)).collect(Collectors.toList()),
                new Link("http://localhost:8080/dashboard/").withRel("createCapabilities")


        );

        /*
        List capabilities = capabilityService.getAllCapabilities().stream()
                .map(capability -> new EntityModel(capability,
                        linkTo(methodOn(CapabilityController.class).getCapability(capability.getId())).withRel("getThisCapability"),
                        linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
                )).collect(Collectors.toList());

        return new CollectionModel<>(capabilities);
        */

    }


    @GetMapping("/{id}")
    public EntityModel<?> getCapability(@PathVariable Long id){
        //Capability capability = capabilityService.findCapabilityById(id);

        //return new EntityModel<>(capability, linkTo(methodOn(CapabilityController.class).getCapability(id)).withRel("getThisCapability"));
        return new EntityModel<>(assembler.toModel(capabilityService.findCapabilityById(id)));
    }

    @PostMapping
    public Object createCapability(@Valid @RequestBody Capability capability, BindingResult result) {
        if (result.hasErrors()) return capabilityService.errorMap(result);
        return new EntityModel<>(assembler.toModel(capabilityService.saveCapability(capability)));




    }

    @PutMapping("/{id}")
    public Object updateCapability(@PathVariable Long id, @Valid @RequestBody Capability capability, BindingResult result) {

        if (result.hasErrors()) return  capabilityService.errorMap(result);
        return new EntityModel<>(assembler.toModel(capabilityService.updateCapability(id,capability)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCapability(@PathVariable Long id) {
        capabilityService.deleteCapability(id);

        return new ResponseEntity<String>("Capability Deleted", HttpStatus.OK);
    }
}


/*
"In case you are using HATEOAS v1.0 and above (Spring boot >= 2.2.0), do note that the class names have changed.
Notably the below classes have been renamed:

ResourceSupport changed to RepresentationModel

Resource changed to EntityModel

Resources changed to CollectionModel

PagedResources changed to PagedModel

ResourceAssembler changed to RepresentationModelAssembler

More information available in the official documentation here.

When using Spring boot starter, the below dependency would suffice to include
 */