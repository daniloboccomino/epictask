package br.com.fiap.epictask.model;

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
public class Task {
	
	private String title;
	private String description;
	private int points;
	
}
