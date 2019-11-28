package br.com.tiagosalla.model.entidades;

public class Assunto {
	
	private Long codigo;
	private String sigla;
	private String descricao;

    public Assunto() {
    }

    public Assunto(Long codigo, String sigla, String descricao) {
		this.codigo = codigo;
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
    public String toString() {
        return "Assunto{" +
                "codigo=" + codigo +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
