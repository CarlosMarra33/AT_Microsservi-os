package br.At_Microsservicos.Aluno4.contorllers.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class AlunoDto {

    @JsonProperty
    private Long alunoId;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String matricula;
    @JsonProperty
    private List<NotaDTO> notas;
}
