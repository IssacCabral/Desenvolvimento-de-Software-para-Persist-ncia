package com.issaccabral.t2_studantssubjects.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student_has_subject")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentHasSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter private int id;

    @Column(name = "student_id") // nome da coluna lá na tabela
    @NonNull private int studentId;
    @Column(name = "subject_id")
    @NonNull private int subjectId;

    @ManyToOne
    @JoinColumn(name="student_id", insertable=false, updatable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="subject_id", insertable=false, updatable=false)
    private Subject subject;
}
