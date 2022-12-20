package br.At_Microsservicos.Aluno4.contorllers.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class RelatorioDto {

    private String nomeAluno;
     List<NotaDTO> notas;
}
