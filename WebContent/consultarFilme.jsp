<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="http://localhost:8080/Sistema_Locadora/images/favicon-16x16.png" />
<link href="css/config.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Cliente</title>
</head>
<body class="background_Filme">


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<br>
		<h:form id="formConsulta" styleClass="panel_cadastro">
			<h:panelGrid columns="1">
					<h:messages styleClass="font_error"/>
			</h:panelGrid>
			<center>
				<h:panelGrid columns="3">
					<h:outputText value="Nome: " />
					<h:inputText value="#{filmeBacking.nome}" maxlength="50" size="40" />
					<h:commandButton value="Pesquisar Filme"
						action="#{filmeBacking.pesquisar}" />
				</h:panelGrid>

				<a4j:keepAlive beanName="filmeBacking" ajaxOnly="true" />
				<rich:spacer height="30" />
				<rich:dataTable width="490" id="listaFilme" rows="5"
					columnClasses="col" value="#{filmeBacking.listaFilme}" var="filme">

					<f:facet name="caption">
						<h:outputText value="Lista de Filmes" />
					</f:facet>

					<f:facet name="header">
						<rich:columnGroup>
							<rich:column>
								<h:outputText value="Nome" />
							</rich:column>
							<rich:column>
								<h:outputText value="Gênero" />
							</rich:column>
							<rich:column>
								<h:outputText value="Valor" />
							</rich:column>
							<rich:column>
								<h:outputText value="Disponível" />
							</rich:column>
							<rich:column>
								<h:outputText value="Promoção" />
							</rich:column>
							<rich:column colspan="2">
								<h:outputText value="Ações" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>
					<rich:column>
						<h:outputText value="#{filme.nome}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.genero}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filmeBacking.valorTabela(filme)}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.disponivel}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.promocao}" />
					</rich:column>
					<rich:column>
						<h:commandLink value="Excluir" action="#{filmeBacking.excluir}">
							<f:setPropertyActionListener value="#{filme}"
								target="#{filmeBacking.filmeSelecionado}" />
						</h:commandLink>
					</rich:column>
					<rich:column>
						<h:commandLink value="Alterar"
							action="#{filmeBacking.alteraFilme}">
							<f:setPropertyActionListener value="#{filme}"
								target="#{filmeBacking.filmeSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
			</center>

			<rich:datascroller align="center" for="listaFilme" maxPages="20"
				page="#{filmeBacking.scrollerPage}" id="sc2" reRender="listaFilme" />
			
			<center>
			<h:panelGrid columns="3">
				<h:commandButton value="Cancelar" action="#{filmeBacking.cancelar}" />
			</h:panelGrid>
			</center>

		</h:form>

	</f:view>

</body>
</html>