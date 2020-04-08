<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="http://localhost:8080/Sistema_Locadora/images/favicon-16x16.png" />
<link href="css/config.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Locadora</title>
</head>
<body class="background_menu">

	<div>

		<f:subview id="view">

			<h:form id="menu">

				<rich:toolBar>

					<rich:dropDownMenu value="Cadastro">

						<rich:menuItem id="menu1" value="Filme"
							action="#{filmeBacking.cadastraFilme}">
						</rich:menuItem>

						<rich:menuItem id="menu2" value="Cliente"
							action="#{clienteBacking.cadastraCliente}">
						</rich:menuItem>

						<rich:menuItem id="menu3" value="Vendedor"
							action="#{vendedorBacking.cadastraVendedor}">
						</rich:menuItem>

					</rich:dropDownMenu>

					<rich:dropDownMenu value="Consulta">

						<rich:menuItem id="menu4" value="Filme"
							action="#{filmeBacking.consultaFilme}">
						</rich:menuItem>

						<rich:menuItem id="menu5" value="Cliente"
							action="#{clienteBacking.consultaCliente}">
						</rich:menuItem>

						<rich:menuItem id="menu6" value="Vendedor"
							action="#{vendedorBacking.consultaVendedor}">
						</rich:menuItem>

						<rich:menuItem id="menu7" value="Locação"
							action="#{locacaoBacking.consultarLocacao}">
						</rich:menuItem>

					</rich:dropDownMenu>

					<rich:dropDownMenu value="Locação">

						<rich:menuItem id="menu8" value="Efetuar Locação"
							action="#{locacaoBacking.efetuarLocacao}">
						</rich:menuItem>


						<rich:menuItem id="menu9" value="Efetuar devolução"
							action="#{locacaoBacking.efetuarDevolucao}">
						</rich:menuItem>

					</rich:dropDownMenu>

					<rich:dropDownMenu value="Relatórios">

						<rich:menuItem id="menu10" value="Cliente" 
							action="#{relatorioBacking.relatorioCliente}">
						</rich:menuItem>
						
						<rich:menuItem id="menu11" value="Filme"  
							action="#{relatorioBacking.relatorioFilme}">
						</rich:menuItem>

						<rich:menuItem id="menu12" value="Vendedor"
							action="#{relatorioBacking.relatorioVendedor}" >
						</rich:menuItem>

						<rich:menuItem id="menu13" value="Locação"
							action="#{relatorioBacking.relatorioLocacao}" >
						</rich:menuItem>
						

					</rich:dropDownMenu>

				</rich:toolBar>

			</h:form>

		</f:subview>

	</div>

</body>
</html>