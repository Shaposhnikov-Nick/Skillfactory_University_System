package ru.model.classes;

import com.google.gson.annotations.SerializedName;
import ru.model.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("UniversityID")
    @XmlElement(name = "UniversityID")
    private String id;

    @SerializedName("UniversityFullName")
    @XmlElement(name = "UniversityFullName")
    private String fullName;

    @SerializedName("UniversityShortName")
    @XmlElement(name = "UniversityShortName")
    private String shortName;

    @SerializedName("YearOfFoundation")
    @XmlElement(name = "YearOfFoundation")
    private int yearOfFoundation;

    @SerializedName("StudyProfile")
    @XmlElement(name = "StudyProfile")
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
