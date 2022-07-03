package com.example.TodoListBackendSpring.business;

import com.example.TodoListBackendSpring.exception.BaseException;
import com.example.TodoListBackendSpring.model.TodoModel;
import com.example.TodoListBackendSpring.model.UpdateTodoModel;
import com.example.TodoListBackendSpring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoBusiness {
    @Autowired
    TodoService todoService;
    public TodoModel createTodoList(TodoModel todoModel) throws BaseException {
        return todoService.addTodo(todoModel);
    }
    public String updateTodoList(Long id, UpdateTodoModel updateTodoModel) throws BaseException {
        return todoService.updateTodo(id,updateTodoModel);
    }
    public String deleteTodoList(int id) throws BaseException {
        return todoService.deleteTodo(id);
    }

}
