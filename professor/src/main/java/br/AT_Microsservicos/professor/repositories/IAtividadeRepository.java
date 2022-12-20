package br.AT_Microsservicos.professor.repositories;

import br.AT_Microsservicos.professor.Entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAtividadeRepository extends JpaRepository<Atividade, Long> {
}
