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
	
//método para mapear a navegação da página de login, esse método diz ao controller qual página que ele vai gerenciar.
//RequestMapping informa o endereço da página no navegador, como está representado por um valor "/", significa que vai ser 
//página raiz	
	@RequestMapping(value = "/")
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView("login"); //WEB-INF//views/login.jsp
		
		modelAndView.addObject("model", new LoginModel());
		return modelAndView;
	}
	
	//método para receber o SUBMIT POST do formulário
	
	@RequestMapping(value = "/login-user", method = RequestMethod.POST) //ação do formulário
	public ModelAndView loginUser(LoginModel model) {
		
		ModelAndView modelAndView = new ModelAndView("login"); //WEB-INF//views/login.jsp
		
		try {
			//consultar o usuário no banco de dados através do email e senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(model.getEmail(), model.getSenha());
			
			if (usuario != null) { //usuário encontrado
				//redirecionamento
				modelAndView.setViewName("redirect:tarefas-consulta");
				
			}
			else { //usuário não foi encontrado
				modelAndView.addObject("mensagem_erro", "Acesso negado, email ou senha inválidos.");
			}
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Ocorreu um erro"+ e.getMessage());
		}
		
		
		
		modelAndView.addObject("model", new LoginModel());
		return modelAndView;
	}
}
