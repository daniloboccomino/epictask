package br.com.daniloboccomino.epictask.repository;

import br.com.daniloboccomino.epictask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}