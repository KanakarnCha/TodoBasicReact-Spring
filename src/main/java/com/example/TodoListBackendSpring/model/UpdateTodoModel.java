package com.example.TodoListBackendSpring.model;

import lombok.Data;

@Data
public class UpdateTodoModel {
    private String title;
    private String content;
}
