package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class todoController {

    @Autowired
    private todoService todoService;

    @PostMapping
    public ResponseEntity<todo> add(@RequestBody todo todo) {
        todo savedTodo = todoService.add(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<todo>> getAll() {
        return new ResponseEntity<>(
                todoService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<todo> get(@PathVariable Long id) {
        return new ResponseEntity<>(
                todoService.get(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<todo> update(
            @PathVariable Long id,
            @RequestBody todo todo) {

        return new ResponseEntity<>(
                todoService.update(id, todo),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        todoService.delete(id);

        return new ResponseEntity<>(
                "Todo deleted successfully",
                HttpStatus.OK
        );
    }
}