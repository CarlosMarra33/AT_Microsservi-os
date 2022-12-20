package br.At_Microsservicos.Aluno4.service;

import br.At_Microsservicos.Aluno4.contorllers.DTOs.AlunoDto;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.AtividadeDto;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.NotaDTO;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.RelatorioDto;
import br.At_Microsservicos.Aluno4.Entities.Aluno;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public interface IAlunoService {
    void registerAluno(AlunoDto alunoDto) throws SQLDataException, SQLException;
    List<Aluno> getAllAluno();

    RelatorioDto getRelatorio(String matricula) throws SQLDataException;

    AlunoDto getByMatricula(String mat, Long atividadeId);

    void fazerAtividade(Long ativId);
}
