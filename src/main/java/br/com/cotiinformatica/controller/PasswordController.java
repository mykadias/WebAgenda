package br.com.cotiinformatica.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.messages.MailMessage;
import br.com.cotiinformatica.models.PasswordModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class PasswordController {

	@RequestMapping(value = "/password")
	public ModelAndView password() {

		ModelAndView modelAndView = new ModelAndView("password"); // WEB-INF/views/password.jsp
		modelAndView.addObject("model", new PasswordModel());

		return modelAndView;

	}

	@RequestMapping(value = "/recuperar-senha", method = RequestMethod.POST)
	public ModelAndView recuperarSenha(PasswordModel model) {

		ModelAndView modelAndView = new ModelAndView("password");

		try {
			// pesquisar o usuário no banco de dados atraves do email informado
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(model.getEmail());

			if (usuario != null) {

				// criando uma nova senha para o usuário
				String novaSenha = getNewPassword();

				// atualizar a senha do usuário no banco de dados
				usuarioRepository.update(usuario.getIdUsuario(), novaSenha);

				// definindo os dados da mensagem
				String to = usuario.getEmail();
				String subject = "Recuperação de senha - WebAgenda";
				String body = "Olá" + usuario.getNome() + "\n\n" + "Sua nova senha de acesso é: " + novaSenha
						+ "\n\nUtilize esta senha para acessar o sistema e depois, caso desejar, altere para uma senha"
						+ "de sua preferência atráves do menu 'Minha Conta' do sistema" + "\n\n"
						+ "Att\n Equipe WebAgenda";

				// enviando a mensagem
				MailMessage.sendMessage(to, subject, body);

				modelAndView.addObject("mensagem_sucesso",
						"Uma nova senha foi enviada com sucesso para o email " + usuario.getEmail());

			} else {
				throw new Exception("Email inválido. Usuário não encontrado.");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("model", model);
		return modelAndView;
	}

	// método para gerar uma nova senha para o usuário
	public String getNewPassword() {
		return String.valueOf(new Random().nextInt(999999999));
	}
}
