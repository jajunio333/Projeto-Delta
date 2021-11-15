package com.DELTA.dsalunos.service.arquivo;

import org.springframework.stereotype.Service;

@Service
public interface IGerenciadorArquivos {
	String criarArquivo(String base64);
	String recuperarArquivo( String nome);
	boolean deletarArquivo( String nome);
}
