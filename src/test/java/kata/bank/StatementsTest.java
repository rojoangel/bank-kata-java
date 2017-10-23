package kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static kata.bank.DateParser.date;
import static kata.bank.TransactionBuilder.aTransaction;
import static org.junit.Assert.assertEquals;
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

    @Test
    public void should_print_lines_in_reverse_order() {
        statements.add(
                aTransaction()
                        .withDate(date("01/04/2014"))
                        .withAmount(1000.00)
                        .build(),
                1000.00);
        statements.add(
                aTransaction()
                        .withDate(date("02/04/2014"))
                        .withAmount(-100.00)
                        .build(),
                900.00);

        statements.printTo(printer);

        InOrder inOrder = Mockito.inOrder(printer);
        inOrder.verify(printer).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(printer).printLine("01/04/2014 | 1000.00 | 1000.00");

    }

    @Test
    public void should_have_zero_balance_when_empty() {
        assertEquals(0, statements.currentBalance(), 0.001);
    }

    @Test
    public void should_return_last_line_balance() {
        statements.add(
                aTransaction()
                        .withDate(date("01/04/2014"))
                        .withAmount(1000.00)
                        .build(),
                1000.00);
        statements.add(
                aTransaction()
                        .withDate(date("02/04/2014"))
                        .withAmount(-100.00)
                        .build(),
                900.00);

        assertEquals(900, statements.currentBalance(), 0.001);
    }
}