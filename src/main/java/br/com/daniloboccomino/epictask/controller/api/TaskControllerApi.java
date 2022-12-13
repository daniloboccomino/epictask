package br.com.daniloboccomino.epictask.controller.api;

import br.com.daniloboccomino.epictask.model.Task;
import br.com.daniloboccomino.epictask.repository.TaskRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController // todos os métodos serão @ResponseBody
@RequestMapping("/api/task")
public class TaskControllerApi {

    @Autowired
    private TaskRepository repository;

    @GetMapping
    public Page<Task> index(@RequestParam(required = false) String description, @PageableDefault(size = 10) Pageable pageable) {
        return description == null ?
                repository.findAll(pageable) :
                repository.findByDescriptionLikeIgnoreCase("%" + description + "%", pageable);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody @Valid Task task, UriComponentsBuilder builder) {
        repository.save(task);
        URI uri = builder.path("/api/task/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(task);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {
        if (repository.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> update(@RequestBody @Valid Task newTask, @PathVariable Long id) {
        if (repository.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        Task task = repository.findById(id).get();
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setPoints(newTask.getPoints());
        repository.save(task);
        return ResponseEntity.ok(task);
    }

}