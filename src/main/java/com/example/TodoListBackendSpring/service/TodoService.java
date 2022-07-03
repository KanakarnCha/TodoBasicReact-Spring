package com.example.TodoListBackendSpring.service;


import com.example.TodoListBackendSpring.model.TodoModel;
import com.example.TodoListBackendSpring.model.UpdateTodoModel;
import com.example.TodoListBackendSpring.exception.BaseException;
import com.example.TodoListBackendSpring.exception.TodoException;
import com.example.TodoListBackendSpring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public TodoModel addTodo(TodoModel todoModel) throws BaseException {
        if (Objects.equals(todoModel.getTitle(), "")){
            throw TodoException.titleIsNull();
        }
        if (Objects.equals(todoModel.getContent(), "")){
            throw TodoException.contentIsNull();
        }
        Date date = new Date();
        LocalDateTime datetime1 = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = datetime1.format(format);
        todoModel.setUpdatedAt(formatDateTime);
        return todoRepository.save(todoModel);
    }

    public String deleteTodo(int id) throws BaseException {
        if (!todoRepository.existsById((long) id)){
            throw TodoException.idIsNull();
        }
        Optional<TodoModel> todoModel = todoRepository.findById((long) id);
        todoRepository.delete(todoModel.get());
        return "Delete Success";
    }
    public String updateTodo(Long id , UpdateTodoModel updateTodoModel) throws BaseException {
        Optional<TodoModel> todoModelOp = todoRepository.findById(id);
        if(!todoModelOp.isPresent()){
            throw TodoException.idIsNull();
        }
        TodoModel todoModel = todoModelOp.get();
        todoModel.setTitle(updateTodoModel.getTitle());
        todoModel.setContent(updateTodoModel.getContent());
        todoRepository.save(todoModel);
        return "Update Success";
    }
}
