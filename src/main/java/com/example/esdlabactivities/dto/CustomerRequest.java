package com.example.esdlabactivities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CustomerRequest(

    //for First name
    @NotNull(message = "first name should be present")
    @NotBlank(message = "first name should be present")
    @NotEmpty(message = "first name should be present")
    @JsonProperty("first_name")
    String firstName,

    //For Last Name
    @JsonProperty("last_name")
    String lastName,

    //For Email
    @Email(message = "Enter valid Email Address")
    @NotBlank(message = "Email should be present")
    @NotEmpty(message = "Email should be present")
    @NotBlank(message = "Email should be present")
    @JsonProperty("email")
    String email,

    //For Password
    @NotBlank(message = "Password Should be Present")
    @NotEmpty(message = "Password Should be Present")
    @NotNull(message = "Password Should be Present")
    @Size(max = 12, min = 6, message = "Password should be between 6 to 12 characters")
    @JsonProperty("password")
    String password

) {
}
