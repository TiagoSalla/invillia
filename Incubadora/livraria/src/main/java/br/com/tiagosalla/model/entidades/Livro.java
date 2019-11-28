package br.com.tiagosalla.model.entidades;

import java.util.Date;

public class Livro {
	
	private Long codigo;
	private String titulo;
	private Date data_lancamento;
	private Long codigo_autor;
	private Long codigo_editora;
	private Long codigo_assunto;
	
	public Livro() {
	}

	public Livro(Long codigo, String titulo, Date data_lancamento, Long codigo_autor, Long codigo_editora, Long codigo_assunto) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.data_lancamento = data_lancamento;
		this.codigo_autor = codigo_autor;
		this.codigo_editora = codigo_editora;
		this.codigo_assunto = codigo_assunto;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Date getDataLancamento() {
		return data_lancamento;
	}
	
	public void setDataLancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	
	public Long getCodigoAutor() {
		return codigo_autor;
	}
	
	public void setCodigoAutor(Long codigo_autor) {
		this.codigo_autor = codigo_autor;
	}
	
	public Long getCodigoEditora() {
		return codigo_editora;
	}
	
	public void setCodigoEditora(Long codigo_editora) {
		this.codigo_editora = codigo_editora;
	}
	
	public Long getCodigoAssunto() {
		return codigo_assunto;
	}
	
	public void setCodigoAssunto(Long codigo_assunto) {
		this.codigo_assunto = codigo_assunto;
	}

	@Override
	public String toString() {
		return "Livro{" +
				"codigo=" + codigo +
				", titulo='" + titulo + '\'' +
				", data_lancamento=" + data_lancamento +
				", codigo_autor=" + codigo_autor +
				", codigo_editora=" + codigo_editora +
				", codigo_assunto=" + codigo_assunto +
				'}';
	}
}
