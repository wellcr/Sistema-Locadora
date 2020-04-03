<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Locação</title>
</head>
<body>


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			
			
			<h:panelGrid columns="1" width="700">
				<rich:dataTable id="listaLocacao" width="100%" value="#{locacaoBacking.listaLocacao}" var="locacao" >
					
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
						<h:outputText value="#{locacao.nomeCliente}"/>
					</rich:column>
					<rich:column>
						<h:outputText value="#{locacao.nomeFilme}"/>
					</rich:column>
					<rich:column>
						<h:outputText value="#{locacao.data}"/>
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>
			
			<h:panelGrid columns="3">
					<h:commandButton value="Retornar" 
						action="#{locacaoBacking.retornar}"/>
					<h:commandButton value="Cancelar" 
						action="#{locacaoBacking.sair}"/>
					<h:commandButton value="Avançar" 
						action="#{locacaoBacking.avancar}"/>
			</h:panelGrid>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
		
		</h:form>
	</f:view>

</body>
</html>