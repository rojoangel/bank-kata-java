package kata.bank;

import kata.bank.account.Statements;
import kata.bank.account.Transaction;

import java.time.LocalDate;

public class Account {
    private DateProvider dateProvider;
    private Statements statements;

    public Account(DateProvider dateProvider, Statements statements) {
        this.dateProvider = dateProvider;
        this.statements = statements;
    }

    public void deposit(double amount) {
        LocalDate date = dateProvider.currentDate();
        Transaction transaction = new Transaction(date, amount);
        statements.add(transaction, statements.currentBalance() + amount);
    }

    public void withdraw(double amount) {
        deposit(-amount);
    }

    public void printStatements(Printer printer) {
        statements.printTo(printer);
    }
}
