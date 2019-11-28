package br.com.tiagosalla.model.entidades;

import java.util.Date;

public class Autor {
	
	private Long matricula;
	private String nome;
	private Date data_nascimento;
	private String nacionalidade;
	
	public Autor() {
	}
	
	public Autor(Long matricula, String nome, Date data_nascimento, String nacionalidade) {
		this.matricula = matricula;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.nacionalidade = nacionalidade;
	}

	public Long getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return data_nascimento;
	}
	
	public void setDataNascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
		return "Autor{" +
				"matricula=" + matricula +
				", nome='" + nome + '\'' +
				", data_nascimento=" + data_nascimento +
				", nacionalidade='" + nacionalidade + '\'' +
				'}';
	}

}