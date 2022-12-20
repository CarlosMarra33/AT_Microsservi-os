package br.AT_Microsservicos.professor.repositories;

import br.AT_Microsservicos.professor.Entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {
}
