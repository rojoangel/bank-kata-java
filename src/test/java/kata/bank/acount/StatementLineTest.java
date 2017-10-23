package kata.bank.acount;

import kata.bank.Printer;
import kata.bank.account.StatementLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static kata.bank.DateParser.date;
import static kata.bank.account.TransactionBuilder.aTransaction;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementLineTest {

    @Mock
    private Printer printer;

    @Test
    public void should_print_itself() throws Exception {

        StatementLine statementLine = new StatementLine(
                aTransaction()
                        .withDate(date("01/04/2014"))
                        .withAmount(1000.00)
                        .build(),
                1000.00
        );

        statementLine.printTo(printer);
        verify(printer).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}