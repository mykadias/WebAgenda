package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.models.RegisterModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class RegisterController {
	
	
	//Abrir a página
	@RequestMapping(value= "/register")
	public ModelAndView register() {
		
		ModelAndView modelAndView = new ModelAndView("register");
		
		//criando uma instância da classe modal e envia-la para a pagina
		modelAndView.addObject("model", new RegisterModel());
		
		return modelAndView;
	}
	
	//Recebe o submit do formulário
	@RequestMapping(value = "/register-user", method = RequestMethod.POST)
	public ModelAndView registerUser(RegisterModel model) {
		
		ModelAndView modelAndView = new ModelAndView("register");
		
		try {
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(model.getNome());
			usuario.setEmail(model.getEmail());
			usuario.setSenha(model.getSenha());
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			usuarioRepository.create(usuario);
			
			modelAndView.addObject("mensagem", "Usuário cadastrado com sucesso!");
			
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}
		
		modelAndView.addObject("model", new RegisterModel());
		return modelAndView;
	}
}
