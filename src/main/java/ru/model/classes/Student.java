package ru.model.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Student {
    @SerializedName("ФИО")
    private String fullName;

    @SerializedName("Код университета")
    private String universityId;

    @SerializedName("Курс")
    private int currentCourseNumber;

    @SerializedName("Средний балл успеваемости")
    private float avgExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return currentCourseNumber == student.currentCourseNumber && Float.compare(student.avgExamScore, avgExamScore)
                == 0 && Objects.equals(fullName, student.fullName) && Objects.equals(universityId, student.universityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, universityId, currentCourseNumber, avgExamScore);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}
