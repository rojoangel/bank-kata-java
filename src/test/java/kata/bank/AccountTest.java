package kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static kata.bank.TransactionBuilder.aTransaction;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    private Account account;

    @Mock
    private DateProvider dateProvider;

    @Mock
    private Statements statements;

    @Mock
    Printer printer;

    @Before
    public void init() {
        account = new Account(dateProvider, statements);
    }

    @Test
    public void should_add_deposit_line() throws Exception {
        LocalDate depositDate = LocalDate.now();
        when(dateProvider.currentDate()).thenReturn(depositDate);

        account.deposit(99.99);

        verify(statements).add(
                aTransaction()
                        .withDate(depositDate)
                        .withAmount(99.99)
                        .build(),
                99.99
        );
    }

    @Test
    public void should_add_withdraw_line() throws Exception {
        LocalDate depositDate = LocalDate.now();
        when(dateProvider.currentDate()).thenReturn(depositDate);

        account.withdraw(99.99);

        verify(statements).add(
                aTransaction()
                        .withDate(depositDate)
                        .withAmount(-99.99)
                        .build(),
                -99.99
        );
    }

    @Test
    public void should_print_statements() throws Exception {
        account.printStatements(printer);
        verify(statements).printTo(printer);
    }

}