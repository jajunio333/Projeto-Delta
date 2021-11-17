package com.DELTA.dsalunos.dto;
import java.io.Serializable;
import com.DELTA.dsalunos.entities.Aluno;

public class AlunoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private String endereco;
	private String foto;
	
	public AlunoDTO(long id, String nome, String endereco, String foto) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.foto = foto;
	}
	public AlunoDTO(String nome, String endereco, String foto) {
		this.nome = nome;
		this.endereco = endereco;
		this.foto = foto;
	}
	public AlunoDTO() {
		
	}
	public AlunoDTO (Aluno entity) {
		id = entity.getId();
		nome = entity.getNome();
		endereco = entity.getendereco();
		foto = entity.getFoto();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getendereco() {
		return endereco;
	}

	public void setendereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
		
}
