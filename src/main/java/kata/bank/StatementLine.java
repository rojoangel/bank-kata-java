package kata.bank;

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
