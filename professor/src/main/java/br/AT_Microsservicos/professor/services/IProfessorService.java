package br.AT_Microsservicos.professor.services;

import br.AT_Microsservicos.professor.Entities.Atividade;
import br.AT_Microsservicos.professor.controllers.dtos.AtividadeDto;
import br.AT_Microsservicos.professor.controllers.dtos.ProfessorDto;

import java.sql.SQLException;

public interface IProfessorService {
    void cadastrarProf(ProfessorDto professorDto) throws SQLException;

    void cadastrarAtividade(AtividadeDto atividadeDto)throws SQLException;
    void AtribuirAtividade(Long ativId, String matricula) throws SQLException;

    void corrigirTrabalho(Long atividadeId, float nota);

    void receberAtividadePronta(Long atividadeId);

}
