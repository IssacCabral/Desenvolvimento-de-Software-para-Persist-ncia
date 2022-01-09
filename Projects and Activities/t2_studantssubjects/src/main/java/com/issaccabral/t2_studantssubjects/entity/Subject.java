package com.issaccabral.t2_studantssubjects.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter private int id;

    @Column(unique = true)
    @NonNull private String code;

    @Column(unique = true)
    @NonNull private String name;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter @Setter private List<StudentHasSubject> studentHasSubjects;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
