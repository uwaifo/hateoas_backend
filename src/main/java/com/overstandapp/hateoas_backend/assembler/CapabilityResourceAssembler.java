package com.overstandapp.hateoas_backend.assembler;

import com.overstandapp.hateoas_backend.domain.Capability;
import com.overstandapp.hateoas_backend.resources.CapabilityController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CapabilityResourceAssembler implements RepresentationModelAssembler<Capability, EntityModel<Capability>> {

    @Override
    public EntityModel<Capability> toModel(Capability entity) {
        //return null;
        return new EntityModel<>(entity,
                linkTo(methodOn(CapabilityController.class).getCapability(entity.getId())).withRel("getThisCapacity"),
                linkTo(methodOn(CapabilityController.class).deleteCapability(entity.getId())).withRel("deleteThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"),
                new Link("http://localhost:8080/dashboard/"+entity.getId()).withRel("updateThisCapabilities")
                );
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