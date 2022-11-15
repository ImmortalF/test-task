package org.balkovyy;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class IDateSorterImpl implements IDateSorter {

    //Predicate that recognize months without letter "r"
    public final Predicate<LocalDate> MONTHS_WITHOUT_R = localDate -> !localDate.getMonth().name().contains("R");

    //Comparator to set condition: month without "r" goes in unnatural order, else goes in natural order
    public final Comparator<LocalDate> R_MONTH_ASC_NO_R_MONTH_DESC = Comparator.comparing(MONTHS_WITHOUT_R::test)
            .thenComparingLong(localDate -> MONTHS_WITHOUT_R.test(localDate) ? (-1) * localDate.toEpochDay() : localDate.toEpochDay());

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        return unsortedDates.stream().sorted(R_MONTH_ASC_NO_R_MONTH_DESC).toList();
    }
}
