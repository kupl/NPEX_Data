package spoon.reflect.visitor.printer;


public class ElementPrinterHelper {
    private final spoon.reflect.visitor.DefaultJavaPrettyPrinter prettyPrinter;

    private final spoon.compiler.Environment env;

    private spoon.reflect.visitor.printer.PrinterHelper printer;

    public ElementPrinterHelper(spoon.reflect.visitor.printer.PrinterHelper printerHelper, spoon.reflect.visitor.DefaultJavaPrettyPrinter prettyPrinter, spoon.compiler.Environment env) {
        this.printer = printerHelper;
        this.prettyPrinter = prettyPrinter;
        this.env = env;
    }

    public void setPrinter(spoon.reflect.visitor.printer.PrinterHelper printer) {
        this.printer = printer;
    }

    public void writeAnnotations(spoon.reflect.declaration.CtElement element) {
        for (spoon.reflect.declaration.CtAnnotation<?> annotation : element.getAnnotations()) {
            prettyPrinter.scan(annotation);
            printer.writeln().writeTabs();
        }
    }

    public void writeModifiers(spoon.reflect.declaration.CtModifiable modifiable) {
        for (spoon.reflect.declaration.ModifierKind modifierKind : modifiable.getModifiers()) {
            printer.write(((modifierKind.toString()) + " "));
        }
    }

    public void visitCtNamedElement(spoon.reflect.declaration.CtNamedElement namedElement, spoon.reflect.cu.CompilationUnit sourceCompilationUnit) {
        writeAnnotations(namedElement);
        if (env.isPreserveLineNumbers()) {
            printer.adjustStartPosition(namedElement);
        }
    }

    public void writeExtendsClause(spoon.reflect.declaration.CtType<?> type) {
        if ((type.getSuperclass()) != null) {
            printer.write(" extends ");
            prettyPrinter.scan(type.getSuperclass());
        }
    }

