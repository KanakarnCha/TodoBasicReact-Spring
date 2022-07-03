package com.example.TodoListBackendSpring.mapper;
import com.example.TodoListBackendSpring.dto.TodoDto;
import com.example.TodoListBackendSpring.model.TodoModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoModelMapper {
    List<TodoDto> modelToDto(List<TodoModel> todoModel);
}
