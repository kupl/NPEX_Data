package spoon.reflect.visitor.printer;


public class PrinterHelper {
    private static final java.lang.String LINE_SEPARATOR = java.lang.System.getProperty("line.separator");

    private spoon.compiler.Environment env;

    private final java.lang.StringBuffer sbf = new java.lang.StringBuffer();

    private int nbTabs = 0;

    private int line = 1;

    private int column = 1;

    private java.util.Map<java.lang.Integer, java.lang.Integer> lineNumberMapping = new java.util.HashMap<>();

    private java.util.ArrayDeque<java.lang.Integer> lengths = new java.util.ArrayDeque<>();

    public PrinterHelper(spoon.compiler.Environment env) {
        this.env = env;
    }

    public spoon.reflect.visitor.printer.PrinterHelper write(java.lang.String s) {
        if (s != null) {
            sbf.append(s);
            column += s.length();
        }
        return this;
    }

    public spoon.reflect.visitor.printer.PrinterHelper write(char c) {
        sbf.append(c);
        column += 1;
        return this;
    }

    public spoon.reflect.visitor.printer.PrinterHelper writeln() {
        write(spoon.reflect.visitor.printer.PrinterHelper.LINE_SEPARATOR);
        (line)++;
        column = 1;
        return this;
    }

    public spoon.reflect.visitor.printer.PrinterHelper writeTabs() {
        for (int i = 0; i < (nbTabs); i++) {
            if (env.isUsingTabulations()) {
                write('\t');
            }else {
                for (int j = 0; j < (env.getTabulationSize()); j++) {
                    write(' ');
                }
            }
        }
        return this;
    }

    public spoon.reflect.visitor.printer.PrinterHelper incTab() {
        (nbTabs)++;
        return this;
    }

    public spoon.reflect.visitor.printer.PrinterHelper decTab() {
        (nbTabs)--;
        return this;
    }

    public spoon.reflect.visitor.printer.PrinterHelper setTabCount(int tabCount) {
        nbTabs = tabCount;
        return this;
    }

    public boolean removeLine() {
        java.lang.String ls = spoon.reflect.visitor.printer.PrinterHelper.LINE_SEPARATOR;
        int i = (sbf.length()) - (ls.length());
        boolean hasWhite = false;
        while ((i > 0) && (!(ls.equals(sbf.substring(i, (i + (ls.length()))))))) {
            if (!(isWhite(sbf.charAt(i)))) {
                return false;
            }
            hasWhite = true;
            i--;
        } 
        if (i <= 0) {
            return false;
        }
        hasWhite = hasWhite || (isWhite(sbf.charAt((i - 1))));
        sbf.replace(i, (i + (ls.length())), (hasWhite ? "" : " "));
        (line)--;
        return true;
    }

    private boolean isWhite(char c) {
        return (((c == ' ') || (c == '\t')) || (c == '\n')) || (c == '\r');
    }

    public spoon.reflect.visitor.printer.PrinterHelper adjustStartPosition(spoon.reflect.declaration.CtElement e) {
        if (((e.getPosition()) != null) && (!(e.isImplicit()))) {
            while ((line) < (e.getPosition().getLine())) {
                writeln();
            } 
            while ((line) > (e.getPosition().getLine())) {
                if (!(removeLine())) {
                    break;
                }
            } 
        }
        return this;
    }

    public spoon.reflect.visitor.printer.PrinterHelper adjustEndPosition(spoon.reflect.declaration.CtElement e) {
        if ((env.isPreserveLineNumbers()) && ((e.getPosition()) != null)) {
            while ((line) < (e.getPosition().getEndLine())) {
                writeln();
            } 
        }
        return this;
    }

    public void undefineLine() {
        if ((lineNumberMapping.get(line)) == null) {
            putLineNumberMapping(0);
        }
    }

    public void mapLine(spoon.reflect.declaration.CtElement e, spoon.reflect.cu.CompilationUnit unitExpected) {
        if (((e.getPosition()) != null) && ((e.getPosition().getCompilationUnit()) == unitExpected)) {
            putLineNumberMapping(e.getPosition().getLine());
        }else {
            undefineLine();
        }
    }

    public void putLineNumberMapping(int valueLine) {
        lineNumberMapping.put(this.line, valueLine);
    }

