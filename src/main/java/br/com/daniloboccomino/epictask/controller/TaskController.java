package br.com.daniloboccomino.epictask.controller;

import br.com.daniloboccomino.epictask.model.Task;
import br.com.daniloboccomino.epictask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TaskController {

    public static final String TASK = "task";
    public static final String TASK_NEW = "tasknew";

    @Autowired
    private TaskRepository repository;

    @GetMapping("/task")
    public ModelAndView index() {
        return new ModelAndView(TASK).addObject("tasks", repository.findAll());
    }

    @GetMapping("/task/new")
    public String newTask(Task task) {
        return TASK_NEW;
    }

    @PostMapping("/task")
    public String create(@Valid Task task, BindingResult result) {
        if (result.hasErrors()) return TASK_NEW;
        repository.save(task);
        return TASK;
    }

}