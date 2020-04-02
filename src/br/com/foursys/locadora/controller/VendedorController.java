package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.dao.VendedorDAO;

public class VendedorController {
	
	public void salvar(Vendedor vendedor) {
		VendedorDAO dao = new VendedorDAO();
		try {
			dao.salvar(vendedor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Vendedor> buscarTodos(){
		ArrayList<Vendedor> listaRetorno = new ArrayList<Vendedor>();
		VendedorDAO dao = new VendedorDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Vendedor> buscarNome(String nome) {
		ArrayList<Vendedor> listaRetorno = new ArrayList<Vendedor>();
		VendedorDAO dao = new VendedorDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public void excluir(Vendedor vendedor) {
		VendedorDAO dao = new VendedorDAO();
		try {
			dao.excluir(vendedor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
