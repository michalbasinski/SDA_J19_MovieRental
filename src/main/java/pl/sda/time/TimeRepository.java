package pl.sda.time;

import java.time.LocalDate;

public class TimeRepository {
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
