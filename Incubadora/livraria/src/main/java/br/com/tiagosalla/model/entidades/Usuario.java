package br.com.tiagosalla.model.entidades;

public class Usuario {
	private Long codigo;
	private String usuario;
	private String senha;
	private String nome;
	private String email;

	public Usuario() {
	}

	public Usuario(Long codigo, String usuario, String senha, String nome, String email) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"codigo=" + codigo +
				", usuario='" + usuario + '\'' +
				", senha='" + senha + '\'' +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				'}';
	}

}

