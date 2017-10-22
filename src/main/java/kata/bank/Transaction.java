package kata.bank;

import java.util.Date;

public class Transaction {

    private final Date depositDate;
    private final double amount;

    public Transaction(Date depositDate, double amount) {
        this.depositDate = depositDate;
        this.amount = amount;
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
