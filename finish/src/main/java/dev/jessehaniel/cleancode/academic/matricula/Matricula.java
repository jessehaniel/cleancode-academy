package dev.jessehaniel.cleancode.academic.matricula;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jessehaniel Uso de Lombok para reduzir o código escrito. Como Matricula é usado em HashSet é obrigatório
 * implementar hashCode/equals. O Lombok ajuda permitindo definir quais campos devem ser considerados. Além disso, a
 * anotação {@link lombok.Builder} implementa o padrão BuilderPattern, facilitando a criação de objetos de acordo com as
 * necessidades.
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
public class Matricula {
    
    @Include
    private String alunoNome;
    @Include
    private String cursoNome;
    private boolean ativa = true;
    private boolean pagamentoEmDia = true;
    
}



