package com.example.demo.model;

//programa que organiza a persistencia de dados pra BD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Lombok poupa código na hora de criar getters e setters e construtores.
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity //informa que essa classe será persistida no BD
public class Product {
    @Id //indica que esse atributo é uma PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //número sequencial (autoincrement)
    private int cod;
    private String name;
    private double value;    
}
