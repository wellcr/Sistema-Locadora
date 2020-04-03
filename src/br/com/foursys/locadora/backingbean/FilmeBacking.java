package br.com.foursys.locadora.backingbean;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.util.JSFUtil;

public class FilmeBacking {
	
	private int codigo;
	private String nome;
	private String genero;
	private String valor;
	private String disponivel;
	private String promocao;
	private String valorPromocao;

	private Filme filmeSelecionado = new Filme();
	private List<Filme> listaFilme;
	static List<Filme> listaFilmeDisponivel = new ArrayList<Filme>();
	private String aux = "";
	
	private int scrollerPage;
	private int qtdLinhas;
	private int paginaTotal;
	private List<Filme> listaFilmeTotal;
	
	private ArrayList filmes;
	
	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public String getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(String valorPromocao) {
		this.valorPromocao = valorPromocao;
	}


	public Filme getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(Filme filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}

	public List<Filme> getListaFilme() {
		return listaFilme;
	}

	public void setListaFilme(List<Filme> listaFilme) {
		this.listaFilme = listaFilme;
	}

	public List<Filme> getListaFilmeDisponivel() {
		return listaFilmeDisponivel;
	}

	public void setListaFilmeDisponivel(List<Filme> listaFilmeDisponivel) {
		this.listaFilmeDisponivel = listaFilmeDisponivel;
	}

	public String cadastraFilme() {
		return "";
	}
	
	public String consultaFilme() {
		listarFilme();
		return "";
	}
	
	public String cancelar() {
		limparDados();
		return "cancelar";
	}
	
	public String salvar() {
		Filme filme = new Filme();
		if(validarDados()) {
			filme.setNome(nome);
			filme.setGenero(genero);
			filme.setValor(Double.parseDouble(valor.replace(".", "").replace(",", ".")));
			filme.setDisponivel(disponivel);
			filme.setPromocao(promocao);
			filme.setValorPromocao(Double.parseDouble(valorPromocao.replace(".", "").replace(",", ".")));
			
			
			FilmeController controller = new FilmeController();
			
			try {
				controller.salvar(filme);
				limparDados();
				JSFUtil.addInfoMessage("Filme salvo com sucesso!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.addInfoMessage("Erro ao inserir filme!");
			}
		}
		
		return "";
	}
	
	public void limparDados() {
		nome = null;
		genero = null;
		valor = null;
		disponivel = null;
		promocao = null;
		valorPromocao = null;
		
	}
	
	public boolean validarDados() {
		if(nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
			
		}
		if(genero.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o gênero, campo obrigatório!");
			return false;
			
		}
		
		if(disponivel.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o disponibilidade, campo obrigatório!");
			return false;
			
		}
		
		if(valor.equals("0,00") || valor.equals("0,0")|| valor.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o valor, campo obrigatório!");
			return false;
			
		}
		
		if(promocao.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o se está em promoção, campo obrigatório!");
			return false;
			
		}
				
		if(valorPromocao.equals("0,00") || valorPromocao.equals("0,0") || valorPromocao.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a valor da promoção, campo obrigatório!");
			return false;
			
		}
		
		return true;
	}
	
	public String pesquisar() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		
		try {
			this.listaFilmeTotal = new FilmeController().buscarNome(nome);
			
			if (this.listaFilmeTotal.size() % 10 == 0) {
				this.paginaTotal = this.listaFilmeTotal.size() / 10;			
			} else {
				this.paginaTotal = (this.listaFilmeTotal.size() /10 ) + 1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Filmees");
		}
		return "";
	}
	
	public String excluir() {
		FilmeController controller = new FilmeController();
		
		try {
			controller.excluir(filmeSelecionado);
			pesquisar();
			JSFUtil.addInfoMessage("filme excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao excluír o filme!");
		}
		
		return "";
	}
	
	public String alteraFilme() {
		codigo = filmeSelecionado.getCodigo();
		nome = filmeSelecionado.getNome();
		genero = filmeSelecionado.getGenero();
		valor = (filmeSelecionado.getValor()+"").replace(".", ",");
		disponivel = filmeSelecionado.getDisponivel();
		promocao = filmeSelecionado.getPromocao();
		valorPromocao = (filmeSelecionado.getValorPromocao()+"").replace(".", ",");
		return "alterar";
	}
	
	public String alterar() {
		if (validarDados()) {
			filmeSelecionado.setCodigo(codigo);
			filmeSelecionado.setNome(nome);
			filmeSelecionado.setGenero(genero);
			filmeSelecionado.setValor(Double.parseDouble(valor.replace(".", "").replace(",", ".")));
			filmeSelecionado.setDisponivel(disponivel);
			filmeSelecionado.setPromocao(promocao);
			filmeSelecionado.setValorPromocao(Double.parseDouble(valorPromocao.replace(".", "").replace(",", ".")));
			
			FilmeController controller = new FilmeController();
			
			try {
				controller.salvar(filmeSelecionado);
				limparDados();
				JSFUtil.addInfoMessage("Filme alterado com sucesso!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.addInfoMessage("Erro ao alterar filme!");
			}
			
			
		}
		
		return "";
	}
	
	public String retornar() {
		if (this.scrollerPage>1) {
			this.scrollerPage--;
			montarLista();
			return "atualizar";
				
		} else {
			JSFUtil.addInfoMessage("Não existem mais páginas para voltar");
			return "";
		}
	}
	
	public String avancar() {
		if (this.scrollerPage<this.paginaTotal) {
			this.scrollerPage++;
			montarLista();
			return "atualizar";
				
		} else {
			JSFUtil.addInfoMessage("Não existem mais páginas para avançar");
			return "";
		}
		
	}
	
	public String valorTabela(Filme filme) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
		return formatoMoeda.format(filme.getValor());
	}
	
	
	
	public String listarFilme() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		
		try {
			this.listaFilmeTotal = new FilmeController().buscarTodos();
			
			if (this.listaFilmeTotal.size() % 10 == 0) {
				this.paginaTotal = this.listaFilmeTotal.size() / 10;			
			} else {
				this.paginaTotal = (this.listaFilmeTotal.size() /10 ) + 1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Filmees");
		}
		return "";
	}
	
	public void montarLista() {
		listaFilme = new ArrayList<Filme>();
		int contador = 0;
		int contFilme = 0;
		for (Filme filme : listaFilmeTotal) {
			contFilme++;
			if(contador == this.qtdLinhas) 
				break;
			if ((contFilme <= (this.qtdLinhas*this.scrollerPage))&&
					(contFilme> (this.qtdLinhas*(this.scrollerPage-1)))) {
				listaFilme.add(filme);
				contador++;
				
			}
		}
		
		
	}
	
	
	
	public List<String> carregarFilmesCombo() {
		prepararFilmes(); 
		return filmes;
	}
	

	private void prepararFilmes(){
		filmes = new ArrayList();
		int i = 1;
		List<Filme> listaFilmes = new FilmeController().buscarTodos(); 
		filmes.add(new SelectItem("0", "Selecione um Filme"));
		for (Filme filme : listaFilmes) {
			if(filme.getDisponivel().equals("SIM")) {
				listaFilmeDisponivel.add(filme);
				filmes.add(new SelectItem(i+"",filme.getNome()));
				i++;
			}
		}
	}
}
