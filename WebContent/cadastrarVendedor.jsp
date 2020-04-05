<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>    
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" contet ="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Cadastro de Vendedor</title>
</head>
<body>

	<f:view>
	
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<div align="center" style="width: 100%">
			<h1>Cadastro de Vendedor</h1>

			<div align="right" style="width: 50%">
			
			
			<h:panelGrid columns="5">
				<h:outputText value="Nome: " />
				<h:inputText value="#{vendedorBacking.nome}" maxlength="50" size="50"   
								onkeyup="masc_letras(this)" />
				<div style="width: 1px"/>
				<h:outputText value=" Area de Venda: " />
				<h:inputText value="#{vendedorBacking.areaVenda}" maxlength="50" size="20" 
								onkeyup="aNumerico(this)"/>
			</h:panelGrid>
			
			<h:panelGrid columns="6">
				<h:outputText value="Cidade:" />
				<h:inputText value="#{vendedorBacking.cidade}" maxlength="10" size="20"  
								onkeyup="masc_letras(this)" />
				<h:outputText value="Estado:" />
				<h:inputText value="#{vendedorBacking.estado}" maxlength="10" size="20"  
								onkeyup="masc_letras(this)" />
				<h:outputText value="Sexo: "/>
				<h:selectOneRadio value="#{vendedorBacking.sexo}">
					<f:selectItem itemValue="F" itemLabel="Feminino"/>
					<f:selectItem itemValue="M" itemLabel="Masculino"/>
				</h:selectOneRadio>	
			</h:panelGrid>
			
			
			<h:panelGrid columns="5">
				<h:outputText value="Idade: " />
				<h:inputText value="#{vendedorBacking.idade}" maxlength="10" size="20" 
								onkeyup="masc_numero(this)"/>
				<h:outputText value="Salário: " />
				<h:inputText value="#{vendedorBacking.salario}" maxlength="10" size="20" 
								onkeyup="masc_moeda(this)"/>
				<div style="width: 226px"/>
			</h:panelGrid>
			
				<div style="width: 100%" align="center">
				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{vendedorBacking.salvar}"/>
					<h:commandButton value="Cancelar" action="#{vendedorBacking.cancelar}"/>
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