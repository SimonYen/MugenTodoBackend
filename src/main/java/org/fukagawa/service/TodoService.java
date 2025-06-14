package org.fukagawa.service;

import org.fukagawa.domain.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();

    Todo createTodo(Todo todo);

    Todo updateTodo(Long id, Todo updatedTodo);

    void deleteTodo(Long id);
}
