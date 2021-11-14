package com.DELTA.dsalunos.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoInexistenteException extends Exception{
	private static final long serialVersionUID = 1L;

	public AlunoInexistenteException(Long id) {
        super("aluno com id: " + id + " não encontrado.");
    }
}
