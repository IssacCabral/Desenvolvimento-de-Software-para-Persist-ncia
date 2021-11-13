package dspersist.model;

import lombok.*;

@NoArgsConstructor //Construtor sem parâmetros
@AllArgsConstructor //Construtor com todos os parâmetros
@ToString
public class Cidade {
    @Getter @Setter private Integer id;
    @Getter @Setter private String uf;
    @Getter @Setter private String nome;
}