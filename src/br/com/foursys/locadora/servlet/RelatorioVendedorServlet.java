package br.com.foursys.locadora.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.foursys.locadora.controller.VendedorController;
import br.com.foursys.locadora.vo.VendedorVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioVendedorServlet extends HttpServlet {
	private static final long serialVersionUID = 11;
	
	public RelatorioVendedorServlet() {
		super();
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<VendedorVO> vendedors = new VendedorController().retornaVendedores();
		
		try {
			
 

            String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");

 

            String caminhoJasper = getServletContext()
                    .getRealPath("/WEB-INF/classes/br/com/foursys/locadora/relatorio/") + "/";
            String caminho = getServletContext().getRealPath("/");

 

            JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(vendedors);
            
            Map parametros = new HashMap();
            parametros.put("titulo", "Relatorios de Vendedores");
            parametros.put(vendedors, jrDT);
            parametros.put("total", "Total de Vendedores: " + vendedors.size());
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "vendedores.jasper", parametros, jrDT);

 

            if ("visualizar".equals(acao)) {
                JasperViewer.viewReport(jasperPrint, false);
            } else if ("pdf".equals(acao)) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, caminho + "/RelatorioVendedor.pdf");
                response.sendRedirect("RelatorioVendedor.pdf");
            } else {
                response.sendRedirect("index.jsp");
            }

 

        } catch (JRException e) {
            e.printStackTrace();
        }
 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}
}
