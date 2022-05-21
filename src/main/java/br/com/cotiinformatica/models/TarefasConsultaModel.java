package br.com.cotiinformatica.models;

import lombok.Getter;
import lombok.Setter;

//A model é para codificar pensando na View (quais campos o usuario vai preencher(ou somente "aparecer" na tela, como o id
//que aparece, mas o usuariio não preenche) na view?
@Getter
@Setter
public class TarefasConsultaModel {
	
	private String nome;
	
	
}
