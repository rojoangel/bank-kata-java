package kata.bank.account;

import kata.bank.Printer;

public class StatementLine {
    private final Transaction transaction;

    private final double balance;

    public double getBalance() {
        return balance;
    }

    public StatementLine(Transaction transaction, double balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public void printTo(Printer printer) {
        transaction.printTo(printer, balance);
    }
}
