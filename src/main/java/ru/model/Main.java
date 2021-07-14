package ru.model;

import ru.model.Classes.Student;
import ru.model.Classes.University;
import ru.model.enums.StudyProfile;
import ru.model.builder.StudentBuilder;
import ru.model.builder.UniversityBuilder;
import ru.model.io.XlsxReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //считываем данные о студентах и выводим в консоль
        try {
            List<Student> students = XlsxReader.readXlsStudents();
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //считываем данные об университетах и выводим в консоль
        try {
            List<University> universities = XlsxReader.readXlsUniversities();
            for(University university : universities){
                System.out.println(university);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
