package ru.model;

import ru.model.classes.Student;
import ru.model.classes.University;
import ru.model.comparators.student_comparator.StudentAvgExamScoreComparator;
import ru.model.comparators.university_comparator.UniversityMainProfileComparator;
import ru.model.comparators.university_comparator.UniversityYearOfFoundationComparator;
import ru.model.io.XlsxReader;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //считываем данные о студентах и выводим в консоль
        try {
            List<Student> students = XlsxReader.readXlsStudents();

            Collections.sort(students, new StudentAvgExamScoreComparator().reversed());
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //считываем данные об университетах и выводим в консоль
        try {
            List<University> universities = XlsxReader.readXlsUniversities();
            Collections.sort(universities, new UniversityMainProfileComparator());
            for(University university : universities){
                System.out.println(university);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
