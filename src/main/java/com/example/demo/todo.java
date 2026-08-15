package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class todo {
    @Id
    @GeneratedValue
    long todo_id;
    String todo_Name;
    String todo_Description;
    Boolean status;
}
