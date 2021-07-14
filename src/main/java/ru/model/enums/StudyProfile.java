package ru.model.enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    BUILDING("Строительство"),
    ENERGETICS("Энергетика"),
    JURISPRUDENCE("Юриспруденция"),
    COMPUTER_SCIENCE("Компьютерные науки"),
    ECONOMY("Экономика"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика");

    private String profileName;

    StudyProfile(String profileName){
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
