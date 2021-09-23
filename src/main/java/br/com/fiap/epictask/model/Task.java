package br.com.fiap.epictask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * para evitar ter todos os metodos construtores, get e set, to string, equals e hashcode
 * faz uso de anotacoes nos atributos
 * @Getter
 * @Setter
 * 
 * para evitar que fique repetitivo quando todos os atributos possuir todas as anotacoes
 * faz uso das anotacoes na classe
 * @Getter
 * @Setter
 * @AllArgsConstructor
 * @EqualsAndHashCode
 *  
 * @Data substitui todas essas anotacoes
 */

@Data
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Title must be fill")
	private String title;
	
	@Size(min=16, message = "Description must be at least 16 characters")
	private String description;
	
	@Min(value = 10, message = "Minimum score must be 10")
	@Max(value = 500, message = "Maximum score must be 500")
	private int points;
	
}
