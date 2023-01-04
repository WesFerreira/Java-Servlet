package br.com.alura.gerenciador2.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Banco;
import br.com.alura.gerenciador2.modelo.Empresa;


//@WebServlet("/novaEmpresa")
public class NovaEmpresaServelet extends HttpServlet {
	public static void main(String[] args) {
		
	}
	
	private static final long serialVersionUID = 1L;

	// Aceita método Get e Post
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		
		//Leitura
		
		String nomeEmpresa = request.getParameter("nome");
		String parametroDataAberturaEmpresa = request.getParameter("data");
		
		
		//Parsing
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(parametroDataAberturaEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		
		//População - populando
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adicioma(empresa);
		
		
		response.sendRedirect("listaEmpresas");
		
		
		//Chamar o JSP - mandando a requisição pra frente para chamar o jsp
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		//jogar um atributo dentro da requisição
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		
		
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso</html></body>");
		
		
	//Aceita APENAS o método Post
		
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Cadastrando nova empresa");
//		String nomeEmpresa = request.getParameter("nome");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso</html></body>");

		
	//Aceita APENAS o método Get
		
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Cadastrando nova empresa");
//		String nomeEmpresa = request.getParameter("nome");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso</html></body>");		
	}

}
