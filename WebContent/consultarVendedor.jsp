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
<title>Consulta de Vendedor</title>
</head>
<body class="background_Vendedor">


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
					<h:inputText value="#{vendedorBacking.nome}" maxlength="50"
						size="40" />
					<h:commandButton value="Pesquisar Vendedor"
						action="#{vendedorBacking.pesquisar}" />
				</h:panelGrid>



				<a4j:keepAlive beanName="vendedorBacking" ajaxOnly="true" />
				<rich:spacer height="30" />
				<rich:dataTable width="490" id="listaVendedor" rows="5" columnClasses="col"
					value="#{vendedorBacking.listaVendedor}" var="vendedor">

					<f:facet name="caption">
						<h:outputText value="Lista de Vendedores" />
					</f:facet>

					<f:facet name="header">
						<rich:columnGroup>
							<rich:column>
								<h:outputText value="Nome" />
							</rich:column>
							<rich:column>
								<h:outputText value="Área de Venda" />
							</rich:column>
							<rich:column>
								<h:outputText value="Salário" />
							</rich:column>
							<rich:column colspan="2">
								<h:outputText value="Ações" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>
					<rich:column>
						<h:outputText value="#{vendedor.nome}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{vendedor.areaVenda}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{vendedorBacking.valorTabela(vendedor)}" />
					</rich:column>
					<rich:column>
						<h:commandLink value="Excluir" action="#{vendedorBacking.excluir}">
							<f:setPropertyActionListener value="#{vendedor}"
								target="#{vendedorBacking.vendedorSelecionado}" />
						</h:commandLink>
					</rich:column>
					<rich:column>
						<h:commandLink value="Alterar"
							action="#{vendedorBacking.alteraVendedor}">
							<f:setPropertyActionListener value="#{vendedor}"
								target="#{vendedorBacking.vendedorSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
			</center>

			<rich:datascroller align="center" for="listaVendedor" maxPages="20"
				page="#{vendedorBacking.scrollerPage}" id="sc2"
				reRender="listaVendedor" />

			<center>
				<h:panelGrid columns="3">
					<h:commandButton value="Cancelar"
						action="#{vendedorBacking.cancelar}" />
				</h:panelGrid>
			</center>

		</h:form>

	</f:view>

</body>
</html>