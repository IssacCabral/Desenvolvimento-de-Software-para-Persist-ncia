package com.issaccabral.t2_studantssubjects.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "studentByCpf", query = "select s from Student s where s.cpf = :cpf")
})

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter private int id;

    @Column(unique = true)
    @NonNull @Getter @Setter private String cpf;

    @Column(unique = true)
    @NonNull @Getter @Setter private String registration;

    @Column(unique = true)
    @NonNull @Getter @Setter private String email;

    @NonNull @Getter @Setter private String name;
    @NonNull @Getter @Setter private LocalDate bornDate;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter @Setter private List<StudentHasSubject> studentHasSubjects;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", registration='" + registration + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", bornDate=" + bornDate +
                '}';
    }
}
