package kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static kata.bank.DateParser.date;
import static kata.bank.TransactionBuilder.aTransaction;
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

    @Test
    public void should_print_line() {
        statements.add(
                aTransaction()
                        .withDate(date("01/04/2014"))
                        .withAmount(1000.00)
                        .build(),
                1000.00);
        statements.printTo(printer);
        verify(printer).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}