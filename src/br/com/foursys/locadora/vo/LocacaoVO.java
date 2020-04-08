package br.com.foursys.locadora.vo;

public class LocacaoVO {
	
	private String cliente;
	private String filme;
	private String dataLocacao;
	
	public LocacaoVO() {
		
	}

	public LocacaoVO(String cliente, String filme, String dataLocacao) {
		this.cliente = cliente;
		this.filme = filme;
		this.dataLocacao = dataLocacao;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	
}
