package kata.bank;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StatementPrintingSteps {

    private Account account;

    @Before
    public void create_account() {
        account = new Account();
    }

    @Given("^(?:a client )?deposits (\\d+) on (\\d+)/(\\d+)/(\\d+)$")
    public void a_client_deposits_on(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^withdraws (\\d+) on (\\d+)/(\\d+)/(\\d+)$")
    public void withdraws_on(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^he prints his bank statement$")
    public void he_prints_his_bank_statement() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^he sees$")
    public void he_sees(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }
}
