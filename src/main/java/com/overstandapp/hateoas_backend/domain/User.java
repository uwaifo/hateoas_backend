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
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First Name can not be blank")
    @NotNull(message = "First Name can not be Null")
    private String firstName;

    @NotBlank(message = "Last Name can not be blank")
    @NotNull(message = "Last Name can not be Null")
    private String lastName ;
    private String contactPhoneNumber = "No Number";
    private String contactEmailAddress = "No Email";

    public User(String firstName, String lastName, String contactPhoneNumber, String contactEmailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactEmailAddress = contactEmailAddress;
    }
}
