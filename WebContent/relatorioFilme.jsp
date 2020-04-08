<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 

<html>
<head>
<link href="css/config.css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatório de Filme</title>
<script type="text/javascript">
    function visualizarRelatorio() {        
        enviar("visualizar");        
    }

 

    function gerarRelatorioPDF() {        
        enviar("pdf");
    }

 

    function enviar(acao) {
        document.forms[0].acao.value = acao;
        document.forms[0].target = "_blank";
        document.forms[0].action = "./RelatorioFilmeServlet";
        document.forms[0].submit();
    }
</script>
</head>
<body class="background_Relatorio">
	<div  class="panel_cadastro">
<center>
<h3>Relatório de Filmes</h3>


<form action="./RelatorioServlet" method="post" onsubmit="return false;">
    <input type="hidden" name="acao" />    
    <input type="submit" value="Visualizar Relatorio" onclick="javascript:visualizarRelatorio();">
    <input type="submit" value="Gerar Relatório PDF" onclick="javascript:gerarRelatorioPDF();">    

	</form>
	<br>
	<form action="index.jsp">
		<input type="submit" value="Voltar">
	</form>
	</div>
	</center>
 

</body>
</html>