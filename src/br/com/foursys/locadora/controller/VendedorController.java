package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.vo.VendedorVO;

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
	
	public ArrayList<VendedorVO> retornaVendedores(){
		ArrayList<VendedorVO> listaVO = new ArrayList<VendedorVO>();
		
		
		try {
			ArrayList<Vendedor> listaVendedor = new VendedorDAO().buscarTodos();
			for (Vendedor vendedor : listaVendedor) {
				VendedorVO vo = new VendedorVO();
				vo.setNome(vendedor.getNome());
				vo.setAreaVenda(vendedor.getAreaVenda());
				vo.setSalario("R$"+vendedor.getSalario());
				listaVO.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return listaVO;
	}
	
}
