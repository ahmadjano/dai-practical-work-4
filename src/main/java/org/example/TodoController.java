package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final List<Todo> todos = new ArrayList<>();

    // Get all Todos
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(@RequestParam(required = false) Boolean completed, @RequestParam(required = false) String title, @RequestParam(required = false) Integer id) {
        Stream<Todo> stream = todos.stream();
        if (completed != null) {
            stream = stream.filter(todo -> todo.isCompleted() == completed);
        }
        if (title != null) {
            stream = stream.filter(todo -> todo.getTitle().equals(title));
        }
        if (id != null) {
            stream = stream.filter(todo -> todo.getId() == id);
        }
        List<Todo> filteredTodos = stream.collect(Collectors.toList());
        return ResponseEntity.ok(filteredTodos);
    }

    // Get a single Todo by ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Todo
    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody String title) {
        Todo newTodo = new Todo(title);
        todos.add(newTodo);
        return ResponseEntity.ok(newTodo);
    }

    // Update an existing Todo
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody Todo updatedTodo) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setCompleted(updatedTodo.isCompleted());
                    return ResponseEntity.ok(todo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Make a todo completed
    @PutMapping("/{id}/completed")
    public ResponseEntity<Todo> markTodoAsCompleted(@PathVariable int id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .map(todo -> {
                    todo.setCompleted();
                    return ResponseEntity.ok(todo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Todo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id) {
        boolean removed = todos.removeIf(todo -> todo.getId() == id);
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}