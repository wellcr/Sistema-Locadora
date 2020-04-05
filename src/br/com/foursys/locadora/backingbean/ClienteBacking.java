package br.com.foursys.locadora.backingbean;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.script.ScriptException;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Valida;

public class ClienteBacking {
	
	private int codigo;
	private String nome;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String cpf;
	private String rg;
	private String sexo;
	private String dataNascimento;
	private int idade;
	
	private Cliente clienteSelecionado = new Cliente();
	private List<Cliente> listaCliente;

	
	private int scrollerPage;
	private int qtdLinhas;
	private int paginaTotal;
	private List<Cliente> listaClienteTotal;
	
	private ArrayList clientes;
	
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

		
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	
	public String cadastraCliente() {
		return "";
	}
	
	public String consultaCliente() {
		listarCliente();
		return "";
	}
	
	public String cancelar() {
		limparDados();
		return "cancelar";
	}

	public String salvar() throws NoSuchMethodException, FileNotFoundException, ScriptException {
		Cliente cliente = new Cliente();
		if(validarDados()) {
			cliente.setNome(nome);
			cliente.setLogradouro(logradouro);
			cliente.setNumeroLogradouro(numero);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setCep(cep);
			cliente.setTelefone(telefone);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setSexo(sexo);
			cliente.setDataNascimento(dataNascimento);
			cliente.setIdade(idade);
			
			ClienteController controller = new ClienteController();
			
			try {
				controller.salvar(cliente);
				limparDados();
				JSFUtil.addInfoMessage("Cliente salvo com sucesso!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.addInfoMessage("Erro ao inserir Cliente!");
			}
		}
		
		return "";
	}
	
	public void limparDados() {
		nome = null;
		logradouro = null;
		numero = 0;
		bairro = null;
		cidade = null;
		estado = null;
		cep = null;
		telefone = null;
		cpf = null;
		rg = null;
		sexo = null;
		dataNascimento = null;
		idade = 0;
	}
	
	public boolean validarDados() throws NoSuchMethodException, FileNotFoundException, ScriptException {
		if(nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
			
		}
		
		
		if(logradouro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o logradouro, campo obrigatório!");
			return false;
			
		}
		
		if(numero == 0) {
			JSFUtil.addInfoMessage("Informe o numero, campo obrigatório!");
			return false;
			
		}
		if(bairro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o bairro, campo obrigatório!");
			return false;
		}

		
		if(cidade.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cidade, campo obrigatório!");
			return false;
			
		}
		if(estado.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o estado, campo obrigatório!");
			return false;
			
		}
		if(cep.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o CEP, campo obrigatório!");
			return false;
			
		}
		if(telefone.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o telefone, campo obrigatório!");
			return false;
			
		}
		if(telefone.equals("(00) 0000-0000")){
			JSFUtil.addInfoMessage("Telefone inválido!");
			return false;
			
		}
		if(cpf.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o CPF, campo obrigatório!");
			return false;	
		}
		if(!Valida.validaCpf(cpf)) {
			JSFUtil.addInfoMessage("CPF inválido!");
			return false;
		}
		
		if(rg.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o RG, campo obrigatório!");
			return false;
			
		}
		
		if(!Valida.validaRg(rg)) {
			JSFUtil.addInfoMessage("RG inválido!");
			return false;
		}
		
		if(sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório!");
			return false;
			
		}
		if(dataNascimento.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a data de nascimento, campo obrigatório!");
			return false;
			
		}
		if(!Valida.validaData(dataNascimento)) {
			JSFUtil.addInfoMessage("Data inválida!");
			return false;
		}
		
		if(idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigatório!");
			return false;
			
		}
		
		return true;
	}
	
	public String pesquisar() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		
		try {
			this.listaClienteTotal = new ClienteController().buscarNome(nome);
			
			if (this.listaClienteTotal.size() % 10 == 0) {
				this.paginaTotal = this.listaClienteTotal.size() / 10;			
			} else {
				this.paginaTotal = (this.listaClienteTotal.size() /10 ) + 1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Clientees");
		}
		return "";
	}
	
	public String excluir() {

		ClienteController controller = new ClienteController();
		
		try {
			controller.excluir(clienteSelecionado);
			pesquisar();
			JSFUtil.addInfoMessage("Cliente excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao excluír o Cliente!");
		}
		
		return "";
	}
	
	public String alteraCliente() {
		codigo = clienteSelecionado.getCodigo();
		nome = clienteSelecionado.getNome();
		logradouro = clienteSelecionado.getLogradouro();
		numero = clienteSelecionado.getNumeroLogradouro();
		bairro = clienteSelecionado.getBairro();
		cidade = clienteSelecionado.getCidade();
		estado = clienteSelecionado.getEstado();
		cep = clienteSelecionado.getCep();
		telefone = clienteSelecionado.getTelefone();
		cpf = clienteSelecionado.getCpf();
		rg = clienteSelecionado.getRg();
		sexo = clienteSelecionado.getSexo() +"";
		dataNascimento = clienteSelecionado.getDataNascimento();
		idade = clienteSelecionado.getIdade();
		return "alterar";
	}
	
	public String alterar() throws NoSuchMethodException, FileNotFoundException, ScriptException {
		if (validarDados()) {
			clienteSelecionado.setCodigo(codigo);
			clienteSelecionado.setNome(nome);
			clienteSelecionado.setLogradouro(logradouro);
			clienteSelecionado.setNumeroLogradouro(numero);
			clienteSelecionado.setBairro(bairro);
			clienteSelecionado.setCidade(cidade);
			clienteSelecionado.setEstado(estado);
			clienteSelecionado.setCep(cep);
			clienteSelecionado.setTelefone(telefone);
			clienteSelecionado.setCpf(cpf);
			clienteSelecionado.setRg(rg);
			clienteSelecionado.setSexo(sexo);
			clienteSelecionado.setDataNascimento(dataNascimento);
			clienteSelecionado.setIdade(idade);
			
			ClienteController controller = new ClienteController();
			
			try {
				controller.salvar(clienteSelecionado);
				limparDados();
				JSFUtil.addInfoMessage("Cliente alterado com sucesso!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.addInfoMessage("Erro ao alterar Cliente!");
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
	
	public String listarCliente() {
		this.scrollerPage = 1;
		this.qtdLinhas = 10;
		
		try {
			this.listaClienteTotal = new ClienteController().buscarTodos();
			
			if (this.listaClienteTotal.size() % 10 == 0) {
				this.paginaTotal = this.listaClienteTotal.size() / 10;			
			} else {
				this.paginaTotal = (this.listaClienteTotal.size() /10 ) + 1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Clientees");
		}
		return "";
	}
	
	public void montarLista() {
		listaCliente = new ArrayList<Cliente>();
		int contador = 0;
		int contCliente = 0;
		for (Cliente cliente : listaClienteTotal) {
			contCliente++;
			if(contador == this.qtdLinhas) 
				break;
			if ((contCliente <= (this.qtdLinhas*this.scrollerPage))&&
					(contCliente> (this.qtdLinhas*(this.scrollerPage-1)))) {
				listaCliente.add(cliente);
				contador++;
				
			}
		}
		
		
	}
	
	
	
	public List<String> carregarClientesCombo() {
		prepararClientes();
		return clientes;
	}
	
	
	private void prepararClientes(){
		clientes = new ArrayList();
		List<Cliente> listaClientes = new ClienteController().buscarTodos(); 
		clientes.add(new SelectItem("0", "Selecione um Cliente"));
		for (Cliente cliente : listaClientes) {
			clientes.add(new SelectItem(cliente.getNome(), cliente.getNome()));
		}
	}
}
