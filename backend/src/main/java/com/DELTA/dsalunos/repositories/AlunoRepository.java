package com.DELTA.dsalunos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DELTA.dsalunos.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Long>{

}
