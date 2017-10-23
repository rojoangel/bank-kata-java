package kata.bank;

import java.util.LinkedList;
import java.util.List;

public class Statements {

    public static final String HEADER = "DATE       | AMOUNT  | BALANCE";

    private List<StatementLine> statementLines = new LinkedList<>();

    public void add(Transaction transaction, double balance) {
        statementLines.add(0, new StatementLine(transaction, balance));
    }

    public void printTo(Printer printer) {
        printHeader(printer);
        printLines(printer);
    }

    private void printLines(Printer printer) {
        for (StatementLine statementLine : statementLines) {
            statementLine.printTo(printer);
        }

    }

    private void printHeader(Printer printer) {
        printer.printLine(HEADER);
    }

    public double currentBalance() {
        if (statementLines.isEmpty()) {
            return 0.00;
        }
        return statementLines.get(0).getBalance();
    }
}
