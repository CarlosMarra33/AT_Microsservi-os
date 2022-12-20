package br.At_Microsservicos.Aluno4.contorllers.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class NotaDTO {

    @JsonProperty
    private Float valor;
    @JsonProperty
    private Long AtividadeId;
    @JsonProperty
    private String matricula;
}
