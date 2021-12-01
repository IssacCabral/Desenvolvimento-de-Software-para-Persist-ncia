package mypackage.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private Integer matricula;
    @NonNull @Getter @Setter private String nome;
    @NonNull @Getter @Setter private String email;
    @NonNull @Getter @Setter private String telefone;
}
