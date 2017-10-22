package kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    private Account account;

    @Mock
    private DateProvider dateProvider;

    @Mock
    private Statements statements;


    @Before
    public void init() {
        account = new Account(dateProvider, statements);
    }

    @Test
    public void should_add_deposit_line() throws Exception {
        double amount = 99.99;
        double balance = 99.99;
        Date depositDate = new Date();
        when(dateProvider.currentDate()).thenReturn(depositDate);

        account.deposit(amount);

        verify(statements).add(new Transaction(depositDate, amount), balance);
    }
}