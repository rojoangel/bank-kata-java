package kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementsTest {

    private Statements statements;

    @Mock
    private Printer printer;

    @Before
    public void init() {
        statements = new Statements();
    }

    @Test
    public void should_print_header() {
        statements.printTo(printer);
        verify(printer).printLine(Statements.HEADER);
    }

    public void should_print_deposit() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/04/2014", formatter);

        statements.add(new Transaction(date, 1000.00), 1000.00);
        statements.printTo(printer);
        verify(printer).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}