package com.DELTA.dsalunos.dto;
import java.io.Serializable;
import com.DELTA.dsalunos.entities.Aluno;

public class AlunoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private String endereço;
	private String foto;
	
	public AlunoDTO(long id, String nome, String endereço, String foto) {
		this.id = id;
		this.nome = nome;
		this.endereço = endereço;
		this.foto = foto;
	}
	public AlunoDTO(String nome, String endereço, String foto) {
		this.nome = nome;
		this.endereço = endereço;
		this.foto = foto;
	}
	public AlunoDTO() {
		
	}
	public AlunoDTO (Aluno entity) {
		id = entity.getId();
		nome = entity.getNome();
		endereço = entity.getEndereço();
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

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
		
}
