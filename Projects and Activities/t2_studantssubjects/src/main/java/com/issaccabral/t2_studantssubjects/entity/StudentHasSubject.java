package com.issaccabral.t2_studantssubjects.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "student_has_subject")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class StudentHasSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter private int id;

    @Column(name = "student_id") // nome da coluna lá na tabela
    @Getter @Setter @NonNull private int studentId;
    @Column(name = "subject_id")
    @Getter @Setter @NonNull private int subjectId;

    @ManyToOne
    @JoinColumn(name="student_id", insertable=false, updatable=false)
    @Getter @Setter private Student student;

    @ManyToOne
    @JoinColumn(name="subject_id", insertable=false, updatable=false)
    @Getter @Setter private Subject subject;
}
