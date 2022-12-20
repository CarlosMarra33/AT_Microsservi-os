package br.At_Microsservicos.Aluno4.service.serviceImpl;

import br.At_Microsservicos.Aluno4.contorllers.DTOs.AlunoDto;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.AtividadeDto;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.NotaDTO;
import br.At_Microsservicos.Aluno4.contorllers.DTOs.RelatorioDto;
import br.At_Microsservicos.Aluno4.Entities.Aluno;
import br.At_Microsservicos.Aluno4.repository.IAlunoRepository;
import br.At_Microsservicos.Aluno4.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private IAlunoRepository alunoRepository;

//    @Autowired

    @Override
    public void registerAluno(AlunoDto alunoDto) throws SQLDataException, SQLException {
        Aluno aluno = new Aluno(alunoDto.getNome(), alunoDto.getMatricula());
        alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> getAllAluno() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    @Transactional
    @Override
    public RelatorioDto getRelatorio(String matricula) throws SQLDataException {
        Aluno aluno = alunoRepository.findAlunoByMatricula(matricula);
        RelatorioDto relatorioDto = new RelatorioDto();
        return relatorioDto;
    }

    @Override
    public AlunoDto getByMatricula(String mat, Long atividadeId) {

            Aluno aluno = alunoRepository.findAlunoByMatricula(mat);
            AlunoDto response = new AlunoDto();
            response.setMatricula(aluno.getMatricula());
            response.setAlunoId(aluno.getAlunoId());
            response.setNome(aluno.getNome());
//        response.setNota(aluno.getNotas());
            return response;
    }

    @Override
    public void fazerAtividade(Long ativId) {
        AtividadeDto atividadeDto = new AtividadeDto();
        atividadeDto.setAtividadeId(ativId);
        String url = "http://localhost:8080/prof/receberAtividadePronta";

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(url, atividadeDto, String.class);
    }
}