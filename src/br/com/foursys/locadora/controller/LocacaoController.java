package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.dao.LocacaoDAO;
import br.com.foursys.locadora.vo.LocacaoVO;

public class LocacaoController {

	public void salvar(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.salvar(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Locacao> buscarTodos(){
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Locacao> buscarNome(String nome) {
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public void excluir(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.excluir(locacao);
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
	
	public ArrayList<LocacaoVO> retornaLocacao(){
		ArrayList<LocacaoVO> listaVO = new ArrayList<LocacaoVO>();
		
		
		try {
			ArrayList<Locacao> listaLocacao = new LocacaoDAO().buscarTodos();
			for (Locacao locacao : listaLocacao) {
				LocacaoVO vo = new LocacaoVO();
				vo.setCliente(locacao.getNomeCliente());
				vo.setFilme(locacao.getNomeFilme());
				vo.setDataLocacao(locacao.getData());;
				listaVO.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return listaVO;
	}
}
