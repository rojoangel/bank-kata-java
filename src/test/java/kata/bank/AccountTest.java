package kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

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
        double amount = 99.99;
        double balance = 99.99;
        LocalDate depositDate = LocalDate.now();
        when(dateProvider.currentDate()).thenReturn(depositDate);

        account.deposit(amount);

        verify(statements).add(new Transaction(depositDate, amount), balance);
    }

    @Test
    public void should_add_withdraw_line() throws Exception {
        double amount = 99.99;
        double balance = -99.99;
        LocalDate depositDate = LocalDate.now();
        when(dateProvider.currentDate()).thenReturn(depositDate);

        account.withdraw(amount);

        verify(statements).add(new Transaction(depositDate, amount), balance);
    }

    @Test
    public void should_print_statements() throws Exception {
        account.printStatements(printer);
        verify(statements).printTo(printer);
    }

}