<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>    
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" contet ="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Cadastro de Cliente</title>
</head>
<body>

	<f:view>
	
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<div align="center" style="width: 100%">
			<h1>Cadastro de Cliente</h1>
			
			<div align="right" style="width: 50%">
			
			
			
			<h:panelGrid columns="2">
				<h:outputText value="Nome: " />
				<h:inputText value="#{clienteBacking.nome}" maxlength="50" size="80" />
			</h:panelGrid>
			
			<h:panelGrid columns="4">
				<h:outputText value="Logradouro: " />
				<h:inputText value="#{clienteBacking.logradouro}" maxlength="51" size="56" />
				<h:outputText value="Número: " />
				<h:inputText value="#{clienteBacking.numero}" maxlength="50" size="8" 
								onkeyup="masc_numero(this)"/>
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="Bairro: " />
				<h:inputText value="#{clienteBacking.bairro}" maxlength="50" size="25" />
				<div style="width: 85px"/>
				<h:outputText value="Cidade: " />
				<h:inputText value="#{clienteBacking.cidade}" maxlength="50" size="25"/>
			</h:panelGrid>
			
			
			<h:panelGrid columns="5">
				<h:outputText value="Estado: " />
				<h:inputText value="#{clienteBacking.estado}" maxlength="50" size="25"/>
				<div style="width: 101px"/>
				<h:outputText value="CEP: " />
				<h:inputText value="#{clienteBacking.cep}" maxlength="10" size="25" 
								onkeyup="masc_cep(this)"/>
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="Telefone: " />
				<h:inputText value="#{clienteBacking.telefone}" maxlength="14" size="25"
								onkeyup="masc_telefone(this)"/>
				<div style="width: 101px"/>
				<h:outputText value="CPF: " />
				<h:inputText value="#{clienteBacking.cpf}" maxlength="14" size="25"
								onkeyup="masc_cpf(this)"/>
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="RG: " />
				<h:inputText value="#{clienteBacking.rg}" maxlength="12" size="25"
								onkeyup="masc_rg(this)"/>
				<div style="width: 85px"/>
				<h:outputText value="Sexo: "/>
				<h:selectOneRadio value="#{clienteBacking.sexo}">
					<f:selectItem itemValue="F" itemLabel="Feminino"/>
					<f:selectItem itemValue="M" itemLabel="Masculino"/>
				</h:selectOneRadio>			
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="Data de nascimento: " />
				<h:inputText value="#{clienteBacking.dataNascimento}" maxlength="10" size="25"
								onkeyup="masc_data(this)"/>
				<div style="width: 194px"/>
				<h:outputText value="Idade: " />
				<h:inputText value="#{clienteBacking.idade}" maxlength="50" size="8" 
								onkeyup="masc_numero(this)"/>
			</h:panelGrid>
			
			<div style="width: 100%" align="center">
			<h:panelGrid columns="2">
				<h:commandButton value="Salvar" action="#{clienteBacking.salvar}"/>
				<h:commandButton value="Cancelar" action="#{clienteBacking.cancelar}"/>
			</h:panelGrid>
			</div>
			</div>
			</div>
		</h:form>
		<h:panelGrid columns="1">
				<h:messages />
		</h:panelGrid>
	
	
	</f:view>

</body>
</html>