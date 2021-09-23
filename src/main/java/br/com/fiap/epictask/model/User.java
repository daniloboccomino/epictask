package br.com.fiap.epictask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	
}
