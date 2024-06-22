package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

@RestController
public class TodoController {
    @Autowired
    public TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public ArrayList<Todo> getAllTodos() {
        return todoJpaService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoJpaService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoJpaService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoJpaService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        todoJpaService.deleteTodo(id);
    }
}
