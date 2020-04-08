<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>    
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content ="text/html; charset=ISO-8859-1"/>
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/Sistema_Locadora/imagens/favicon-16x16.png"/>
<link href="css/config.css" rel="stylesheet"/>
<script type="text/javascript" src="js/mascara.js"></script>
<title>Alteração de Cliente</title>
</head>
<body class="background_Cliente">

	<f:view>
	
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form  styleClass="panel_cadastro">
			<div align="center" style="width: 100%">
			<h1>Alteração de Cliente</h1>
			<h:panelGrid columns="1">
					<h:messages styleClass="font_error"/>
			</h:panelGrid>
			<div align="right" style="width: 600px">
			
			
			
			<h:panelGrid columns="2">
				<h:outputText value="Nome: " />
				<h:inputText value="#{clienteBacking.nome}" maxlength="50" size="76" disabled="true" />
			</h:panelGrid>
			
			<h:panelGrid columns="4">
				<h:outputText value="Logradouro: " />
				<h:inputText value="#{clienteBacking.logradouro}" maxlength="51" size="52" />
				<h:outputText value="Número: " />
				<h:inputText value="#{clienteBacking.numero}" maxlength="50" size="8" 
								onkeyup="masc_numero(this)"/>
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="Bairro: " />
				<h:inputText value="#{clienteBacking.bairro}" maxlength="50" size="25" />
				<div style="width: 65px"/>
				<h:outputText value="Cidade: " />
				<h:inputText value="#{clienteBacking.cidade}" maxlength="50" size="25"/>
			</h:panelGrid>
			
			
			<h:panelGrid columns="5">
				<h:outputText value="Estado: " />
				<h:inputText value="#{clienteBacking.estado}" maxlength="50" size="25"/>
				<div style="width: 81px"/>
				<h:outputText value="CEP: " />
				<h:inputText value="#{clienteBacking.cep}" maxlength="10" size="25" 
								onkeyup="masc_cep(this)"/>
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="Telefone: " />
				<h:inputText value="#{clienteBacking.telefone}" maxlength="14" size="25"
								onkeyup="masc_telefone(this)"/>
				<div style="width: 81px"/>
				<h:outputText value="CPF: " />
				<h:inputText value="#{clienteBacking.cpf}" maxlength="14" size="25" disabled="true" 
								onkeyup="masc_cpf(this)"/>
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="RG: " />
				<h:inputText value="#{clienteBacking.rg}" maxlength="12" size="25" disabled="true" 
								onkeyup="masc_rg(this)"/>
				<div style="width: 65px"/>
				<h:outputText value="Sexo: "/>
				<h:selectOneRadio value="#{clienteBacking.sexo}" disabled="true" >
					<f:selectItem itemValue="F" itemLabel="Feminino"/>
					<f:selectItem itemValue="M" itemLabel="Masculino"/>
				</h:selectOneRadio>			
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="Data nascimento:" />
				<h:inputText value="#{clienteBacking.dataNascimento}" maxlength="10" size="25" disabled="true" 
								onkeyup="masc_data(this)"/>
				<div style="width: 174px"/>
				<h:outputText value="Idade: " />
				<h:inputText value="#{clienteBacking.idade}" maxlength="50" size="8" disabled="true" 
								onkeyup="masc_numero(this)"/>
			</h:panelGrid>
			
			<div style="width: 100%" align="center">
			<h:panelGrid columns="2">
				<h:commandButton value="Alterar" action="#{clienteBacking.alterar}"/>
				<h:commandButton value="Cancelar" action="#{clienteBacking.cancelar}"/>
			</h:panelGrid>
			</div>
			</div>
			</div>
		</h:form>
	
	</f:view>

</body>
</html>