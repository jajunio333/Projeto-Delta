package com.DELTA.dsalunos.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.DELTA.dsalunos.dto.AlunoDTO;
import com.DELTA.dsalunos.entities.Aluno;
import com.DELTA.dsalunos.exception.AlunoInexistenteException;
import com.DELTA.dsalunos.exception.DeletarAlunoException;
import com.DELTA.dsalunos.exception.SalvarDadoAlunoException;
import com.DELTA.dsalunos.repositories.AlunoRepository;
import com.DELTA.dsalunos.service.arquivo.GerenciadorArquivos;
import com.DELTA.dsalunos.service.arquivo.IGerenciadorArquivos;

@Service
public class AlunoService {
	
	private AlunoRepository alunoRepository;
	
	private IGerenciadorArquivos gerenciadorArquivos;
	
	public AlunoService(AlunoRepository alunoRepository, ServletContext context, Environment env) {
		this.alunoRepository = alunoRepository;
		gerenciadorArquivos = new GerenciadorArquivos(context, env); //Inicializado manualmente. 
	}
	
	
	public List<AlunoDTO> findAll(){
		List<Aluno> result = alunoRepository.findAll();
		return result.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
	}
	public AlunoDTO getAlunoById (long id) throws AlunoInexistenteException {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		if (aluno != null) { 
			String base64 = gerenciadorArquivos.recuperarArquivo(aluno.getFoto());
			return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getendereco(), base64);
		}
		else throw new AlunoInexistenteException(id);
	}
	public void createAluno (AlunoDTO alunoDTO) throws SalvarDadoAlunoException {
		String idFoto = gerenciadorArquivos.criarArquivo(alunoDTO.getFoto());
		if (!idFoto.isEmpty()) {
			Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getendereco(), idFoto);
			alunoRepository.save(aluno);
		}
		else throw new SalvarDadoAlunoException(alunoDTO.getId());
	}
	
	public void updateAluno (AlunoDTO alunoDTO) throws AlunoInexistenteException, SalvarDadoAlunoException {
		Aluno aluno = alunoRepository.getById(alunoDTO.getId());
		if (aluno != null) {
			aluno.setNome(alunoDTO.getNome());
			aluno.setendereco(alunoDTO.getendereco());
			alunoRepository.save(aluno);
		}
		else throw new AlunoInexistenteException(alunoDTO.getId());
	}
	
	public void deleteById (long id) throws AlunoInexistenteException, DeletarAlunoException {
		Aluno aluno = alunoRepository.getById(id);
		if (aluno != null) { 
			boolean arquivoDeletado = gerenciadorArquivos.deletarArquivo(aluno.getFoto());
			if (arquivoDeletado) {
				alunoRepository.deleteById(id);
			}
			else throw new DeletarAlunoException();
		}
		else throw new AlunoInexistenteException(id);
	}
}
