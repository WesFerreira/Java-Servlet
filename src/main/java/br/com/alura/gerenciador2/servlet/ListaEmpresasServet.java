package br.com.alura.gerenciador2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Banco;
import br.com.alura.gerenciador2.modelo.Empresa;

//@WebServlet("/listaEmpresas")
public class ListaEmpresasServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
		
//		PrintWriter out = response.getWriter();
//
//		out.println("<html><body>");
//		out.println("<ul>");
//
//		for (Empresa empresa : lista) {
//			out.println("<li>" + empresa.getNome() + "</li>");
//		}
//		out.println("</ul>");
//		out.println("</html></body>");

	}

}
