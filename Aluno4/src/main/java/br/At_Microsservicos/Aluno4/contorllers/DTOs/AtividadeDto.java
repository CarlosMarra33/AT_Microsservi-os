package br.At_Microsservicos.Aluno4.contorllers.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtividadeDto {
    @JsonProperty
    private Long atividadeId;
    @JsonProperty
    private String disciplina;
    @JsonProperty
    private String matricula;
    @JsonProperty
    private float nota;
}
