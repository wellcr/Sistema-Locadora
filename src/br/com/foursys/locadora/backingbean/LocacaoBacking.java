package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.util.JSFUtil;

public class LocacaoBacking {
	
	private int codigo;
	private String nomeCliente = "";
	private String nomeFilme = "";
	private String valorFilme;
	private String data;

	private List<String> itensFilme;
	private List<Filme> listaFilme;
	private List<Cliente> listaCliente;
	private List<Locacao> listaFilmesAlugados;
	
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getValorFilme() {
		return valorFilme;
	}

	public void setValorFilme(String valorFilme) {
		this.valorFilme = valorFilme;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<String> getItensFilme() {
		return itensFilme;
	}

	public void setItensFilme(List<String> itensFilme) {
		this.itensFilme = itensFilme;
	}
	
	public List<Locacao> getListaFilmesAlugados() {
		return listaFilmesAlugados;
	}

	public void setListaFilmesAlugados(List<Locacao> listaFilmesAlugados) {
		this.listaFilmesAlugados = listaFilmesAlugados;
	}

	public String efetuarLocacao() {
		
		return "";
	}
	
	public List<Filme> getListaFilme() {
		return listaFilme;
	}

	public void setListaFilme(List<Filme> listaFilme) {
		this.listaFilme = listaFilme;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}


	public String cancelar() {
		limparDados();
		return "";
	}
	
	public void limparDados() {
		nomeCliente = null;
		nomeFilme = null;
		ClienteBacking clienteBacking = new ClienteBacking();
		clienteBacking.carregarClientesCombo();
		
		
	}
	
	public String sair() {
		return "sair";
	}
	
	

}
