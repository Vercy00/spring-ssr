package org.example.springssr.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record PostDto(
         int id,
         String title,
         String content,
         String imageUrl,
         UserDto user
) implements Serializable {
}
