package br.AT_Microsservicos.professor.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atividadeId;
    private String disciplina;
    private boolean feito;
    private boolean corrigido;
    private Long alunoId;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "professor_id")
    private Professor professor;
    private float nota;
}
