package spoon.reflect.visitor.printer;


public class ListPrinter implements java.io.Closeable {
    private final spoon.reflect.visitor.printer.PrinterHelper printerHelper;

    private final java.lang.String next;

    private final java.lang.String end;

    private boolean isFirst = true;

    ListPrinter(spoon.reflect.visitor.printer.PrinterHelper printerHelper, java.lang.String start, java.lang.String next, java.lang.String end) {
        super();
        this.printerHelper = printerHelper;
        this.next = next;
        this.end = end;
        if ((start != null) && ((start.length()) > 0)) {
            printerHelper.write(start);
        }
    }

    public void printSeparatorIfAppropriate() {
        if (isFirst) {
            isFirst = false;
        }else {
            if (((next) != null) && ((next.length()) > 0)) {
                printerHelper.write(next);
            }
        }
    }

    @java.lang.Override
    public void close() {
        if (((end) != null) && ((end.length()) > 0)) {
            printerHelper.write(end);
        }
    }
}

