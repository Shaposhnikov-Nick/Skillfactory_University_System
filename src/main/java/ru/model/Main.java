package ru.model;

import ru.model.Classes.Student;
import ru.model.Classes.StudyProfile;
import ru.model.Classes.University;
import ru.model.builder.StudentBuilder;
import ru.model.builder.UniversityBuilder;

public class Main {
    public static void main(String[] args) {
        // создаем объект student
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setFullName("Nick");
        studentBuilder.setCurrentCourseNumber(3);
        studentBuilder.setUniversityId("1");
        studentBuilder.setAvgExamScore(52556);

        Student student = studentBuilder.createStudent();
        System.out.println(student);

        // создаем объект university
        UniversityBuilder universityBuilder = new UniversityBuilder();
        universityBuilder.setId("1");
        universityBuilder.setFullName("Moscow State University");
        universityBuilder.setMainProfile(StudyProfile.COMPUTER_SCIENCE);
        universityBuilder.setShortName("MSU");
        universityBuilder.setYearOfFoundation(1755);

        University university = universityBuilder.createUniversity();
        System.out.println(university);


    }
}
