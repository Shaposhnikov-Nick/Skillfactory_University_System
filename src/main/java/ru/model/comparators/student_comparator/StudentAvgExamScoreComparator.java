package ru.model.comparators.student_comparator;

import ru.model.classes.Student;
import ru.model.interfaces.StudentComparator;

public class StudentAvgExamScoreComparator implements StudentComparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
