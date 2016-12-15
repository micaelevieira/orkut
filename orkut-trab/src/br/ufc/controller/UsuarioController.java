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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.IAmizadeDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.form.AmizadeCheckboxForm;
import br.ufc.model.Amizade;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Controller
@Transactional
public class UsuarioController {

	@Autowired
	@Qualifier(value="usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	//@Qualifier(value="amizadeDAOHibernate")
	private IAmizadeDAO amizadeDAO;
	
	@Autowired
	private ServletContext context;
	
	//REDIRECIONAR PARA FORMULÁRIO DE CADASTRO
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){
		return "inserir_usuario_formulario";
	}
	
	//INSERIR USUARIO NO SISTEMA, BOTÃO DE OK
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usuario, 
								@RequestParam(value="image", required=false)MultipartFile image){
		
		if (image!=null && !image.isEmpty()){
			String path = context.getRealPath("/");
			path+="/resources/images/"+usuario.getLogin()+".png";
			AulaFileUtil.saveFile(path, image);
		}
		
		Usuario u = usuarioDAO.recuperar(usuario.getLogin());
		if (u==null){
			usuarioDAO.inserir(usuario);
			return "login_formulario";
		}
		return "usuarios/login_existente";
		
	}
	
	@RequestMapping("/encontrarAmigos")
	public String encontrarAmigos(HttpSession session ,Model model){
		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		List<Usuario> potenciaisAmigos = usuarioDAO.listar();
		potenciaisAmigos.remove(usuario);//removendo eu mesmo da lista
		
		AmizadeCheckboxForm acf = new AmizadeCheckboxForm();
		List<Amizade> minhasAmizades = this.amizadeDAO.listarAmizadeId(usuario.getUsuId());
		if (minhasAmizades != null && minhasAmizades.size()>0){
			//Long[] vetorIds = new Long[minhasAmizades.size()];
			//int i = 0;
			for(Amizade amizade:minhasAmizades){
				Long amigoId = amizade.getUsuarioAlvo().getUsuId();
				Usuario amigoTemp = new Usuario();
				amigoTemp.setUsuId(amigoId);
				potenciaisAmigos.remove(amigoTemp);
				//vetorIds[i] = amigoId;
				//i++;
			}
			//acf.setAmigos(vetorIds);
		}
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("potenciais_amigos", potenciaisAmigos);
		model.addAttribute("amizade", acf);
		return "usuarios/encontrar_amigos";
		
	}
	
	@RequestMapping("/inserirAmizade")
	public String inserirAmizade(HttpSession session, AmizadeCheckboxForm amizades){
		
		Usuario amigoFonte = (Usuario)session.getAttribute("usuario_logado");
		
		for(Long id:amizades.getAmigos()){
			Usuario amigoAlvo = usuarioDAO.recuperar(id);
			Amizade amizade = new Amizade();
			amizade.setUsuarioFonte(amigoFonte);
			amizade.setUsuarioAlvo(amigoAlvo);
			amizadeDAO.inserir(amizade);
		}
		return "redirect:/encontrarAmigos";
		
	}
	@RequestMapping("/perfil/{usuId}")
	public String perfil(Model model, @PathVariable(value="usuId") Long usuId){
		Usuario usuario = usuarioDAO.recuperar(usuId);
		model.addAttribute("usuario", usuario);
		return "usuarios/perfil";
	}
}
	
