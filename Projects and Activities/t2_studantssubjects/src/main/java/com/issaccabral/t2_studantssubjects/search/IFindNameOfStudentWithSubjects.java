package com.issaccabral.t2_studantssubjects.search;

import com.issaccabral.t2_studantssubjects.entity.StudentHasSubject;

import java.util.List;

public interface IFindNameOfStudentWithSubjects {
    String getName();
    List<StudentHasSubject> getStudentHasSubjects();
}
