package kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
        verify(printer).printLine("| DATE       | AMOUNT  | BALANCE |");
    }
}