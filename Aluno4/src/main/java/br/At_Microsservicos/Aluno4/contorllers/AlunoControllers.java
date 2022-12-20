package br.At_Microsservicos.Aluno4.contorllers;

import br.At_Microsservicos.Aluno4.contorllers.DTOs.AlunoDto;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.AtividadeDto;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.NotaDTO;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.RelatorioDto;
import br.At_Microsservicos.Aluno4.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/aluno")
public class AlunoControllers {

    @Autowired
    private IAlunoService alunoService;

    @Async
    @GetMapping("/todos")
    public ResponseEntity<?> todos(){
        return ResponseEntity.ok(alunoService.getAllAluno());
    }

    @Async
    @GetMapping("receberAtividade")
    public ResponseEntity<?> getAluboByMatricula(@RequestParam String matricula, @RequestParam(required = false) Long atividadeId){
        if (atividadeId == null){
            return ResponseEntity.ok(alunoService.getByMatricula(matricula, atividadeId));
        }else
            return ResponseEntity.ok(alunoService.getByMatricula(matricula, atividadeId));

    }

    @Async
    @PostMapping("/criarAluno")
    public ResponseEntity<?> registerAluno(@RequestBody AlunoDto payload){
        try {
            alunoService.registerAluno(payload);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    @PostMapping("/fazerAtividade")
    public ResponseEntity<?> fazerAtividade(@RequestParam String id){
        alunoService.fazerAtividade(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
