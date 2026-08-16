package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class todo{
    @Id
    @GeneratedValue
    long todo_id;
    @NotBlank(message = "Input is Empty")
    @NonNull
    String todo_Name;
    @Size(min = 50)
    String todo_Description;
    Boolean status;
}
