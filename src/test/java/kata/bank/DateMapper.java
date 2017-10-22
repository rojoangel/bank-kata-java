package kata.bank;

import cucumber.api.Transformer;

import java.time.LocalDate;

public class DateMapper extends Transformer<LocalDate> {

    private final DateParser dateParser = new DateParser();

    @Override
    public LocalDate transform(String date) {
        return dateParser.parse(date);
    }
}
