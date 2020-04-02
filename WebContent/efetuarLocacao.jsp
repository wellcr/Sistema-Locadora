<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>    
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>  
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" contet ="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Efetuar Locação</title>
</head>
<body>
	<f:view>
		<jsp:include page="/menu.jsp" />
			<h:form>
				<h1>Efetuar locação</h1>
				<h:panelGrid columns="1">
					<h:messages />
				</h:panelGrid>
				
				<h:panelGrid>
					<h:outputText value="Cliente" />
					<rich:comboBox id="cliente">
						<f:selectItem  itemValue="Jose"/>
					
					</rich:comboBox>
									
				</h:panelGrid>
				
				
				
			</h:form>
	
	
	</f:view>
</body>
</html>