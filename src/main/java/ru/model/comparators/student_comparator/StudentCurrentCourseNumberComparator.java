package ru.model.comparators.student_comparator;

import ru.model.classes.Student;
import ru.model.interfaces.StudentComparator;

public class StudentCurrentCourseNumberComparator implements StudentComparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
