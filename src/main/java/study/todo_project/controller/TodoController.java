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

    //get - 전체 조회
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoList;
    }

    @PostMapping
    public Todo createtodo(
            @RequestBody Todo todo
    ) {
        todo.setId(nextID);
        nextID++;
        todoList.add(todo);
        return todo;
    }
}
