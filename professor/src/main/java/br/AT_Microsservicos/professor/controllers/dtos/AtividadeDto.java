package br.AT_Microsservicos.professor.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtividadeDto {
    @JsonProperty
    private Long atividadeId;
    @JsonProperty
    private Long professorId;
    @JsonProperty
    private Long alunoId;
    @JsonProperty
    private String disciplina;
    @JsonProperty
    private String matricula;
    @JsonProperty
    private float nota;
}
