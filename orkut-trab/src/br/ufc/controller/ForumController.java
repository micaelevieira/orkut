package br.ufc.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ICategoriaDAO;
import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IForumDAO;
import br.ufc.dao.IMensagemDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Comunidade;
import br.ufc.model.Forum;
import br.ufc.model.Mensagem;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ForumController {
	
	@Autowired
	private IComunidadeDAO comunidadeDAO;
	
	@Autowired
	@Qualifier(value = "categoriaDAOHibernate")
	private ICategoriaDAO categoriaDAO;
	
	@Autowired
	private IForumDAO forumDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private IMensagemDAO mensagemDAO;
	@Autowired
	private ServletContext context;

	@RequestMapping("/detalhesComunidade/detalhesForum/{comuId}/{forId}")
	public String detalhesForum(@PathVariable(value="comuId") Long comuId,@PathVariable(value="forId") Long forId, Model model, HttpSession session){
		//Usuario u = (Usuario) session.getAttribute("usuario_logado");
		Comunidade comunidade = comunidadeDAO.recuperar(comuId);
		Forum forum = forumDAO.recuperar(forId);
		
		//model.addAttribute("u", u);
		model.addAttribute("comunidade",comunidade);
		model.addAttribute("forum",forum);
		
		return "foruns/detalhes_forum";
	}
	
	/*@RequestMapping("/detalhesComunidade/{comuId}")
	public String detalhesComunidade(@PathVariable("comuId") Long comuId, Model model){
		Comunidade comunidade = comunidadeDAO.recuperar(comuId);
		model.addAttribute("comunidade", comunidade);
		return "comunidades/detalhes_comunidade";
	}*/
	
	
	
	@RequestMapping("/detalhesComunidade/detalhesForum/enviarMensagem/{comuId}/{forId}")
	public String enviarMensagem(Model model, @PathVariable(value="comuId") Long comuId, @PathVariable(value="forId") Long forId, Mensagem mensagem ,HttpSession session){
		System.out.println("->");
		Usuario usuario =   usuarioDAO.recuperar(((Usuario)session.getAttribute("usuario_logado")).getUsuId());
		System.out.println(usuario.getNome());
		
		Comunidade comunidade = comunidadeDAO.recuperar(comuId);
		Forum forum = forumDAO.recuperar(forId);
		mensagem.setUsuario(usuario);
		mensagem.setForum(forum);		
		mensagemDAO.inserir(mensagem);
		forum.addMensagem(mensagem);
		forumDAO.alterar(forum);
		model.addAttribute("comunidade", comunidade);
		model.addAttribute("forum", forum);
		return "redirect:/detalhesComunidade/detalhesForum/" + comunidade.getComuId() + "/" + forum.getForId();
	}
	
	
}
