package br.At_Microsservicos.Aluno4.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alunoId;
    private String nome;
    @Column(unique = true)
    private String matricula;


    public Aluno() {
    }

    public Aluno( String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }




}

