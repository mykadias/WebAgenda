package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
//m�todo para mapear a navega��o da p�gina de login, esse m�todo diz ao controller qual p�gina que ele vai gerenciar.
//RequestMapping informa o endere�o da p�gina no navegador, como est� representado por um valor "/", significa que vai ser 
//p�gina raiz	
	@RequestMapping(value = "/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login"); //WEB-INF//views/login.jsp
		return modelAndView;
	}
}
