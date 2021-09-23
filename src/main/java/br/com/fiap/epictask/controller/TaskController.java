package br.com.fiap.epictask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;

@Controller // determina a classe como Controller para mapeamento de rotas
public class TaskController {
	
	@Autowired
	private TaskRepository repository;

	// metodo de retorno da pagina index da rota de tasks
	@GetMapping("/tasks") // define a rota que chama a pagina
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("tasks"); // nome do arquivo html que deve ser renderizado (resources/templates/tasks.html)
		List<Task> tasks = repository.findAll();
		modelAndView.addObject("tasks", tasks); // objeto renderizado na view
		return modelAndView;
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
 