    @java.lang.Deprecated
    public spoon.reflect.visitor.printer.PrinterHelper removeLastChar() {
        while (isWhite(sbf.charAt(((sbf.length()) - 1)))) {
            if ((sbf.charAt(((sbf.length()) - 1))) == '\n') {
                (line)--;
            }
            sbf.deleteCharAt(((sbf.length()) - 1));
        } 
        sbf.deleteCharAt(((sbf.length()) - 1));
        while (isWhite(sbf.charAt(((sbf.length()) - 1)))) {
            if ((sbf.charAt(((sbf.length()) - 1))) == '\n') {
                (line)--;
            }
            sbf.deleteCharAt(((sbf.length()) - 1));
        } 
        return this;
    }

    public void preWriteUnaryOperator(spoon.reflect.code.UnaryOperatorKind o) {
        switch (o) {
            case POS :
                write("+");
                break;
            case NEG :
                write("-");
                break;
            case NOT :
                write("!");
                break;
            case COMPL :
                write("~");
                break;
            case PREINC :
                write("++");
                break;
            case PREDEC :
                write("--");
                break;
            default :
        }
    }

    public void postWriteUnaryOperator(spoon.reflect.code.UnaryOperatorKind o) {
        switch (o) {
            case POSTINC :
                write("++");
                break;
            case POSTDEC :
                write("--");
                break;
            default :
        }
    }

    public spoon.reflect.visitor.printer.PrinterHelper writeOperator(spoon.reflect.code.BinaryOperatorKind o) {
        switch (o) {
            case OR :
                write("||");
                break;
            case AND :
                write("&&");
                break;
            case BITOR :
                write("|");
                break;
            case BITXOR :
                write("^");
                break;
            case BITAND :
                write("&");
                break;
            case EQ :
                write("==");
                break;
            case NE :
                write("!=");
                break;
            case LT :
                write("<");
                break;
            case GT :
                write(">");
                break;
            case LE :
                write("<=");
                break;
            case GE :
                write(">=");
                break;
            case SL :
                write("<<");
                break;
            case SR :
                write(">>");
                break;
            case USR :
                write(">>>");
                break;
            case PLUS :
                write("+");
                break;
            case MINUS :
                write("-");
                break;
            case MUL :
                write("*");
                break;
            case DIV :
                write("/");
                break;
            case MOD :
                write("%");
                break;
            case INSTANCEOF :
                write("instanceof");
                break;
        }
        return this;
    }

    public void writeCharLiteral(java.lang.Character c, boolean mayContainsSpecialCharacter) {
        if (!mayContainsSpecialCharacter) {
            write(c);
        }else
            if ((java.lang.Character.UnicodeBlock.of(c)) != (java.lang.Character.UnicodeBlock.BASIC_LATIN)) {
                if (c < 16) {
                    write(("\\u000" + (java.lang.Integer.toHexString(c))));
                }else
                    if (c < 256) {
                        write(("\\u00" + (java.lang.Integer.toHexString(c))));
                    }else
                        if (c < 4096) {
                            write(("\\u0" + (java.lang.Integer.toHexString(c))));
                        }else {
                            write(("\\u" + (java.lang.Integer.toHexString(c))));
                        }
                    
                
            }else {
                switch (c) {
                    case '\b' :
                        write("\\b");
                        break;
                    case '\t' :
                        write("\\t");
                        break;
                    case '\n' :
                        write("\\n");
                        break;
                    case '\f' :
                        write("\\f");
                        break;
                    case '\r' :
                        write("\\r");
                        break;
                    case '\"' :
                        write("\\\"");
                        break;
                    case '\'' :
                        write("\\\'");
                        break;
                    case '\\' :
                        write("\\\\");
                        break;
                    default :
                        write((java.lang.Character.isISOControl(c) ? java.lang.String.format("\\u%04x", ((int) (c))) : java.lang.Character.toString(c)));
                }
            }
        
    }

    public void writeStringLiteral(java.lang.String value, boolean mayContainsSpecialCharacter) {
        if (!mayContainsSpecialCharacter) {
            write(value);
        }else {
            for (int i = 0; i < (value.length()); i++) {
                writeCharLiteral(value.charAt(i), mayContainsSpecialCharacter);
            }
        }
    }

    public java.util.Map<java.lang.Integer, java.lang.Integer> getLineNumberMapping() {
        return lineNumberMapping;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return sbf.toString();
    }

    public void snapshotLength() {
        lengths.addLast(toString().length());
    }

    public boolean hasNewContent() {
        return (lengths.pollLast()) < (toString().length());
    }

    public spoon.reflect.visitor.printer.ListPrinter createListPrinter(java.lang.String start, java.lang.String next, java.lang.String end) {
        return new spoon.reflect.visitor.printer.ListPrinter(this, start, next, end);
    }
}

