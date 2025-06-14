package org.fukagawa.service;

import jakarta.annotation.Resource;
import org.fukagawa.dao.TodoRepository;
import org.fukagawa.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Resource
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo updatedTodo) {
        //先查找是否有这个待办事项
        var todo = todoRepository.findById(id);
        if (todo.isEmpty()) {
            //没有的话新建
            return this.createTodo(updatedTodo);
        } else {
            //有的话更改
            todo.get().updateByOther(updatedTodo);
            return todoRepository.save(todo.get());
        }
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
