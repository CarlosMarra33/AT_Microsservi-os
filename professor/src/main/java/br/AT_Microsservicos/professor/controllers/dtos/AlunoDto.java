package br.AT_Microsservicos.professor.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AlunoDto {

    @JsonProperty
    private Long alunoId;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String matricula;

}
