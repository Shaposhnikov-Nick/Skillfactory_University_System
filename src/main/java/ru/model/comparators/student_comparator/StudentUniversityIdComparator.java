package ru.model.comparators.student_comparator;

import org.apache.commons.lang3.StringUtils;
import ru.model.classes.Student;
import ru.model.interfaces.StudentComparator;

public class StudentUniversityIdComparator  implements StudentComparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
