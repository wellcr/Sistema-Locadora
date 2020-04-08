package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.util.Data;
import br.com.foursys.locadora.util.JSFUtil;

public class LocacaoBacking {

	private int codigo;
	private String nomeCliente;
	private String nomeFilme;
	private String valorFilme;
	private String data;
	private Filme filme;
	private List<String> itensFilme;
	private List<Filme> listaFilme;
	private List<Cliente> listaCliente;
	private List<Filme> listaFilmesAlugados = new ArrayList<Filme>();
	private List<Locacao> listaLocacaoTotal;
	private List<Locacao> listaLocacao;

	private String comboCliente = "Selecione um cliente";
	private String comboFilme = "Selecione um filme";
	private String comboFilmeDevolucao = "Selecione a Locação";
	private int scrollerPage;

	private ArrayList filmes;
	
	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public String getComboFilmeDevolucao() {
		return comboFilmeDevolucao;
	}

	public void setComboFilmeDevolucao(String comboFilmeDevolucao) {
		this.comboFilmeDevolucao = comboFilmeDevolucao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Filme> getListaFilmesAlugados() {
		return listaFilmesAlugados;
	}

	public void setListaFilmesAlugados(List<Filme> listaFilmesAlugados) {
		this.listaFilmesAlugados = listaFilmesAlugados;
	}

	public List<Locacao> getListaLocacaoTotal() {
		return listaLocacaoTotal;
	}

	public void setListaLocacaoTotal(List<Locacao> listaLocacaoTotal) {
		this.listaLocacaoTotal = listaLocacaoTotal;
	}

	public List<Locacao> getListaLocacao() {
		return listaLocacao;
	}

	public void setListaLocacao(List<Locacao> listaLocacao) {
		this.listaLocacao = listaLocacao;
	}

	public String getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(String comboCliente) {
		this.comboCliente = comboCliente;
	}

	public String getComboFilme() {
		return comboFilme;
	}

	public void setComboFilme(String comboFilme) {
		this.comboFilme = comboFilme;
	}



	public ArrayList getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList filmes) {
		this.filmes = filmes;
	}

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

	public String consultarLocacao() {
		listarLocacao();
		return "";
	}

	public String efetuarLocacao() {

		return "";
	}

	public String efetuarDevolucao() {

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
		return "cancelar";
	}

	public void limparDados() {
		nomeCliente = "";
		nomeFilme = "";
		valorFilme = "";
		comboCliente = "Selecione um cliente";
		comboFilme = "Selecione um filme";

	}

	public String sair() {
		comboCliente = "Selecione um cliente";
		comboFilme = "Selecione um filme";
		limparDados();
		return "sair";
	}

	public void popularCliente(ValueChangeEvent e) {
		nomeCliente = "";
		nomeCliente = e.getNewValue().toString();
		if (nomeCliente.equals("0")) {
			nomeCliente = "";
		}
	}

	public void popularFilme(ValueChangeEvent e) {
		nomeFilme = "";
		String auxIndice = e.getNewValue().toString();
		List<Filme> listaF = FilmeBacking.listaFilmeDisponivel;
		filme = listaF.get(Integer.parseInt(auxIndice) - 1);

		this.nomeFilme = filme.getNome();
		if (filme.getPromocao().equals("SIM")) {
			this.valorFilme = filme.getValorPromocao() + "";
		} else {
			this.valorFilme = filme.getValor() + "";
		}
	}

	public void selecionarFilme(ValueChangeEvent e) {
		comboFilmeDevolucao = e.getNewValue().toString();
		String auxIndice = e.getNewValue().toString();
		List<Filme> listaF = listaFilmesAlugados;
		filme = listaF.get(Integer.parseInt(auxIndice) - 1);
	}

	public String devolucao() {
		if (validaDevolucao()) {
			filme.setDisponivel("SIM");
			FilmeController controller = new FilmeController();

			controller.salvar(filme);
			comboFilmeDevolucao = "Selecione um filme";
			JSFUtil.addInfoMessage("Devolução feita com sucesso!");
			
		}
		return "";
	}
	
	public boolean validaDevolucao() {
		if (comboFilmeDevolucao.equals("0")||comboFilmeDevolucao.equals("Selecione a Locação")) {
			JSFUtil.addInfoMessage("Selecione uma Locação.");
			return false;
		}
		return true;
	}

	public String salvar() {
		if (validaSalvar()) {
			Locacao locacao = new Locacao();
			locacao.setNomeFilme(nomeFilme);
			locacao.setNomeCliente(nomeCliente);
			locacao.setValorFilme(Double.parseDouble(valorFilme));
			data = Data.pegarDataAtual();
			locacao.setData(data);
			LocacaoController controller = new LocacaoController();
			try {
				controller.salvar(locacao);
				mudarDisponivel();
				limparDados();
				JSFUtil.addInfoMessage("Locação salva com sucesso!");
				comboFilme = "Selecione um filme";
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao inserir Locação!");
			}
		}
		return "";
	}

	public boolean validaSalvar() {
		if (nomeCliente.equals("")|| nomeCliente.equals("Selecione um cliente")) {
			JSFUtil.addInfoMessage("Selecione um Cliente.");
			return false;
		}
		if (nomeFilme.equals("")) {
			JSFUtil.addInfoMessage("Selecione um Filme.");
			return false;
		}
		return true;
	}

	public void mudarDisponivel() {
		filme.setDisponivel("NÃO");
		FilmeController controller = new FilmeController();

		controller.salvar(filme);
	}

	public List<String> carregarLocacao() {
		prepararFilmes();
		return filmes;
	}

	private void prepararFilmes() {
		filmes = new ArrayList();
		int i = 1;
		listaFilmesAlugados.clear();
		List<Filme> listaFilmes = new FilmeController().buscarTodos();
		filmes.add(new SelectItem("Selecione a Locação", "Selecione a Locação"));
		for (Filme filme : listaFilmes) {
			if (filme.getDisponivel().equals("NÃO")) {
				listaFilmesAlugados.add(filme);
				filmes.add(new SelectItem(i + "", filme.getNome()));
				i++;
			}
		}
	}

	
	public String listarLocacao() {
		this.scrollerPage = 1;

		try {
			this.listaLocacao = new LocacaoController().buscarTodos();

			
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Locações");
		}
		return "";
	}


	public String pegarDataLocacao() {
		String data = "";
		for (Locacao locacao : listaLocacao) {
			data = locacao.getData();
		}
		return Data.formataData(data);

	}
}
