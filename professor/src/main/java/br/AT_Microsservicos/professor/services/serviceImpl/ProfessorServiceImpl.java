package br.AT_Microsservicos.professor.services.serviceImpl;

import br.AT_Microsservicos.professor.Entities.Atividade;
import br.AT_Microsservicos.professor.Entities.Professor;
import br.AT_Microsservicos.professor.controllers.dtos.AlunoDto;
import br.AT_Microsservicos.professor.controllers.dtos.AtividadeDto;
import br.AT_Microsservicos.professor.controllers.dtos.NotaRequest;
import br.AT_Microsservicos.professor.controllers.dtos.ProfessorDto;
import br.AT_Microsservicos.professor.repositories.IAtividadeRepository;
import br.AT_Microsservicos.professor.repositories.IProfessorRepository;
import br.AT_Microsservicos.professor.services.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.net.http.HttpRequest;
import java.sql.SQLData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class ProfessorServiceImpl implements IProfessorService {

    @Autowired
    protected IProfessorRepository professorRepository;
    @Autowired
    protected IAtividadeRepository atividadeRepository;

    @Override
    public void cadastrarProf(ProfessorDto professorDto) throws SQLException {
        Professor professor = new Professor();
        professor.setNomeProfessor(professorDto.getNome());
        professor.setDisciplina(professorDto.getDisciplina());
        professorRepository.save(professor);
    }
    @Transactional
    @Override
    public void cadastrarAtividade(AtividadeDto atividadeDto) throws SQLException {
        Optional<Professor> professorBd = professorRepository.findById(atividadeDto.getProfessorId());
        Professor professor = new Professor();
        Atividade atividade = new Atividade();

        if (professorBd.isPresent()){
            professor = professorBd.get();
            atividade.setProfessor(professor);

            atividade.setDisciplina(professor.getDisciplina());
            professor.getAtividades().add(atividade);
            professorRepository.save(professor);
        }

    }
    @Transactional
    @Override
    public void AtribuirAtividade(Long ativId, String matricula) throws SQLException {
        Optional<Atividade> atividadedb = atividadeRepository.findById(ativId);
        Atividade atividade = new Atividade();
        if (atividadedb.isEmpty()){
            throw new SQLException();
        }

        atividade = atividadedb.get();
        atividade.setAlunoId(BuscarAlunoId(matricula, atividade.getAtividadeId()).getAlunoId());
        atividadeRepository.save(atividade);
    }

    @Override
    public void corrigirTrabalho(Long atividadeId, float nota) {
        Optional<Atividade> atividadeBd = atividadeRepository.findById(atividadeId);
        Atividade atividade = atividadeBd.get();

        atividade.setCorrigido(true);
        atividade.setNota(nota);
        atividadeRepository.save(atividade);
    }

    @Override
    public void receberAtividadePronta(Long atividadeId) {
        Optional<Atividade> atividadeBd = atividadeRepository.findById(atividadeId);
        if (atividadeBd.isPresent()){
            Atividade atividade = atividadeBd.get();
            atividade.setFeito(true);
            atividadeRepository.save(atividade);
        }
    }

    private AlunoDto BuscarAlunoId(String matricula, Long atividadeId){
        AlunoDto result = null;

        String url = "http://localhost:8081/aluno/receberAtividade?matricula="+matricula+"&atividadeId="+atividadeId;
        RestTemplate restTemplate = new RestTemplate();

         result = restTemplate.getForEntity(url, AlunoDto.class).getBody();
        return result;
    }

    private void enviarNota(float nota, Long alunoId){
        NotaRequest request = new NotaRequest();
        request.setNota(nota);
        request.setAlunoId(alunoId.toString());
        String url = "http://localhost:8081/aluno/receberNota";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(url,request, String.class);
    }
}
