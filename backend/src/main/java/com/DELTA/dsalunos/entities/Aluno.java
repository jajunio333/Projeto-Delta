package com.DELTA.dsalunos.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "tb_alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String endereco;
	private String foto;
	
	
	public Aluno (String nome, String endereco, String foto) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.foto = foto;
	}
	
	public Aluno() {
	
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
