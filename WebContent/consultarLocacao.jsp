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
<title>Consulta Locação</title>
</head>
<body>


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<center>
			<h:form id="formConsulta" styleClass="panel_cadastro">
				<h:panelGrid columns="1">
					<h:messages styleClass="font_error"/>
				</h:panelGrid>


				<a4j:keepAlive beanName="locacaoBacking" ajaxOnly="true" />
				<rich:spacer height="30" />
				<rich:dataTable width="490" id="listaLocacao" rows="5"
					columnClasses="col" value="#{locacaoBacking.listaLocacao}"
					var="locacao">

					<f:facet name="caption">
						<h:outputText value="Lista de filmes alugados" />
					</f:facet>

					<f:facet name="header">
						<rich:columnGroup>
							<rich:column>
								<h:outputText value="Cliente" />
							</rich:column>
							<rich:column>
								<h:outputText value="Filme" />
							</rich:column>
							<rich:column>
								<h:outputText value="Data" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>
					<rich:column>
						<h:outputText value="#{locacao.nomeCliente}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{locacao.nomeFilme}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{locacaoBacking.pegarDataLocacao()}" />
					</rich:column>
				</rich:dataTable>


				<rich:datascroller align="center" for="listaLocacao" maxPages="20"
					page="#{locacaoBacking.scrollerPage}" id="sc2"
					reRender="listaLocacao" />

				<h:panelGrid columns="3">
					<h:commandButton value="Cancelar" action="#{locacaoBacking.sair}" />
				</h:panelGrid>

			</h:form>
		</center>
	</f:view>

</body>
</html>
