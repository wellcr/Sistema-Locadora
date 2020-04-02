<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>    
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" contet ="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Altera��o de Filme</title>
</head>
<body>

	<f:view>
	
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<div align="center" style="width: 100%">
			<h1>Altera��o de Filme</h1>
			
			<div align="right" style="width: 50%">
			
			
			
			<h:panelGrid columns="4">
				<h:outputText value="Nome: " />
				<h:inputText value="#{filmeBacking.nome}" maxlength="50" size="50" disabled="true" />
				<h:outputText value="Genero: " />
				<h:inputText value="#{filmeBacking.genero}" maxlength="50" size="20" disabled="true" />
			</h:panelGrid>
			
			<h:panelGrid columns="5">
				<h:outputText value="Disponivel: " />
				<h:selectOneRadio value="#{filmeBacking.disponivel}">
					<f:selectItem itemValue="S" itemLabel="Sim"/>
					<f:selectItem itemValue="N" itemLabel="N�o"/>
				</h:selectOneRadio>	
				<div style="width: 216px"/>
				<h:outputText value="Valor: " />
				<h:inputText value="#{filmeBacking.valor}" maxlength="10" size="20"
									onkeyup="masc_moeda(this)"/>
			</h:panelGrid>
			
			
			<h:panelGrid columns="5">
				<h:outputText value="Promo��o: "/>
				<h:selectOneRadio value="#{filmeBacking.promocao}">
					<f:selectItem itemValue="S" itemLabel="Sim"/>
					<f:selectItem itemValue="N" itemLabel="N�o"/>
				</h:selectOneRadio>	
				<div style="width: 147px"/>
				<h:outputText value="Valor Promo��o: " />
				<h:inputText value="#{filmeBacking.valorPromocao}" maxlength="10" size="20" 
								onkeyup="masc_moeda(this)"/>
			</h:panelGrid>
			
				<div style="width: 100%" align="center">
				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{filmeBacking.alterar}"/>
					<h:commandButton value="Cancelar" action="#{filmeBacking.cancelar}"/>
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