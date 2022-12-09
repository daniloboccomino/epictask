package br.com.daniloboccomino.epictask.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
o projeto Lombok facilita a criação/uso de códigos na classe da entidade
subistituir todos os métodos get e set dos atributos pelas anotações @Getter e @Setter
se todos os atributos possuirem os metodos get e set, a classe recebe as anotações @Getter e @Setter
a classe ainda pode receber as anotações @AllArgsConstructor, @ToString e @EqualsAndHashCode
 */
@Data // substitui o uso de todas as outras anotações
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int points;

}