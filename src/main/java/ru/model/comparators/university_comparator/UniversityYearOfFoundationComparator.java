package ru.model.comparators.university_comparator;

import ru.model.classes.University;
import ru.model.interfaces.UniversityComparator;

public class UniversityYearOfFoundationComparator implements UniversityComparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
