package com.example.esdlabactivities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotNull(message = "Name Should be present")
        @NotBlank(message = "Name Should be present")
        @JsonProperty("name")
        String name,

        @Size(max = 255, message = "Description should not be greater than 255 character")
        @JsonProperty("description")
        String description,

        @NotNull(message = "Price should be mentioned")
        @JsonProperty("price")
        double price

) {
}
