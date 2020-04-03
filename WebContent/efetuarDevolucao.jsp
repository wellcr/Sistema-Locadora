<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" contet="text/html; charset=ISO-8859-1">

	<script type="text/javascript" src="js/mascara.js"></script>

	<title>Efetuar Devolução</title>
</head>
<body>
	<f:view>
		<jsp:include page="/menu.jsp" />
		<h:form>
			<h1>Efetuar Devolução</h1>

			<h:panelGrid columns="2">
				<h:selectOneMenu value="#{filmeBacking.nome}"
					id="comboFilme"
					required="true" onchange="submit()"
					valueChangeListener="#{locacaoBacking.selecionarFilme}">
					<f:selectItems value="#{locacaoBacking.carregarLocacao()}" />
				</h:selectOneMenu>

			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:commandButton value="Salvar" action="#{locacaoBacking.devolucao}" />
				<h:commandButton value="Sair" action="#{locacaoBacking.sair}" />
			</h:panelGrid>

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

		</h:form>


	</f:view>
</body>
</html>