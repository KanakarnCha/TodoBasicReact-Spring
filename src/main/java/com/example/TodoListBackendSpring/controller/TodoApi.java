package com.example.TodoListBackendSpring.controller;

import com.example.TodoListBackendSpring.dto.TodoDto;
import com.example.TodoListBackendSpring.exception.BaseException;
import com.example.TodoListBackendSpring.business.TodoBusiness;


import com.example.TodoListBackendSpring.mapper.TodoModelMapper;
import com.example.TodoListBackendSpring.model.TodoModel;
import com.example.TodoListBackendSpring.model.UpdateTodoModel;
import com.example.TodoListBackendSpring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/todo")
public class TodoApi {
    @Autowired
    TodoBusiness todoBusiness;
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoModelMapper todoModelMapper;
    @GetMapping("/data")
    public ResponseEntity<List<TodoDto>> addTodolist() {
        return new ResponseEntity<>(todoModelMapper.modelToDto(todoRepository.findAll()), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TodoModel> addTodolist(@RequestBody TodoModel todoModel) throws BaseException {
        return new ResponseEntity<>(todoBusiness.createTodoList(todoModel), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTodoList(@PathVariable(name = "id") int id, @RequestBody UpdateTodoModel updateTodoModel) throws BaseException {
        return new ResponseEntity<>(todoBusiness.updateTodoList((long) id,updateTodoModel),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTodoList(@RequestParam(name = "id") int id) throws BaseException {
        return new ResponseEntity<>(todoBusiness.deleteTodoList(id), HttpStatus.OK);
    }
}