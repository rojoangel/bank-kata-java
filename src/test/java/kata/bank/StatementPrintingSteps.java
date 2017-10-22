package kata.bank;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

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
    public void a_client_deposits_on(int amount, Date date) throws Throwable {
        when(dateProvider.currentDate()).thenReturn(date);
        account.deposit(amount);
    }

    @Given("^withdraws (\\d+) on (.*?)$")
    public void withdraws_on(int amount, Date date) throws Throwable {
        account.withdraw(amount);
    }

    @When("^he prints his bank statement$")
    public void he_prints_his_bank_statement() throws Throwable {
        account.printStatements(printer);
    }

    @Then("^he sees$")
    public void he_sees(DataTable balance) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }
}
