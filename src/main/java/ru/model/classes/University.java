package ru.model.classes;

import com.google.gson.annotations.SerializedName;
import ru.model.enums.StudyProfile;

public class University {
    @SerializedName("Код университета")
    private String id;

    @SerializedName("Полное название университета")
    private String fullName;

    @SerializedName("Краткое название университета")
    private String shortName;

    @SerializedName("Год основания")
    private int yearOfFoundation;

    @SerializedName("Направление подготовки")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile + " (" + mainProfile.getProfileName() + ")}";
    }
}
