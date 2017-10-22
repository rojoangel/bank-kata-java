package kata.bank;

import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.verify;

public class AccountTest {
    private Account account;
    private Statements statements;

    @Test
    public void should_add_deposit_line() throws Exception {
        Date depositDate = new Date();
        account.deposit(99.99, depositDate);
        verify(statements).add(new Transaction(depositDate, 99.99, 99.99));
    }

}