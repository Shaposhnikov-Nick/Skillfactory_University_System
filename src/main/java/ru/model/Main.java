package ru.model;

import ru.model.classes.Student;
import ru.model.classes.University;
import ru.model.io.XlsxWriter;
import ru.model.statistics.Statistics;
import ru.model.util.ComparatorUtil;
import ru.model.enums.StudentComparatorType;
import ru.model.enums.UniversityComparatorType;
import ru.model.interfaces.StudentComparator;
import ru.model.interfaces.UniversityComparator;
import ru.model.io.XlsxReader;
import ru.model.util.StatisticsUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = null;
        List<University> universities = null;

        //считываем данные о студентах и выводим в консоль
        System.out.println("Считываем из Excel-файла данные о студентах:");
        try {
            students = XlsxReader.readXlsStudents();
            StudentComparator studentComparator = ComparatorUtil
                    .getStudentComparator(StudentComparatorType.STUDENT_NAME);

            students.stream()
                    .sorted(studentComparator)
                    .forEach(System.out::println);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println();


        //считываем данные об университетах и выводим в консоль
        System.out.println("Считываем из Excel-файла данные об университетах:");

        try {
            universities = XlsxReader.readXlsUniversities();
            UniversityComparator universityComparator = ComparatorUtil
                    .getUniversityComparator(UniversityComparatorType.UNIVERSITY_YEAR_OF_FOUNDATION);

            universities.stream()
                    .sorted(universityComparator.reversed())
                    .forEach(System.out::println);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println();

        /*
        // сериализация коллекций
        System.out.println("Сериализация коллекции университетов в Json");
        String universityJson = JsonUtil.SerializedCollectionUniversity(universities);
        System.out.println(universityJson + "\n");

        System.out.println("Сериализация коллекции студентов в Json");
        String studentJson = JsonUtil.SerializedCollectionStudents(students);
        System.out.println(studentJson);

        // десериализация строк

        List<University> universityFromJson = JsonUtil.DeserializeCollectionUniversity(universityJson);
        List<Student> studentFromJson = JsonUtil.DeserializeCollectionStudents(studentJson);
        System.out.println();

        // сравнение элементов в исходной и десериализованной колекциях

        if ((students.size() == studentFromJson.size()) && (universities.size() == universityFromJson.size()))
            System.out.println("Размеры коллекций равны!\n");
        else System.out.println("Ошибка при сериализации!\n");

        // сериализация отдельных элементов коллекций с помощью Stream API
        System.out.println("Сериализация  и десериализация отдельных элементов коллекции students с помощью Stream API");
        students.stream()
                //фильтруемся по студентам 3 курса
                .filter(student -> (student.getCurrentCourseNumber() == 3))
                .forEach(student -> {
                    // создаем json из каждого  элемента
                    String studentToJsonStream = JsonUtil.SerializeStudentToJson(student);
                    System.out.println(studentToJsonStream + "\n");
                    // десериализация
                    Student studentFromJsonStream = JsonUtil.DeserializeStudentFromJson(studentToJsonStream);
                    System.out.println(studentFromJsonStream + "\n");
                });

        System.out.println("Сериализация  и десериализация отдельных элементов коллекции universities с помощью " +
                "Stream API");
        universities.stream()
                // фильтр по специальности
                .filter(university -> university.getMainProfile().getProfileName().equals(StudyProfile.MEDICINE
                        .getProfileName()))
                // создаем json из каждого  элемента
                .forEach(university -> {
                    String universityToJsonString = JsonUtil.SerializeUniversityToJson(university);
                    System.out.println(universityToJsonString);
                    // десериализация
                    University universityFromJsonStream = JsonUtil.DeserializeUniversityFromJson(universityToJsonString);
                    System.out.println(universityFromJsonStream);
                });
         */

        // создание статистики

        List<Statistics> statistics = StatisticsUtil.createStatics(universities,students);
        XlsxWriter.createStatisticSheet(statistics);
    }
}
