package com.DELTA.dsalunos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DeletarAlunoException extends AlunoException{
	private static final long serialVersionUID = 1L;

	public DeletarAlunoException() {
        super("ocorreu um erro ao deletar o aluno");
    }
}

