package com.DELTA.dsalunos.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DELTA.dsalunos.dto.AlunoDTO;
import com.DELTA.dsalunos.entities.Aluno;
import com.DELTA.dsalunos.exception.AlunoInexistenteException;
import com.DELTA.dsalunos.exception.DeletarAlunoException;
import com.DELTA.dsalunos.exception.SalvarDadoAlunoException;
import com.DELTA.dsalunos.repositories.AlunoRepository;
import com.DELTA.dsalunos.utils.GerenciadorArquivos;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	
	public List<AlunoDTO> findAll(){
		List<Aluno> result = repository.findAll();
		return result.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
	}
	public AlunoDTO getAlunoById (long id) throws AlunoInexistenteException {
		Aluno aluno = repository.getById(id);
		if (aluno != null) { 
			String base64 = GerenciadorArquivos.recuperarArquivo(aluno.getFoto());
			return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEndereço(), base64);
		}
		else throw new AlunoInexistenteException(id);
	}
	public void createAluno (AlunoDTO alunoDTO) {
		String idFoto = GerenciadorArquivos.criarArquivo(alunoDTO.getFoto());
		Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getEndereço(), idFoto);
		repository.save(aluno);
	}
	
	public void updateAluno (AlunoDTO alunoDTO) throws AlunoInexistenteException, SalvarDadoAlunoException {
		Aluno aluno = repository.getById(alunoDTO.getId());
		if (aluno != null) { 
			boolean arquivoAtualizou = GerenciadorArquivos.atualizarArquivo(aluno.getFoto(), alunoDTO.getFoto());
			if (!arquivoAtualizou) {
				 throw new SalvarDadoAlunoException(alunoDTO.getId());
			}
		}
		else throw new AlunoInexistenteException(alunoDTO.getId());
	}	 
	
	public void deleteById (long id) throws AlunoInexistenteException, DeletarAlunoException {
		Aluno aluno = repository.getById(id);
		if (aluno != null) { 
			boolean arquivoDeletado = GerenciadorArquivos.deletarArquivo(aluno.getFoto());
			if (arquivoDeletado) {
				repository.deleteById(id);
			}
			else throw new DeletarAlunoException();
		}
		else throw new AlunoInexistenteException(id);
	}
}
