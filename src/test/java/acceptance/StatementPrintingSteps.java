package acceptance;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kata.bank.*;
import kata.bank.account.Statements;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrintingSteps {

    private Account account;

    private DateProvider dateProvider;

    private Printer printer;

    @Before
    public void create_account() {
        dateProvider = mock(DateProvider.class);
        printer = mock(Printer.class);
        account = new Account(
                dateProvider,
                new Statements()
        );
    }

    @Given("^(?:a client )?deposits (\\d+) on (.*?)$")
    public void a_client_deposits_on(int amount, @Transform(DateMapper.class) LocalDate date) throws Throwable {
        when(dateProvider.currentDate()).thenReturn(date);
        account.deposit(amount);
    }

    @Given("^withdraws (\\d+) on (.*?)$")
    public void withdraws_on(int amount, @Transform(DateMapper.class) LocalDate date) throws Throwable {
        when(dateProvider.currentDate()).thenReturn(date);
        account.withdraw(amount);
    }

    @When("^he prints his bank statement$")
    public void he_prints_his_bank_statement() throws Throwable {
        account.printStatements(printer);
    }

    @Then("^he sees$")
    public void he_sees(DataTable statements) throws Throwable {
        InOrder inOrder = Mockito.inOrder(printer);
        for (String statement : statements.asList(String.class)) {
            inOrder.verify(printer).printLine(statement);
        }
    }
}
