package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.vo.FilmeVO;

public class FilmeController {
	
	public void salvar(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.salvar(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Filme> buscarTodos(){
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Filme> buscarNome(String nome) {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public void excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.excluir(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Metodo para criar uma lista de filmes para exibir no relatório
	 * 
	 * @return ArrayList de filmes
	 * esse metodo será retirado futuramento
	 */
	
	public ArrayList<FilmeVO> retornaFilmes(){
		ArrayList<FilmeVO> listaVO = new ArrayList<FilmeVO>();
		
		
		try {
			ArrayList<Filme> listaFilme = new FilmeDAO().buscarTodos();
			for (Filme filme : listaFilme) {
				FilmeVO vo = new FilmeVO();
				vo.setCodigo(filme.getCodigo()+"");
				vo.setNome(filme.getNome());
				vo.setGenero(filme.getGenero());;
				listaVO.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return listaVO;
	}
}
