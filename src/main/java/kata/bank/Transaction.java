package kata.bank;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final LocalDate depositDate;
    private final double amount;

    public Transaction(LocalDate depositDate, double amount) {
        this.depositDate = depositDate;
        this.amount = amount;
    }

    public void printTo(Printer printer, double balance) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat amountFormatter = new DecimalFormat("#0.00");

        StringBuilder builder = new StringBuilder();
        builder.append(dateFormatter.format(depositDate));
        builder.append(" | ");
        builder.append(amountFormatter.format(amount));
        builder.append(" | ");
        builder.append(amountFormatter.format(balance));

        printer.printLine(builder.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        return depositDate != null ? depositDate.equals(that.depositDate) : that.depositDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = depositDate != null ? depositDate.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
