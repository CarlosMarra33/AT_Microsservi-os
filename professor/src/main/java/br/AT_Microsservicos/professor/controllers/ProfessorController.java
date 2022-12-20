package br.AT_Microsservicos.professor.controllers;

import br.AT_Microsservicos.professor.Entities.Atividade;
import br.AT_Microsservicos.professor.controllers.dtos.AtividadeDto;
import br.AT_Microsservicos.professor.controllers.dtos.ProfessorDto;
import br.AT_Microsservicos.professor.services.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("prof")
public class ProfessorController {

    @Autowired
    protected IProfessorService professorService;

    @Async
    @PostMapping("cadastrar")
    public ResponseEntity<?> cadastrarProf(@RequestBody ProfessorDto payload){

        try {
            professorService.cadastrarProf(payload);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Async
    @PostMapping("CriarAtividade")
    public   ResponseEntity<?> CriarAtividade(@RequestBody AtividadeDto atividadeDto){
        try {
            professorService.cadastrarAtividade(atividadeDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    @PostMapping("AtribuirAtividade")
    public ResponseEntity<?> AtribuirAtividade(@RequestBody AtividadeDto atividadeDto){
        try {
            professorService.AtribuirAtividade(atividadeDto.getAtividadeId(), atividadeDto.getMatricula());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("corrigirTrabalho")
    public ResponseEntity<?> corrigirTrabalho(@RequestBody AtividadeDto atividadeDto){
        professorService.corrigirTrabalho(atividadeDto.getAtividadeId(),atividadeDto.getNota());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("receberAtividadePronta")
    public ResponseEntity<?> receberAtividadePronta(@RequestBody AtividadeDto atividadeDto){
        professorService.receberAtividadePronta(atividadeDto.getAtividadeId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
