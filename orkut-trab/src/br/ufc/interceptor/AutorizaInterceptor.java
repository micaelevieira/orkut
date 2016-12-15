package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizaInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response, 
							Object handler) throws Exception {
		String uri = request.getRequestURI();
		
		if(uri.endsWith("loginFormulario") || uri.endsWith("login") || uri.contains("resources") || uri.endsWith("inserirUsuarioFormulario") || uri.endsWith("inserirUsuario")){
			return true;
		}
		
		if(request.getSession().getAttribute("usuario_logado")!=null){
			return true;
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}

}
