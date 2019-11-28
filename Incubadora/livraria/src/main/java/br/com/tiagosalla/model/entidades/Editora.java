package br.com.tiagosalla.model.entidades;

public class Editora {
	
	private Long codigo;
	private String nome;
	
	public Editora() {
	}
	
	public Editora(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Editora{" +
				"codigo=" + codigo +
				", nome='" + nome + '\'' +
				'}';
	}

}
