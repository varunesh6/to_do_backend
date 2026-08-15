package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class todoService {

    @Autowired
    private todoRepo todoRepo;

    public todo add(todo todo) {
        return todoRepo.save(todo);
    }

    public todo get(Long id) {
        return todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public List<todo> getAll() {
        return todoRepo.findAll();
    }

    public Page<todo> getAll(Pageable pageable) {
        return todoRepo.findAll(pageable);
    }

    public todo update(Long id, todo todo) {

        todo up = get(id);

        up.setTodo_Name(todo.getTodo_Name());
        up.setStatus(todo.getStatus());
        up.setTodo_Description(todo.getTodo_Description());
        return todoRepo.save(up);
    }

    public void delete(Long id) {
        todoRepo.deleteById(id);
    }
}