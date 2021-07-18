package ru.model.comparators;

import ru.model.comparators.student_comparator.*;
import ru.model.comparators.university_comparator.*;
import ru.model.enums.StudentComparatorType;
import ru.model.enums.UniversityComparatorType;
import ru.model.interfaces.StudentComparator;
import ru.model.interfaces.UniversityComparator;

public class ComparatorUtil {

    public ComparatorUtil() {
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        return switch (universityComparatorType) {
            case UNIVERSITY_ID -> new UniversityIdComparator();
            case UNIVERSITY_FULL_NAME -> new UniversityFullNameComparator();
            case UNIVERSITY_SHORT_NAME -> new UniversityShortNameComparator();
            case UNIVERSITY_MAIN_PROFILE -> new UniversityMainProfileComparator();
            case UNIVERSITY_YEAR_OF_FOUNDATION -> new UniversityYearOfFoundationComparator();
        };
    }

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        return switch (studentComparatorType) {
            case STUDENT_NAME -> new StudentNameComparator();
            case STUDENT_UNIVERSITY -> new StudentUniversityIdComparator();
            case STUDENT_AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
            case STUDENT_CURRENT_COURSE_NUMBER -> new StudentCurrentCourseNumberComparator();
        };
    }
}