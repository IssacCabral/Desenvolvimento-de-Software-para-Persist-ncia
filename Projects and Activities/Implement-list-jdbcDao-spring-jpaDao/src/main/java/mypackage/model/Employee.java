package mypackage.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Employee {
    @Getter @Setter private int id;
    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private Integer matricula;
    @NonNull @Getter @Setter private String nome;
    @NonNull @Getter @Setter private String email;
    @NonNull @Getter @Setter private String telefone;
}
