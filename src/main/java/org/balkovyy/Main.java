package org.balkovyy;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDateSorterImpl sorter = new IDateSorterImpl();

        List<LocalDate> unsortedDates = List.of(
                LocalDate.parse("2005-07-01"), LocalDate.parse("2005-01-02"),
                LocalDate.parse("2005-01-01"), LocalDate.parse("2005-05-03")
        );
        System.out.println(sorter.sortDates(unsortedDates));

    }
}