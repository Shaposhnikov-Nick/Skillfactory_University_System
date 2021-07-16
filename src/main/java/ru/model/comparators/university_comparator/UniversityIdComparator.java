package ru.model.comparators.university_comparator;

import org.apache.commons.lang3.StringUtils;
import ru.model.classes.University;
import ru.model.interfaces.UniversityComparator;

public class UniversityIdComparator implements UniversityComparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}
