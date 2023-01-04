package br.com.alura.gerenciador2.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Banco;
import br.com.alura.gerenciador2.modelo.Empresa;

public class NovaEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
