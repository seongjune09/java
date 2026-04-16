package study.todo_project.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import study.todo_project.domain.Todo;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")

public class TodoController {
    private List<Todo> todoList = new ArrayList<>();
    private long nextID = 1L;


    @GetMapping
    public List<Todo> getAllTodos() {
        return todoList;
    }

    //Get localhost:8080/todos/2
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    //get 조회
    @PostMapping
    public Todo createtodo(
            @RequestBody Todo todo
    ) {
        todo.setId(nextID);
        nextID++;
        todoList.add(todo);
        return todo;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(
            @PathVariable Long id,
            @RequestBody Todo updateTodo) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setTitle(updateTodo.getTitle());
                todo.setCompleted(updateTodo.isCompleted());

                return todo;
            }
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public Todo deleteTodo(
            @PathVariable Long id,
            @RequestBody Todo deleteTodo) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todoList.remove(todo);
                    return todo;
            }
        }
        return null;
    }
    @PatchMapping("/{id}")
    public Todo patchTodo(@PathVariable Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setCompleted(!todo.isCompleted());
                return todo;
            }
        }
        return null;
    }

}
