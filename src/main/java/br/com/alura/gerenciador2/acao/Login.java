package br.com.alura.gerenciador2.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador2.modelo.Banco;
import br.com.alura.gerenciador2.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando com o usu?rio(a) " + login);
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("Usu?rio existe");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
	}
}
