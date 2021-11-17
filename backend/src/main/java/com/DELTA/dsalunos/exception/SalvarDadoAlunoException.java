package com.DELTA.dsalunos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SalvarDadoAlunoException extends AlunoException{
	private static final long serialVersionUID = 1L;

	public SalvarDadoAlunoException(Long id) {
        super("aluno com id: " + id + " não atualizou.");
    }
}
