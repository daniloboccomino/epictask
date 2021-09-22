package br.com.fiap.epictask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.epictask.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	// criar metodo seguindo regras do spring data jpa
	// spring monta a query de acordo com o nome do metodo e parametros
	// https://docs.spring.io/spring-data/jpa/docs/2.3.3.RELEASE/reference/html/#jpa.query-methods.query-creation
	
	List<Task> findByTitle(String title);

}
