package com.overstandapp.hateoas_backend.services;


import com.overstandapp.hateoas_backend.domain.Capability;
import com.overstandapp.hateoas_backend.exceptions.CapabilityException;
import com.overstandapp.hateoas_backend.repositories.CapabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
//import java.util.Map;

@Service
public class CapabilityService {

    private CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getAllCapabilities() {
        return capabilityRepository.findAll();
    }

    public Capability findCapabilityById(Long id) {
        return capabilityRepository.findById(id).
                orElseThrow(()-> new CapabilityException("Capability with ID: " + id + " Not found"));
    };

    public Capability saveCapability(Capability capability) {
        return capabilityRepository.save(capability);
    }

    public ResponseEntity<?> errorMap(BindingResult result) {
        var errorMap = new HashMap<>();
        for(FieldError error: result.getFieldErrors()) {
            errorMap.put(error.getField(),error.getDefaultMessage());
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    public Capability updateCapability(long id, Capability capability) {
        return capabilityRepository.findById(id).map(
                cap -> {
                    cap.setTechStack(capability.getTechStack());
                    cap.setNumsOfDevelopers(capability.getNumsOfDevelopers());
                    cap.setNumsOfAvailableDeveloper(capability.getNumsOfAvailableDeveloper());

                    return capabilityRepository.save(cap);
                }
        ).orElseGet(()-> {
            return capabilityRepository.save(capability);
        });
    }

    public void deleteCapability(Long id) {
        capabilityRepository.delete(
            capabilityRepository.findById(id)
                .orElseThrow(() -> new CapabilityException("Capability with ID: " + id + "Not found")
                ));
    }
}
