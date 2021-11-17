package com.DELTA.dsalunos.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.DELTA.dsalunos.dto.AlunoDTO;
import com.DELTA.dsalunos.exception.AlunoException;
import com.DELTA.dsalunos.exception.AlunoInexistenteException;
import com.DELTA.dsalunos.exception.DeletarAlunoException;
import com.DELTA.dsalunos.exception.SalvarDadoAlunoException;
import com.DELTA.dsalunos.exception.model.ErrorModel;
import com.DELTA.dsalunos.service.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	private AlunoService service;
	
//	@ExceptionHandler(AlunoException.class)
//	public ModelAndView handleException(HttpServletRequest req, Exception ex) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("body", new ErrorModel(ex.getMessage()));
//		return mav;
//	}não finalizado
	
	@GetMapping("/alunos")
	public ResponseEntity<List<AlunoDTO>> findAll(){
		List<AlunoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/alunos/{id}")
	public AlunoDTO getAlunoById(@PathVariable long id) throws AlunoInexistenteException{
		AlunoDTO alunoDTO = service.getAlunoById(id);
		return alunoDTO;
	}
	
	@PostMapping("/novo-aluno")
	public void createAluno(@RequestBody AlunoDTO alunoDTO) throws SalvarDadoAlunoException {
		 service.createAluno(alunoDTO);
	} 
	
	@PutMapping("/alunos/atualizar/{id}")
	public void updateAluno(@RequestBody AlunoDTO alunoDTO) throws AlunoInexistenteException, SalvarDadoAlunoException {
		 service.updateAluno(alunoDTO);
	} 
	
	@DeleteMapping("/aluno/delete/{id}")
	public void deleteAluno(@PathVariable long id) throws AlunoInexistenteException, DeletarAlunoException {
		service.deleteById(id);
	}
}
