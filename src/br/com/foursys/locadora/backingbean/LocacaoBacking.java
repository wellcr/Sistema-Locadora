package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.LocacaoController;
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
	private List<Filme> listaFilmesAlugados1;
	private List<Locacao> listaLocacaoTotal;
	private List<Locacao> listaLocacao;
	
	private String comboCliente;
	private String comboFilme;
	private int scrollerPage;
	private int qtdLinhas;
	private int paginaTotal;
	
	private ArrayList filmes;
	
	
	
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

	public List<Filme> getListaFilmesAlugados1() {
		return listaFilmesAlugados1;
	}

	public void setListaFilmesAlugados1(List<Filme> listaFilmesAlugados1) {
		this.listaFilmesAlugados1 = listaFilmesAlugados1;
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

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public int getQtdLinhas() {
		return qtdLinhas;
	}

	public void setQtdLinhas(int qtdLinhas) {
		this.qtdLinhas = qtdLinhas;
	}

	public int getPaginaTotal() {
		return paginaTotal;
	}

	public void setPaginaTotal(int paginaTotal) {
		this.paginaTotal = paginaTotal;
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
		return "";
	}
	
	public void limparDados() {
		nomeCliente = "";
		nomeFilme = "";
		valorFilme = "";
		
	}
	
	public String sair() {
		return "sair";
	}
	
	public void popularCliente(ValueChangeEvent e) {
		nomeCliente = e.getNewValue().toString();
	}
	
	public void popularFilme(ValueChangeEvent e) {
		String auxIndice = e.getNewValue().toString();
		List<Filme> listaF = FilmeBacking.listaFilmeDisponivel;
		filme = listaF.get(Integer.parseInt(auxIndice)-1);

		this.nomeFilme = filme.getNome();
		if(filme.getPromocao().equals("SIM")) {
			this.valorFilme = filme.getValorPromocao()+""; 
		} else {
			this.valorFilme = filme.getValor()+"";
		}
	}
	
	
	public void selecionarFilme(ValueChangeEvent e) {
		String auxIndice = e.getNewValue().toString();
		List<Filme> listaF = listaFilmesAlugados;
		filme = listaF.get(Integer.parseInt(auxIndice)-1);
	}
	
	
	public String devolucao() {
		//if(validarDados()) {
		filme.setDisponivel("SIM");
		FilmeController controller = new FilmeController();
		
		controller.salvar(filme);
		JSFUtil.addInfoMessage("Devolu��o salva com sucesso!");
		//}
		return "";
	}
	
	public String salvar() {
		Locacao locacao = new Locacao();
		//if(validarDados()) {
		locacao.setNomeFilme(nomeFilme);
		locacao.setNomeCliente(nomeCliente);
		locacao.setValorFilme(Double.parseDouble(valorFilme));
		data = pegarData();
		locacao.setData(data);
			LocacaoController controller = new LocacaoController();	
			try {
				controller.salvar(locacao);
				mudarDisponivel();
				limparDados();
				JSFUtil.addInfoMessage("Loca��o salva com sucesso!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.addInfoMessage("Erro ao inserir Loca��o!");
			}
		//}
		return "";
	}
	
	public void mudarDisponivel() {
		filme.setDisponivel("N�O");
		FilmeController controller = new FilmeController();
		
		controller.salvar(filme);
	}
	
	public String pegarData() {
		Calendar cal = Calendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR);
        int mesAtual = cal.get(Calendar.MONTH) + 1;
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        int horaAtual = cal.get(Calendar.HOUR);
        int minutoAtual = cal.get(Calendar.MINUTE);
        int segundoAtual = cal.get(Calendar.SECOND);
        int milissegundoAtual = cal.get(Calendar.MILLISECOND);
        String strData = anoAtual + "-" + mesAtual + "-" + diaAtual + " " + horaAtual + ":" + minutoAtual + ":" + segundoAtual + "." + milissegundoAtual;
        return strData;
	}
	
	public List<String> carregarLocacao() {
		prepararFilmes(); 
		return filmes;
	}

	
	private void prepararFilmes(){
		filmes = new ArrayList();
		int i = 1;
		List<Filme> listaFilmes = new FilmeController().buscarTodos();
		filmes.add(new SelectItem("0", "Selecione a Loca��o"));
		for (Filme filme : listaFilmes) {
			if(filme.getDisponivel().equals("N�O")) {
				listaFilmesAlugados1.add(filme);
				filmes.add(new SelectItem(i+"",filme.getNome()));
				i++;
			}
		}
	}
	
	public String retornar() {
		if (this.scrollerPage>1) {
			this.scrollerPage--;
			montarLista();
			return "atualizar";
				
		} else {
			JSFUtil.addInfoMessage("N�o existem mais p�ginas para voltar");
			return "";
		}
	}
	
	public String avancar() {
		if (this.scrollerPage<this.paginaTotal) {
			this.scrollerPage++;
			montarLista();
			return "atualizar";
				
		} else {
			JSFUtil.addInfoMessage("N�o existem mais p�ginas para avan�ar");
			return "";
		}
		
	}
	
	public String listarLocacao() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		
		try {
			this.listaLocacaoTotal = new LocacaoController().buscarTodos();
			
			if (this.listaLocacaoTotal.size() % 10 == 0) {
				this.paginaTotal = this.listaLocacaoTotal.size() / 10;			
			} else {
				this.paginaTotal = (this.listaLocacaoTotal.size() /10 ) + 1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Loca��es");
		}
		return "";
	}
	
	public void montarLista() {
		listaLocacao = new ArrayList<Locacao>();
		int contador = 0;
		int contLocacao = 0;
		for (Locacao locacao : listaLocacaoTotal) {
			contLocacao++;
			if(contador == this.qtdLinhas) 
				break;
			if ((contLocacao <= (this.qtdLinhas*this.scrollerPage))&&
					(contLocacao> (this.qtdLinhas*(this.scrollerPage-1)))) {
				listaLocacao.add(locacao);
				contador++;
				
			}
		}

	}
}
