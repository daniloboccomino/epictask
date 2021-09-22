package br.com.fiap.epictask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // determina a classe como Controller para mapeamento de rotas
public class TaskController {

	// metodo de retorno da pagina index da rota de tasks
	@RequestMapping("/tasks") // define a rota que chama a pagina
	public String index() {
		return "tasks"; // nome do arquivo html que deve ser renderizado (resources/templates/tasks.html)
	}

	// metodo de retorno da pagina de cadastro da rota de tasks
	@RequestMapping("/tasks/new") // define a rota que chama a pagina
	public String create() {
		return "tasknew"; // nome do arquivo html que deve ser renderizado (resources/templates/tasknew.html)
	}

}
