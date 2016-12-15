package br.ufc.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.ICategoriaDAO;
import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IForumDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.dao.UsuarioDAOHibernate;
import br.ufc.model.Categoria;
import br.ufc.model.Comunidade;
import br.ufc.model.Forum;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class ComunidadeController {

	@Autowired
	@Qualifier(value = "comunidadeDAOHibernate")
	private IComunidadeDAO comunidadeDAO;

	@Autowired
	@Qualifier(value = "categoriaDAOHibernate")
	private ICategoriaDAO categoriaDAO;

	@Autowired
	private IForumDAO forumDAO;

	@Autowired
	private IUsuarioDAO usuarioDAO;
	@Autowired
	private ServletContext context;

	@RequestMapping("/comunidades")
	public String comunidades( Model model, HttpSession session){

		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		model.addAttribute("usuario", usuario);

		List<Comunidade> comunidades = comunidadeDAO.listar();
		model.addAttribute("comunidades",comunidades);
		return "comunidades/comunidades";

	}

	@RequestMapping("/inserirComunidadeFormulario")
	public String inserirComunidadeFormulario(Model model){
		//Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		//model.addAttribute("usuarios", usuario);
		List<Categoria> categorias = categoriaDAO.listar();

		model.addAttribute("categorias", categorias);

		return "comunidades/inserir_comunidade_formulario";
	}


	@RequestMapping("/inserirComunidade")
	public String inserirComunidade(Comunidade comunidade, Categoria categoria, 
			@RequestParam(value="image", required=false)MultipartFile image, HttpSession session){

		if (image!=null && !image.isEmpty()){
			String path = context.getRealPath("/");
			path+="/resources/images/"+comunidade.getNome()+".png";
			AulaFileUtil.saveFile(path, image);
		}

		//Adicionar usuario automaticamente na comunidade
		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		comunidade.setUsuario(usuarios);

		comunidade.setCategoria(categoria);
		comunidadeDAO.inserir(comunidade);
		return "redirect:comunidades";
	}

	@RequestMapping("/detalhesComunidade/{comuId}")
	public String detalhesComunidade(@PathVariable("comuId") Long comuId, Model model){
		Comunidade comunidade = comunidadeDAO.recuperar(comuId);
		model.addAttribute("comunidade", comunidade);
		return "comunidades/detalhes_comunidade";
	}

	@RequestMapping("/detalhesComunidade/criarForum")
	public String criarForum(Forum forum, Long comuId){
		Comunidade comunidade = comunidadeDAO.recuperar(comuId);
		forum.setComunidade(comunidade);
		forumDAO.inserir(forum);
		return "redirect:/detalhesComunidade/"+comunidade.getComuId();
	}
	@RequestMapping("/participarComunidade/{comuId}")
	public String participarComunidadeA(@PathVariable("comuId") Long comuId, HttpSession session){
		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		Comunidade comunidade = comunidadeDAO.recuperar(comuId);
		List<Usuario> usuarios = comunidade.getUsuario();

		usuarios.add(usuario);
		comunidade.setUsuario(usuarios);
		comunidadeDAO.atualizar(comunidade);
		return "comunidades/inserir_comunidade_ok";

	}

}
