package kata.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementLineTest {

    @Mock
    private Printer printer;

    @Test
    public void should_print_itself() throws Exception {
        LocalDate date = new DateParser().parse("01/04/2014");

        StatementLine statementLine = new StatementLine(
                new Transaction(date, 1000.00),
                1000.00
        );

        statementLine.printTo(printer);
        verify(printer).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}