package ru.model.builder;

import ru.model.classes.Student;

public class StudentBuilder {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public StudentBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public StudentBuilder setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public StudentBuilder setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public StudentBuilder setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public Student createStudent() {
        return new Student(fullName, universityId, currentCourseNumber, avgExamScore);
    }
}