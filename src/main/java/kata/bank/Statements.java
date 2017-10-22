package kata.bank;

public class Statements {

    public static final String HEADER = "DATE       | AMOUNT  | BALANCE";

    public void add(Transaction transaction, double balance) {

    }

    public void printTo(Printer printer) {
        printHeader(printer);
    }

    private void printHeader(Printer printer) {
        printer.printLine(HEADER);
    }
}
