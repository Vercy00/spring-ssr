package org.example.springssr.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record UserDto(
        int id,
        String username
) implements Serializable {
}