    public void writeImplementsClause(spoon.reflect.declaration.CtType<?> type) {
        if ((type.getSuperInterfaces().size()) > 0) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter(" implements ", " , ", null)) {
                for (spoon.reflect.reference.CtTypeReference<?> ref : type.getSuperInterfaces()) {
                    lp.printSeparatorIfAppropriate();
                    prettyPrinter.scan(ref);
                }
            }
        }
    }

    public void writeExecutableParameters(spoon.reflect.declaration.CtExecutable<?> executable) {
        try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("(", ", ", ")")) {
            for (spoon.reflect.declaration.CtParameter<?> p : executable.getParameters()) {
                lp.printSeparatorIfAppropriate();
                prettyPrinter.scan(p);
            }
        }
    }

    public void writeThrowsClause(spoon.reflect.declaration.CtExecutable<?> executable) {
        if ((executable.getThrownTypes().size()) > 0) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter(" throws ", ", ", null)) {
                for (spoon.reflect.reference.CtTypeReference<?> ref : executable.getThrownTypes()) {
                    lp.printSeparatorIfAppropriate();
                    prettyPrinter.scan(ref);
                }
            }
        }
    }

    public void writeStatement(spoon.reflect.code.CtStatement statement) {
        prettyPrinter.scan(statement);
        if (!((((((((((statement instanceof spoon.reflect.code.CtBlock) || (statement instanceof spoon.reflect.code.CtIf)) || (statement instanceof spoon.reflect.code.CtFor)) || (statement instanceof spoon.reflect.code.CtForEach)) || (statement instanceof spoon.reflect.code.CtWhile)) || (statement instanceof spoon.reflect.code.CtTry)) || (statement instanceof spoon.reflect.code.CtSwitch)) || (statement instanceof spoon.reflect.code.CtSynchronized)) || (statement instanceof spoon.reflect.declaration.CtClass)) || (statement instanceof spoon.reflect.code.CtComment))) {
            printer.write(";");
        }
        writeComment(statement, spoon.reflect.visitor.printer.CommentOffset.AFTER);
    }

    public void writeElementList(java.util.List<spoon.reflect.declaration.CtTypeMember> elements) {
        for (spoon.reflect.declaration.CtTypeMember element : elements) {
            if ((element instanceof spoon.reflect.declaration.CtConstructor) && (element.isImplicit())) {
                continue;
            }
            printer.writeln().writeTabs();
            prettyPrinter.scan(element);
            if (!(env.isPreserveLineNumbers())) {
                printer.writeln();
            }
        }
    }

    public void writeAnnotationElement(spoon.reflect.factory.Factory factory, java.lang.Object value) {
        if (value instanceof spoon.reflect.code.CtTypeAccess) {
            prettyPrinter.scan(((spoon.reflect.code.CtTypeAccess) (value)));
            printer.write(".class");
        }else
            if (value instanceof spoon.reflect.reference.CtFieldReference) {
                prettyPrinter.scan(((spoon.reflect.reference.CtFieldReference<?>) (value)).getDeclaringType());
                printer.write(("." + (((spoon.reflect.reference.CtFieldReference<?>) (value)).getSimpleName())));
            }else
                if (value instanceof spoon.reflect.declaration.CtElement) {
                    prettyPrinter.scan(((spoon.reflect.declaration.CtElement) (value)));
                }else
                    if (value instanceof java.lang.String) {
                        printer.write((("\"" + (value.toString())) + "\""));
                    }else
                        if (value instanceof java.util.Collection) {
                            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("{", " ,", "}")) {
                                for (java.lang.Object obj : ((java.util.Collection<?>) (value))) {
                                    lp.printSeparatorIfAppropriate();
                                    writeAnnotationElement(factory, obj);
                                }
                            }
                        }else
                            if (value instanceof java.lang.Object[]) {
                                try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("{", " ,", "}")) {
                                    for (java.lang.Object obj : ((java.lang.Object[]) (value))) {
                                        lp.printSeparatorIfAppropriate();
                                        writeAnnotationElement(factory, obj);
                                    }
                                }
                            }else
                                if (value instanceof java.lang.Enum) {
                                    try (spoon.reflect.visitor.PrintingContext.Writable c = prettyPrinter.getContext().modify().ignoreGenerics(true)) {
                                        prettyPrinter.scan(factory.Type().createReference(((java.lang.Enum<?>) (value)).getDeclaringClass()));
                                    }
                                    printer.write(".");
                                    printer.write(value.toString());
                                }else {
                                    printer.write(value.toString());
                                }
                            
                        
                    
                
            
        
    }

    public void writeFormalTypeParameters(spoon.reflect.declaration.CtFormalTypeDeclarer ctFormalTypeDeclarer) {
        final java.util.Collection<spoon.reflect.declaration.CtTypeParameter> parameters = ctFormalTypeDeclarer.getFormalCtTypeParameters();
        if (parameters == null) {
            return ;
        }
        if ((parameters.size()) > 0) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("<", ", ", ">")) {
                for (spoon.reflect.declaration.CtTypeParameter parameter : parameters) {
                    lp.printSeparatorIfAppropriate();
                    prettyPrinter.scan(parameter);
                }
            }
        }
    }

    public void writeActualTypeArguments(spoon.reflect.reference.CtActualTypeContainer ctGenericElementReference) {
        final java.util.Collection<spoon.reflect.reference.CtTypeReference<?>> arguments = ctGenericElementReference.getActualTypeArguments();
        if ((arguments != null) && ((arguments.size()) > 0)) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("<", ", ", ">")) {
                for (spoon.reflect.reference.CtTypeReference<?> argument : arguments) {
                    if (!(argument.isImplicit())) {
                        lp.printSeparatorIfAppropriate();
                        prettyPrinter.scan(argument);
                    }
                }
            }
        }
    }

    private boolean isJavaLangClasses(java.lang.String importType) {
        return importType.matches("^(java\\.lang\\.)[^.]*$");
    }

    public void writeHeader(java.util.List<spoon.reflect.declaration.CtType<?>> types, java.util.Collection<spoon.reflect.reference.CtReference> imports) {
        if (!(types.isEmpty())) {
            for (spoon.reflect.declaration.CtType<?> ctType : types) {
                writeComment(ctType, spoon.reflect.visitor.printer.CommentOffset.TOP_FILE);
            }
            if (!(types.get(0).getPackage().isUnnamedPackage())) {
                printer.write((("package " + (types.get(0).getPackage().getQualifiedName())) + ";"));
            }
            printer.writeln().writeln().writeTabs();
            java.util.List<java.lang.String> sortedImports = new java.util.ArrayList<>(imports.size());
            for (spoon.reflect.reference.CtReference ref : imports) {
                java.lang.String importStr = "import";
                java.lang.String importTypeStr = "";
                if (ref instanceof spoon.reflect.reference.CtTypeReference) {
                    spoon.reflect.reference.CtTypeReference typeRef = ((spoon.reflect.reference.CtTypeReference) (ref));
                    importTypeStr = typeRef.getQualifiedName();
                }else
                    if (ref instanceof spoon.reflect.reference.CtExecutableReference) {
                        importStr += " static";
                        spoon.reflect.reference.CtExecutableReference execRef = ((spoon.reflect.reference.CtExecutableReference) (ref));
                        if ((execRef.getDeclaringType()) != null) {
                            importTypeStr = ((this.removeInnerTypeSeparator(execRef.getDeclaringType().getQualifiedName())) + ".") + (execRef.getSimpleName());
                        }
                    }else
                        if (ref instanceof spoon.reflect.reference.CtFieldReference) {
                            importStr += " static";
                            spoon.reflect.reference.CtFieldReference fieldRef = ((spoon.reflect.reference.CtFieldReference) (ref));
                            importTypeStr = ((this.removeInnerTypeSeparator(fieldRef.getDeclaringType().getQualifiedName())) + ".") + (fieldRef.getSimpleName());
                        }
                    
                
                if ((!(importTypeStr.equals(""))) && (!(isJavaLangClasses(importTypeStr)))) {
                    sortedImports.add((((importStr + " ") + importTypeStr) + ";"));
                }
            }
            java.util.Collections.sort(sortedImports);
            for (java.lang.String importLine : sortedImports) {
                printer.write(importLine).writeln().writeTabs();
            }
            printer.writeln().writeTabs();
        }
    }

    private java.lang.String removeInnerTypeSeparator(java.lang.String fqn) {
        return fqn.replace(spoon.reflect.declaration.CtType.INNERTTYPE_SEPARATOR, ".");
    }

    public void writeComment(spoon.reflect.code.CtComment comment) {
        if ((!(env.isCommentsEnabled())) || (comment == null)) {
            return ;
        }
        prettyPrinter.scan(comment);
        printer.writeln().writeTabs();
    }

    private void writeComment(java.util.List<spoon.reflect.code.CtComment> comments) {
        if ((!(env.isCommentsEnabled())) || (comments == null)) {
            return ;
        }
        for (spoon.reflect.code.CtComment comment : comments) {
            writeComment(comment);
        }
    }

    public void writeComment(spoon.reflect.declaration.CtElement element) {
        if (element == null) {
            return ;
        }
        writeComment(element.getComments());
    }

    public void writeComment(spoon.reflect.declaration.CtElement element, spoon.reflect.visitor.printer.CommentOffset offset) {
        writeComment(getComments(element, offset));
    }

    public java.util.List<spoon.reflect.code.CtComment> getComments(spoon.reflect.declaration.CtElement element, spoon.reflect.visitor.printer.CommentOffset offset) {
        java.util.List<spoon.reflect.code.CtComment> commentsToPrint = new java.util.ArrayList<>();
        if ((!(env.isCommentsEnabled())) || (element == null)) {
            return commentsToPrint;
        }
        for (spoon.reflect.code.CtComment comment : element.getComments()) {
            if (((comment.getCommentType()) == (spoon.reflect.code.CtComment.CommentType.FILE)) && (offset == (spoon.reflect.visitor.printer.CommentOffset.TOP_FILE))) {
                commentsToPrint.add(comment);
                continue;
            }
            if ((comment.getCommentType()) == (spoon.reflect.code.CtComment.CommentType.FILE)) {
                continue;
            }
            if (((comment.getPosition()) == null) || ((element.getPosition()) == null)) {
                if (offset == (spoon.reflect.visitor.printer.CommentOffset.BEFORE)) {
                    commentsToPrint.add(comment);
                }
                continue;
            }
            final int line = element.getPosition().getLine();
            final int sourceEnd = element.getPosition().getSourceEnd();
            final int sourceStart = element.getPosition().getSourceStart();
            if ((offset == (spoon.reflect.visitor.printer.CommentOffset.BEFORE)) && (((comment.getPosition().getLine()) < line) || ((sourceStart <= (comment.getPosition().getSourceStart())) && (sourceEnd >= (comment.getPosition().getSourceEnd()))))) {
                commentsToPrint.add(comment);
            }else
                if ((offset == (spoon.reflect.visitor.printer.CommentOffset.AFTER)) && ((comment.getPosition().getSourceStart()) > sourceEnd)) {
                    commentsToPrint.add(comment);
                }else {
                    final int endLine = element.getPosition().getEndLine();
                    if (((offset == (spoon.reflect.visitor.printer.CommentOffset.INSIDE)) && ((comment.getPosition().getLine()) >= line)) && ((comment.getPosition().getEndLine()) <= endLine)) {
                        commentsToPrint.add(comment);
                    }
                }
            
        }
        return commentsToPrint;
    }

    public void writeIfOrLoopBlock(spoon.reflect.code.CtStatement block) {
        if (block != null) {
            if ((!(block.isImplicit())) && ((block instanceof spoon.reflect.code.CtBlock) || (block instanceof spoon.reflect.code.CtIf))) {
                printer.write(" ");
            }
            if ((!(block instanceof spoon.reflect.code.CtBlock)) && (!(block instanceof spoon.reflect.code.CtIf))) {
                printer.incTab();
                printer.writeln().writeTabs();
            }
            writeStatement(block);
            if ((!(block instanceof spoon.reflect.code.CtBlock)) && (!(block instanceof spoon.reflect.code.CtIf))) {
                printer.decTab().writeln().writeTabs();
            }
            if (!(block.isImplicit())) {
                if ((!(block.isParentInitialized())) || (((!((block.getParent()) instanceof spoon.reflect.code.CtFor)) && (!((block.getParent()) instanceof spoon.reflect.code.CtForEach))) && (!((block.getParent()) instanceof spoon.reflect.code.CtIf)))) {
                    printer.write(" ");
                }
            }
        }else {
            printer.write(";");
        }
    }
}

