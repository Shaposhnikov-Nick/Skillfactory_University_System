package ru.model.statistics;

import ru.model.enums.StudyProfile;

import java.math.BigDecimal;

public class Statistics {
    private StudyProfile studyProfile; // профиль  образования
    private int numStudentsByProfile = 0; // количество студентов, обучающихся по профилю
    private int numUniversitiesByProfile = 0; // количество университетов по профилб
    private double avgExamScore = 0; // средний балл за экзамены
    private String universityName = ""; // имя университета

    public Statistics(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public int getNumStudentsByProfile() {
        return numStudentsByProfile;
    }

    public void setNumStudentsByProfile(int numStudentsByProfile) {
        this.numStudentsByProfile += numStudentsByProfile;
    }

    public int getNumUniversitiesByProfile() {
        return numUniversitiesByProfile;
    }

    public void setNumUniversitiesByProfile(int numUniversitiesByProfile) {
        this.numUniversitiesByProfile += numUniversitiesByProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName += universityName + ", ";
    }
}
