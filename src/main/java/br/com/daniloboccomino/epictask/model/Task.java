package br.com.daniloboccomino.epictask.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @NotBlank(message = "Title is required") // != null && != "" && != " "
    private String title;

    @Size(min = 3, message = "Description must contain at least 3 characters")
    private String description;

    @Min(value = 10, message = "The minimum score is 10")
    @Max(value = 100, message = "The maximum score is 100")
    private int points;

}