package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;

public class TesteFilme {
	public void salvar() {
		
		Filme filme = new Filme();
		
		filme.setNome("A era do gelo");
		filme.setGenero("Infantil");
		filme.setValor(10.5);
		filme.setDisponivel("SIM");
		filme.setPromocao("NÃO");
		filme.setValorPromocao(8.25);
		
		FilmeDAO dao = new FilmeDAO();
		dao.salvar(filme);
		System.out.println("Filme inserido com sucesso!");
		
	}
	
	public static void main(String[] args) {
		new TesteFilme().salvar();
	}
	
}
