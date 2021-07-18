package ru.model;

import ru.model.classes.Student;
import ru.model.classes.University;
import ru.model.comparators.ComparatorUtil;
import ru.model.enums.StudentComparatorType;
import ru.model.enums.UniversityComparatorType;
import ru.model.interfaces.StudentComparator;
import ru.model.interfaces.UniversityComparator;
import ru.model.io.XlsxReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //считываем данные о студентах и выводим в консоль
        try {
            List<Student> students = XlsxReader.readXlsStudents();
            StudentComparator studentComparator = ComparatorUtil
                    .getStudentComparator(StudentComparatorType.STUDENT_NAME);

            students.stream()
                    .sorted(studentComparator)
                    .forEach(System.out::println);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        //считываем данные об университетах и выводим в консоль
        try {
            List<University> universities = XlsxReader.readXlsUniversities();
            UniversityComparator universityComparator = ComparatorUtil
                    .getUniversityComparator(UniversityComparatorType.UNIVERSITY_YEAR_OF_FOUNDATION);

            universities.stream()
                    .sorted(universityComparator.reversed())
                    .forEach(System.out::println);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
