package kata.bank.account;

import java.time.LocalDate;

public class TransactionBuilder {

    private LocalDate date;
    private double amount;

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public TransactionBuilder withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Transaction build() {
        return new Transaction(date, amount);
    }
}
