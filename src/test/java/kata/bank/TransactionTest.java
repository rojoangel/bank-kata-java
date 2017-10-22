package kata.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    @Mock
    private Printer printer;

    @Test
    public void printTo() throws Exception {
        LocalDate date = new DateParser().parse("01/04/2014");

        Transaction transaction = new Transaction(date, 1000.00);
        transaction.printTo(printer, 1010.00);

        verify(printer).printLine("01/04/2014 | 1000.00 | 1010.00");
    }
}