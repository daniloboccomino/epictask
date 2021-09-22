package br.com.fiap.epictask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;

@Controller // determina a classe como Controller para mapeamento de rotas
public class TaskController {
	
	@Autowired
	private TaskRepository repository;

	// metodo de retorno da pagina index da rota de tasks
	@GetMapping("/tasks") // define a rota que chama a pagina
	public String index() {
		return "tasks"; // nome do arquivo html que deve ser renderizado (resources/templates/tasks.html)
	}
	
	@PostMapping("/tasks")
	public String save(Task task) {
		repository.save(task);
		return "tasks";
	}

	// metodo de retorno da pagina de cadastro da rota de tasks
	@RequestMapping("/tasks/new") // define a rota que chama a pagina
	public String create() {
		return "tasknew"; // nome do arquivo html que deve ser renderizado (resources/templates/tasknew.html)
	}

}
 