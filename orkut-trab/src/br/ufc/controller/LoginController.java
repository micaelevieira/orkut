package br.ufc.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Usuario;
import br.ufc.util.LoginUtil;

@Transactional
@Controller
public class LoginController {

	@Autowired
	@Qualifier(value = "usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;
	
	//Redirecionando para formulario de login
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";	
	}
	
	//BOTÃO OK DO LOGIN
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session){
		
		Usuario u = usuarioDAO.recuperar(usuario.getLogin());
		
		if (u!=null){
			LoginUtil l = new LoginUtil();
			String hashSenha = l.gerarHash(usuario.getSenha());
			
			if(u.getSenha().equals(hashSenha)){
				//colocando na sessão o usuario u
				session.setAttribute("usuario_logado", u);
				return "usuarios/home";
			}
		}
		return "redirect:loginFormulario";
		
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginFormulario";
		
	}
	
	
	@RequestMapping("/recuperarSenhaFormulario")
	public String recuperarSenhaFormulario(){
		
		return "usuarios/recuperar_senha_formulario";
	}
	
	@RequestMapping("/recuperarSenha")
	public String recuperarSenha(String login, Model model){
		
		Usuario usuario = usuarioDAO.recuperar(login);
		String comando = "python /usr/local/bin/recuperar.py ";
		comando += '"'+ usuario.getNome() + '"';
		comando += " "+ usuario.getEmail() + " ";
		
		String novaSenha = Long.toHexString(Double.doubleToLongBits(Math.random()));
		comando += " "+ novaSenha + " ";

		LoginUtil l = new LoginUtil();
		usuario.setSenha(l.gerarHash(novaSenha));
		usuarioDAO.alterar(usuario);
		
		model.addAttribute("email", usuario.getEmail());

		try {
			Process p = Runtime.getRuntime().exec(comando);
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
		return "usuarios/email_enviado";
	}

}
