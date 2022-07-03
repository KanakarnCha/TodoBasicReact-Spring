package com.example.TodoListBackendSpring.model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Data
public class TodoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String updatedAt;
}
