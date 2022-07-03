package com.example.TodoListBackendSpring.dto;

import lombok.Data;

@Data
public class TodoDto {
    private Long id;
    private String title;
    private String Content;
    private String updatedAt;
}
