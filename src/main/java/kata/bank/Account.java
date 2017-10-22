package kata.bank;

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
        double balance = amount;
        statements.add(transaction, balance);
    }

    public void withdraw(double amount) {
        LocalDate date = dateProvider.currentDate();
        Transaction transaction = new Transaction(date, amount);
        double balance = -amount;
        statements.add(transaction, balance);
    }

    public void printStatements(Printer printer) {
        statements.printTo(printer);
    }
}
