<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/Sistema_Locadora/images/favicon-16x16.png"/>
<link href="css/config.css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>

<script type="text/javascript" src="js/mascara.js"></script>

<title>Efetuar Locação</title>
</head>
<body>
	<f:view>
		<jsp:include page="/menu.jsp" />
		<center>
		<h:form styleClass="panel_cadastro">
			
			<h3>Efetuar locação</h3>
			
			<h:panelGrid columns="1">
					<h:messages styleClass="font_error"/>
			</h:panelGrid>

			<h:panelGrid columns="4">
				<h:outputLabel value="Cliente: " />
				<h:selectOneMenu 
					value="#{clienteBacking.nome}"
					id="comboCliente"
					required="false" onchange="submit()" requiredMessage="Selecione um cliente"
					valueChangeListener="#{locacaoBacking.popularCliente}">
					<f:selectItems value="#{clienteBacking.carregarClientesCombo()}" />
					
				</h:selectOneMenu>

			<h:outputLabel value="Filme: " />
				<h:selectOneMenu value="#{filmeBacking.nome}"
					id="comboFilme"
					required="false" onchange="submit()" requiredMessage="Selecione um filme"
					valueChangeListener="#{locacaoBacking.popularFilme}">
					<f:selectItems value="#{filmeBacking.carregarFilmesCombo()}" />
				</h:selectOneMenu>

			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome do Cliente: "/>
				<h:outputText id="nomeCliente" value="#{locacaoBacking.nomeCliente}" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome do Filme: " />
				<h:outputText id="nomeFilme" value="#{locacaoBacking.nomeFilme}" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Valor da Locação: " />
				<h:outputText id="valorFilme" value="#{locacaoBacking.valorFilme}" />
			</h:panelGrid>
			
			<h:panelGrid columns="3">
				<h:commandButton value="Salvar" action="#{locacaoBacking.salvar}" />
				<h:commandButton value="Cancelar"
					action="#{locacaoBacking.cancelar}" />
				<h:commandButton value="Sair" action="#{locacaoBacking.sair}" />	
				
			</h:panelGrid>


		</h:form>

		
	</center>

	</f:view>
</body>
</html>
