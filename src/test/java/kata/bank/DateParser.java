package kata.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {

    public LocalDate parse(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}