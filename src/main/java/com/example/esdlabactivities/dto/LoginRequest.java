package com.example.esdlabactivities.dto;

import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginRequest(
        @Email(message = "Email Should be valid")
        @NotNull(message = "Email should be given")
        @NotEmpty(message = "Email Should be given")
        @NotBlank(message = "Email should be given")
        @JsonProperty("email")
        String email,

        @NotBlank(message = "Password should be given")
        @NotEmpty(message = "Password should be given")
        @NotNull(message = "Password should be given")
        @Size(max = 12, min = 6, message = "Password should be between 6 to 12 characters")
        @JsonProperty("password")
        String password
) {}
