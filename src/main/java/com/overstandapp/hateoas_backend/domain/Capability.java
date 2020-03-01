package com.overstandapp.hateoas_backend.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Capability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Technology can not be blank")//disallows black or no value
    @NotNull(message =  "Technology Stack can not be null")// disallows if the field is not included
    private String techStack;
    private Integer numsOfDevelopers = 0;
    private Integer numsOfAvailableDeveloper = 0;

    public Capability(String techStack, Integer numsOfDevelopers, Integer numsOfAvailableDeveloper) {
        this.techStack = techStack;
        this.numsOfDevelopers = numsOfDevelopers;
        this.numsOfAvailableDeveloper = numsOfAvailableDeveloper;
    }
}
