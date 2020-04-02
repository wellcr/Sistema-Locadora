<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Cliente</title>
</head>
<body>


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		
		<h:form>
			
			
			
			<h:panelGrid columns="3">
				<h:outputText value="Nome: " />
				<h:inputText value="#{filmeBacking.nome}" maxlength="50" size="40" />
				<h:commandButton value="Pesquisar Filme" action="#{filmeBacking.pesquisar}" />
			</h:panelGrid>
			
			<h:panelGrid columns="1" width="700">
				<rich:dataTable id="listaCliente" width="100%" value="#{filmeBacking.listaFilme}" var="filme" >
					
					<f:facet name="caption">
						<h:outputText value="Lista de Filmes" />
					</f:facet>
					
					<f:facet name="header">
						<rich:columnGroup>
							<rich:column>
								<h:outputText value="Nome" />
							</rich:column>
							<rich:column>
								<h:outputText value="G�nero" />
							</rich:column>
							<rich:column>
								<h:outputText value="Valor" />
							</rich:column>
							<rich:column>
								<h:outputText value="Dispon�vel" />
							</rich:column>
							<rich:column>
								<h:outputText value="Promo��o" />
							</rich:column>
							<rich:column colspan="2">
								<h:outputText value="A��es" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>
					<rich:column>
						<h:outputText value="#{filme.nome}"/>
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.genero}"/>
					</rich:column>
					<rich:column>
						<h:outputText value="#{filmeBacking.valorTabela(filme)}"/>
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.disponivel}"/>
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.promocao}"/>
					</rich:column>
					<rich:column>
						<h:commandLink value="Excluir" action="#{filmeBacking.excluir}">
						<f:setPropertyActionListener value="#{filme}" 
							target="#{filmeBacking.filmeSelecionado}" />
						</h:commandLink>
					</rich:column>
					<rich:column>
						<h:commandLink value="Alterar" action="#{filmeBacking.alteraFilme}">
						<f:setPropertyActionListener value="#{filme}"
							target="#{filmeBacking.filmeSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>
			
			<h:panelGrid columns="3">
					<h:commandButton value="Retornar" 
						action="#{filmeBacking.retornar}"/>
					<h:commandButton value="Cancelar" 
						action="#{filmeBacking.cancelar}"/>
					<h:commandButton value="Avan�ar" 
						action="#{filmeBacking.avancar}"/>
			</h:panelGrid>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
		
		</h:form>
	</f:view>

</body>
</html>