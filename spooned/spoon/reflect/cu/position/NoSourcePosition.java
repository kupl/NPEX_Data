package spoon.reflect.cu.position;


public class NoSourcePosition implements java.io.Serializable , spoon.reflect.cu.SourcePosition {
    private static final long serialVersionUID = 1L;

    @java.lang.Override
    public java.io.File getFile() {
        return null;
    }

    @java.lang.Override
    public spoon.reflect.cu.CompilationUnit getCompilationUnit() {
        return null;
    }

    @java.lang.Override
    public int getLine() {
        return -1;
    }

    @java.lang.Override
    public int getEndLine() {
        return -1;
    }

    @java.lang.Override
    public int getColumn() {
        return -1;
    }

    @java.lang.Override
    public int getEndColumn() {
        return -1;
    }

    @java.lang.Override
    public int getSourceEnd() {
        return -1;
    }

    @java.lang.Override
    public int getSourceStart() {
        return -1;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "(unknown file)";
    }
}

