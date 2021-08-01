package ru.model.util;

import ru.model.classes.Student;
import ru.model.classes.University;
import ru.model.enums.StudyProfile;
import ru.model.statistics.Statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;



public class StatisticsUtil {

    private StatisticsUtil() {
    }

    // получение параметров из коллекции университетов
    private static void setParameterToStatisticFromUniversity(Statistics statistics, University university) {
        statistics.setNumUniversitiesByProfile(1);
        statistics.setUniversityName(university.getFullName());
    }

    // получение параметров из коллекции студентов
    private static void setParameterToStatisticFromStudent(Statistics statistics, Student student) {
        statistics.setNumStudentsByProfile(1);
        statistics.setAvgExamScore(
                BigDecimal.valueOf(student.getAvgExamScore()).setScale(3, RoundingMode.HALF_UP).doubleValue());
    }

    // создание файла со стратистикой
    public static List<Statistics> createStatics(List<University> universities, List<Student> students) {
        // коллекция статистики
        List<Statistics> statistics = new ArrayList<>();

        // объекты статистики по профилям обучения
        Statistics medicineStatistic = new Statistics(StudyProfile.MEDICINE);
        Statistics physicsStatistic = new Statistics(StudyProfile.PHYSICS);
        Statistics linguisticsStatistic = new Statistics(StudyProfile.LINGUISTICS);
        Statistics mathematicsStatistic = new Statistics(StudyProfile.MATHEMATICS);

        // записываем данные статистики университетов
        universities
                .forEach(university -> {
                    switch (university.getMainProfile()) {
                        case MEDICINE -> setParameterToStatisticFromUniversity(medicineStatistic, university);
                        case PHYSICS -> setParameterToStatisticFromUniversity(physicsStatistic, university);
                        case LINGUISTICS -> setParameterToStatisticFromUniversity(linguisticsStatistic, university);
                        case MATHEMATICS -> setParameterToStatisticFromUniversity(mathematicsStatistic, university);
                    }
                });

        // записываем данные статистики  студентов
        students.stream()
                .forEach(student -> {
                    switch (student.getUniversityId()) {
                        case "0001-high", "0002-high" -> setParameterToStatisticFromStudent(physicsStatistic, student);
                        case "0003-high", "0004-high", "0005-high" -> setParameterToStatisticFromStudent(medicineStatistic, student);
                        case "0006-high" -> setParameterToStatisticFromStudent(linguisticsStatistic, student);
                        case "0007-high" -> setParameterToStatisticFromStudent(mathematicsStatistic, student);
                    }
                });

        // добавляем объекты в коллекцию
        statistics.add(medicineStatistic);
        statistics.add(physicsStatistic);
        statistics.add(linguisticsStatistic);
        statistics.add(mathematicsStatistic);

        return statistics;
    }
}
