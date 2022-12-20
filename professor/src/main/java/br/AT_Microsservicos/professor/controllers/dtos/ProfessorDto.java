package br.AT_Microsservicos.professor.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDto {
    @JsonProperty
    private String nome;
    @JsonProperty
    private String disciplina;
}
