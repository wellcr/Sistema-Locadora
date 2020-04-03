package br.com.foursys.locadora.backingbean;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.controller.VendedorController;
import br.com.foursys.locadora.util.JSFUtil;

public class VendedorBacking {
	
	private int codigo;
	private String nome;
	private String areaVenda;
	private String cidade;
	private String estado;
	private String sexo;
	private int idade;
	private String salario;

	private Vendedor vendedorSelecionado = new Vendedor();
	private List<Vendedor> listaVendedor;
	private List<Vendedor> listaAux;
	
	private int scrollerPage;
	private int qtdLinhas;
	private int paginaTotal;
	private List<Vendedor> listaVendedorTotal;
	
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

	public String getAreaVenda() {
		return areaVenda;
	}

	public void setAreaVenda(String areaVenda) {
		this.areaVenda = areaVenda;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
	}

	public List<Vendedor> getListaVendedor() {
		return listaVendedor;
	}

	public void setListaVendedor(List<Vendedor> listaVendedor) {
		this.listaVendedor = listaVendedor;
	}

	public List<Vendedor> getListaAux() {
		return listaAux;
	}

	public void setListaAux(List<Vendedor> listaAux) {
		this.listaAux = listaAux;
	}


	public String cadastraVendedor() {
		return "";
	}
	
	public String consultaVendedor() {
		listarVendedor();
		return "";
	}
	
	public String cancelar() {
		limparDados();
		return "cancelar";
	}
	
	public String salvar() {
		Vendedor vendedor = new Vendedor();
		if(validarDados()) {
			vendedor.setNome(nome);
			vendedor.setAreaVenda(areaVenda);
			vendedor.setCidade(cidade);
			vendedor.setEstado(estado);
			vendedor.setSexo(sexo);
			vendedor.setIdade(idade);
			vendedor.setSalario(Double.parseDouble(salario.replace(".", "").replace(",", ".")));
			
			VendedorController controller = new  VendedorController();
			
			try {
				controller.salvar(vendedor);
				limparDados();
				JSFUtil.addInfoMessage("Vendedor salvo com sucesso!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.addInfoMessage("Erro ao inserir vendedor!");
			}
		}
		
		return "";
	}
	
	public void limparDados() {
		nome = null;
		areaVenda = null;
		cidade = null;
		estado = null;
		sexo = null;
		idade = 0;
		salario = null;
		
	}
	
	public boolean validarDados() {
		if(nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
			
		}
		if(areaVenda.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a area de venda, campo obrigatório!");
			return false;
			
		}
		
		if(cidade.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a cidade, campo obrigatório!");
			return false;
			
		}
		
		if(estado.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o estado, campo obrigatório!");
			return false;
			
		}
		
		if(sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório!");
			return false;
			
		}
		
		if(idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigatório!");
			return false;
			
		}
				
		if(salario.equals("0,00") || salario.equals("0,0") || salario.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a valor do salário, campo obrigatório!");
			return false;
			
		}
		
		return true;
	}
	
	public String pesquisar() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		
		try {
			this.listaVendedorTotal = new VendedorController().buscarNome(nome);
			
			if (this.listaVendedorTotal.size() % 10 == 0) {
				this.paginaTotal = this.listaVendedorTotal.size() / 10;			
			} else {
				this.paginaTotal = (this.listaVendedorTotal.size() /10 ) + 1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Vendedores");
		}
		return "";
	}
	
	public String excluir() {
		VendedorController controller = new  VendedorController();
		
		try {
			controller.excluir(vendedorSelecionado);
			pesquisar();
			JSFUtil.addInfoMessage("Vendedor excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao excluír o vendedor!");
		}
		
		return "";
	}
	
	public String alteraVendedor() {
		codigo = vendedorSelecionado.getCodigo();
		nome = vendedorSelecionado.getNome();
		areaVenda = vendedorSelecionado.getAreaVenda();
		cidade = vendedorSelecionado.getCidade();
		estado = vendedorSelecionado.getEstado();
		sexo = vendedorSelecionado.getSexo()+"";
		idade = vendedorSelecionado.getIdade();
		salario = (vendedorSelecionado.getSalario()+"").replace(".", ",");
		return "alterar";
	}
	
	public String alterar() {
		if (validarDados()) {
			vendedorSelecionado.setCodigo(codigo);
			vendedorSelecionado.setNome(nome);
			vendedorSelecionado.setAreaVenda(areaVenda);
			vendedorSelecionado.setCidade(cidade);
			vendedorSelecionado.setEstado(estado);
			vendedorSelecionado.setSexo(sexo);
			vendedorSelecionado.setIdade(idade);
			vendedorSelecionado.setSalario(Double.parseDouble(salario.replace(".", "").replace(",", ".")));
			
			VendedorController controller = new  VendedorController();
			
			try {
				controller.salvar(vendedorSelecionado);
				limparDados();
				JSFUtil.addInfoMessage("Vendedor alterado com sucesso!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.addInfoMessage("Erro ao alterar vendedor!");
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
	
	public String listarVendedor() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		
		try {
			this.listaVendedorTotal = new VendedorController().buscarTodos();
			
			if (this.listaVendedorTotal.size() % 10 == 0) {
				this.paginaTotal = this.listaVendedorTotal.size() / 10;			
			} else {
				this.paginaTotal = (this.listaVendedorTotal.size() /10 ) + 1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Vendedores");
		}
		return "";
	}
	
	public void montarLista() {
		listaVendedor = new ArrayList<Vendedor>();
		int contador = 0;
		int contVendedor = 0;
		for (Vendedor vendedor : listaVendedorTotal) {
			contVendedor++;
			if(contador == this.qtdLinhas) 
				break;
			if ((contVendedor <= (this.qtdLinhas*this.scrollerPage))&&
					(contVendedor> (this.qtdLinhas*(this.scrollerPage-1)))) {
				listaVendedor.add(vendedor);
				contador++;
				
			}
		}
		
		
	}

	
	public String valorTabela(Vendedor vendedor) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
		return formatoMoeda.format(vendedor.getSalario());
	}
}
