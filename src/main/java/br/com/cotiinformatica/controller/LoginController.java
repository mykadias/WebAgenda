package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.models.LoginModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class LoginController {
	
//m�todo para mapear a navega��o da p�gina de login, esse m�todo diz ao controller qual p�gina que ele vai gerenciar.
//RequestMapping informa o endere�o da p�gina no navegador, como est� representado por um valor "/", significa que vai ser 
//p�gina raiz	
	@RequestMapping(value = "/")
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView("login"); //WEB-INF//views/login.jsp
		
		modelAndView.addObject("model", new LoginModel());
		return modelAndView;
	}
	
	//m�todo para receber o SUBMIT POST do formul�rio
	
	@RequestMapping(value = "/login-user", method = RequestMethod.POST) //a��o do formul�rio
	public ModelAndView loginUser(LoginModel model) {
		
		ModelAndView modelAndView = new ModelAndView("login"); //WEB-INF//views/login.jsp
		
		try {
			//consultar o usu�rio no banco de dados atrav�s do email e senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(model.getEmail(), model.getSenha());
			
			if (usuario != null) { //usu�rio encontrado
				//redirecionamento
				modelAndView.setViewName("redirect:tarefas-consulta");
				
			}
			else { //usu�rio n�o foi encontrado
				modelAndView.addObject("mensagem_erro", "Acesso negado, email ou senha inv�lidos.");
			}
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Ocorreu um erro"+ e.getMessage());
		}
		
		
		
		modelAndView.addObject("model", new LoginModel());
		return modelAndView;
	}
}
