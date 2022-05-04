package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
//método para mapear a navegação da página de login, esse método diz ao controller qual página que ele vai gerenciar.
//RequestMapping informa o endereço da página no navegador, como está representado por um valor "/", significa que vai ser 
//página raiz	
	@RequestMapping(value = "/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login"); //WEB-INF//views/login.jsp
		return modelAndView;
	}
}
