package br.At_Microsservicos.Aluno4.repository;

import br.At_Microsservicos.Aluno4.Entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findAlunoByMatricula(String matricula);


}
