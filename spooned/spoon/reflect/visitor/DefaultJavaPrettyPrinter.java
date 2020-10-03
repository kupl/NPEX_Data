package spoon.reflect.visitor;


public class DefaultJavaPrettyPrinter implements spoon.reflect.visitor.CtVisitor , spoon.reflect.visitor.PrettyPrinter {
    public static final java.lang.String JAVA_FILE_EXTENSION = ".java";

    public static final java.lang.String JAVA_PACKAGE_DECLARATION = "package-info" + (spoon.reflect.visitor.DefaultJavaPrettyPrinter.JAVA_FILE_EXTENSION);

    public static final java.lang.String LINE_SEPARATOR = java.lang.System.getProperty("line.separator");

    public static final java.lang.String COMMENT_STAR = " * ";

    public static final java.lang.String BLOCK_COMMENT_END = " */";

    public static final java.lang.String JAVADOC_START = "/**";

    public static final java.lang.String INLINE_COMMENT_START = "// ";

    public static final java.lang.String BLOCK_COMMENT_START = "/* ";

    private static final java.lang.String LINE_SEPARATORS_RE = "\\n\\r|\\n|\\r";

    public spoon.reflect.visitor.PrintingContext context = new spoon.reflect.visitor.PrintingContext();

    private spoon.reflect.visitor.ImportScanner importsContext;

    private spoon.compiler.Environment env;

    private spoon.reflect.visitor.printer.PrinterHelper printer;

    private spoon.reflect.visitor.printer.ElementPrinterHelper elementPrinterHelper;

    private spoon.reflect.cu.CompilationUnit sourceCompilationUnit;

    public DefaultJavaPrettyPrinter(spoon.compiler.Environment env) {
        this.env = env;
        printer = new spoon.reflect.visitor.printer.PrinterHelper(env);
        elementPrinterHelper = new spoon.reflect.visitor.printer.ElementPrinterHelper(printer, this, env);
        if (env.isAutoImports()) {
            this.importsContext = new spoon.reflect.visitor.ImportScannerImpl();
        }else {
            this.importsContext = new spoon.reflect.visitor.MinimalImportScanner();
        }
    }

    protected void enterCtExpression(spoon.reflect.code.CtExpression<?> e) {
        if (!(e instanceof spoon.reflect.code.CtStatement)) {
            elementPrinterHelper.writeComment(e, spoon.reflect.visitor.printer.CommentOffset.BEFORE);
        }
        printer.mapLine(e, sourceCompilationUnit);
        if (shouldSetBracket(e)) {
            context.parenthesedExpression.push(e);
            printer.write("(");
        }
        if (!(e.getTypeCasts().isEmpty())) {
            for (spoon.reflect.reference.CtTypeReference<?> r : e.getTypeCasts()) {
                printer.write("(");
                this.scan(r);
                printer.write(") ");
                printer.write("(");
                context.parenthesedExpression.push(e);
            }
        }
    }

    protected void enterCtStatement(spoon.reflect.code.CtStatement s) {
        elementPrinterHelper.writeComment(s, spoon.reflect.visitor.printer.CommentOffset.BEFORE);
        printer.mapLine(s, sourceCompilationUnit);
        elementPrinterHelper.writeAnnotations(s);
        if ((s.getLabel()) != null) {
            printer.write(s.getLabel()).write(" : ");
        }
    }

    protected void exitCtExpression(spoon.reflect.code.CtExpression<?> e) {
        while (((context.parenthesedExpression.size()) > 0) && (e == (context.parenthesedExpression.peek()))) {
            context.parenthesedExpression.pop();
            printer.write(")");
        } 
        if (!(e instanceof spoon.reflect.code.CtStatement)) {
            elementPrinterHelper.writeComment(e, spoon.reflect.visitor.printer.CommentOffset.AFTER);
        }
    }

    public java.util.Collection<spoon.reflect.reference.CtReference> computeImports(spoon.reflect.declaration.CtType<?> type) {
        context.currentTopLevel = type;
        importsContext.computeImports(context.currentTopLevel);
        return importsContext.getAllImports();
    }

    public void computeImports(spoon.reflect.declaration.CtElement element) {
        if (env.isAutoImports()) {
            importsContext.computeImports(element);
        }
    }

    public spoon.reflect.visitor.DefaultJavaPrettyPrinter scan(spoon.reflect.declaration.CtElement e) {
        if (e != null) {
            context.elementStack.push(e);
            if (env.isPreserveLineNumbers()) {
                if (!(e instanceof spoon.reflect.declaration.CtNamedElement)) {
                    printer.adjustStartPosition(e);
                }
            }
            e.accept(this);
            context.elementStack.pop();
        }
        return this;
    }

    public spoon.reflect.visitor.DefaultJavaPrettyPrinter scan(spoon.reflect.reference.CtReference ref) {
        if (ref != null) {
            ref.accept(this);
        }
        return this;
    }

    private boolean shouldSetBracket(spoon.reflect.code.CtExpression<?> e) {
        if ((e.getTypeCasts().size()) != 0) {
            return true;
        }
        try {
            if (((e.getParent()) instanceof spoon.reflect.code.CtBinaryOperator) || ((e.getParent()) instanceof spoon.reflect.code.CtUnaryOperator)) {
                return ((((e instanceof spoon.reflect.code.CtTargetedExpression) || (e instanceof spoon.reflect.code.CtAssignment)) || (e instanceof spoon.reflect.code.CtConditional)) || (e instanceof spoon.reflect.code.CtUnaryOperator)) || (e instanceof spoon.reflect.code.CtBinaryOperator);
            }
            if ((e.getParent()) instanceof spoon.reflect.code.CtTargetedExpression) {
                return (((e instanceof spoon.reflect.code.CtBinaryOperator) || (e instanceof spoon.reflect.code.CtAssignment)) || (e instanceof spoon.reflect.code.CtConditional)) || (e instanceof spoon.reflect.code.CtUnaryOperator);
            }
        } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
        }
        return false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return printer.toString();
    }

    @java.lang.Override
    public <A extends java.lang.annotation.Annotation> void visitCtAnnotation(spoon.reflect.declaration.CtAnnotation<A> annotation) {
        elementPrinterHelper.writeAnnotations(annotation);
        printer.write("@");
        scan(annotation.getAnnotationType());
        if ((annotation.getValues().size()) > 0) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("(", ", ", ")")) {
                for (java.util.Map.Entry<java.lang.String, spoon.reflect.code.CtExpression> e : annotation.getValues().entrySet()) {
                    lp.printSeparatorIfAppropriate();
                    printer.write(((e.getKey()) + " = "));
                    elementPrinterHelper.writeAnnotationElement(annotation.getFactory(), e.getValue());
                }
            }
        }
    }

    @java.lang.Override
    public <A extends java.lang.annotation.Annotation> void visitCtAnnotationType(spoon.reflect.declaration.CtAnnotationType<A> annotationType) {
        visitCtType(annotationType);
        printer.write((("@interface " + (annotationType.getSimpleName())) + " {")).incTab();
        elementPrinterHelper.writeElementList(annotationType.getTypeMembers());
        printer.decTab().writeTabs().write("}");
    }

    @java.lang.Override
    public void visitCtAnonymousExecutable(spoon.reflect.declaration.CtAnonymousExecutable impl) {
        elementPrinterHelper.writeComment(impl);
        elementPrinterHelper.writeAnnotations(impl);
        elementPrinterHelper.writeModifiers(impl);
        scan(impl.getBody());
    }

    @java.lang.Override
    public <T> void visitCtArrayRead(spoon.reflect.code.CtArrayRead<T> arrayRead) {
        printCtArrayAccess(arrayRead);
    }

    @java.lang.Override
    public <T> void visitCtArrayWrite(spoon.reflect.code.CtArrayWrite<T> arrayWrite) {
        printCtArrayAccess(arrayWrite);
    }

    private <T, E extends spoon.reflect.code.CtExpression<?>> void printCtArrayAccess(spoon.reflect.code.CtArrayAccess<T, E> arrayAccess) {
        enterCtExpression(arrayAccess);
        scan(arrayAccess.getTarget());
        printer.write("[");
        scan(arrayAccess.getIndexExpression());
        printer.write("]");
        exitCtExpression(arrayAccess);
    }

    @java.lang.Override
    public <T> void visitCtArrayTypeReference(spoon.reflect.reference.CtArrayTypeReference<T> reference) {
        if (reference.isImplicit()) {
            return ;
        }
        scan(reference.getComponentType());
        if (!(context.skipArray())) {
            printer.write("[]");
        }
    }

    @java.lang.Override
    public <T> void visitCtAssert(spoon.reflect.code.CtAssert<T> asserted) {
        enterCtStatement(asserted);
        printer.write("assert ");
        scan(asserted.getAssertExpression());
        if ((asserted.getExpression()) != null) {
            printer.write(" : ");
            scan(asserted.getExpression());
        }
    }

    @java.lang.Override
    public <T, A extends T> void visitCtAssignment(spoon.reflect.code.CtAssignment<T, A> assignement) {
        enterCtStatement(assignement);
        enterCtExpression(assignement);
        scan(assignement.getAssigned());
        printer.write(" = ");
        scan(assignement.getAssignment());
        exitCtExpression(assignement);
    }

    @java.lang.Override
    public <T> void visitCtBinaryOperator(spoon.reflect.code.CtBinaryOperator<T> operator) {
        enterCtExpression(operator);
        scan(operator.getLeftHandOperand());
        printer.write(" ").writeOperator(operator.getKind()).write(" ");
        scan(operator.getRightHandOperand());
        exitCtExpression(operator);
    }

    @java.lang.Override
    public <R> void visitCtBlock(spoon.reflect.code.CtBlock<R> block) {
        enterCtStatement(block);
        if (!(block.isImplicit())) {
            printer.write("{");
        }
        printer.incTab();
        for (spoon.reflect.code.CtStatement statement : block.getStatements()) {
            if (!(statement.isImplicit())) {
                printer.writeln().writeTabs();
                elementPrinterHelper.writeStatement(statement);
            }
        }
        printer.decTab();
        printer.adjustEndPosition(block);
        if (env.isPreserveLineNumbers()) {
            if (!(block.isImplicit())) {
                printer.writeTabs().write("}");
            }
        }else {
            printer.writeln().writeTabs();
            if (!(block.isImplicit())) {
                printer.write("}");
            }
        }
    }

    @java.lang.Override
    public void visitCtBreak(spoon.reflect.code.CtBreak breakStatement) {
        enterCtStatement(breakStatement);
        printer.write("break");
        if ((breakStatement.getTargetLabel()) != null) {
            printer.write((" " + (breakStatement.getTargetLabel())));
        }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings(value = "rawtypes")
    public <E> void visitCtCase(spoon.reflect.code.CtCase<E> caseStatement) {
        enterCtStatement(caseStatement);
        if ((caseStatement.getCaseExpression()) != null) {
            printer.write("case ");
            if ((caseStatement.getCaseExpression()) instanceof spoon.reflect.code.CtFieldAccess) {
                final spoon.reflect.reference.CtFieldReference variable = ((spoon.reflect.code.CtFieldAccess) (caseStatement.getCaseExpression())).getVariable();
                if ((((variable.getType()) != null) && ((variable.getDeclaringType()) != null)) && (variable.getType().getQualifiedName().equals(variable.getDeclaringType().getQualifiedName()))) {
                    printer.write(variable.getSimpleName());
                }else {
                    scan(caseStatement.getCaseExpression());
                }
            }else {
                scan(caseStatement.getCaseExpression());
            }
        }else {
            printer.write("default");
        }
        printer.write(" :").incTab();
        for (spoon.reflect.code.CtStatement statement : caseStatement.getStatements()) {
            printer.writeln().writeTabs();
            elementPrinterHelper.writeStatement(statement);
        }
        printer.decTab();
    }

    @java.lang.Override
    public void visitCtCatch(spoon.reflect.code.CtCatch catchBlock) {
        elementPrinterHelper.writeComment(catchBlock, spoon.reflect.visitor.printer.CommentOffset.BEFORE);
        printer.write(" catch (");
        spoon.reflect.code.CtCatchVariable<? extends java.lang.Throwable> parameter = catchBlock.getParameter();
        if ((parameter.getMultiTypes().size()) > 0) {
            for (int i = 0; i < (parameter.getMultiTypes().size()); i++) {
                spoon.reflect.reference.CtTypeReference<?> type = parameter.getMultiTypes().get(i);
                scan(type);
                if (i < ((parameter.getMultiTypes().size()) - 1)) {
                    printer.write(" | ");
                }
            }
            printer.write((" " + (parameter.getSimpleName())));
        }else {
            scan(parameter);
        }
        printer.write(") ");
        scan(catchBlock.getBody());
    }

    @java.lang.Override
    public <T> void visitCtClass(spoon.reflect.declaration.CtClass<T> ctClass) {
        context.pushCurrentThis(ctClass);
        if ((((ctClass.getSimpleName()) != null) && (!(spoon.reflect.declaration.CtType.NAME_UNKNOWN.equals(ctClass.getSimpleName())))) && (!(ctClass.isAnonymous()))) {
            visitCtType(ctClass);
            if (ctClass.isLocalType()) {
                printer.write(("class " + (ctClass.getSimpleName().replaceAll("^[0-9]*", ""))));
            }else {
                printer.write(("class " + (ctClass.getSimpleName())));
            }
            elementPrinterHelper.writeFormalTypeParameters(ctClass);
            elementPrinterHelper.writeExtendsClause(ctClass);
            elementPrinterHelper.writeImplementsClause(ctClass);
        }
        printer.write(" {").incTab();
        elementPrinterHelper.writeElementList(ctClass.getTypeMembers());
        printer.adjustEndPosition(ctClass).decTab().writeTabs().write("}");
        context.popCurrentThis();
    }

    @java.lang.Override
    public void visitCtTypeParameter(spoon.reflect.declaration.CtTypeParameter typeParameter) {
        spoon.reflect.reference.CtTypeParameterReference ref = typeParameter.getReference();
        if (ref.isImplicit()) {
            return ;
        }
        elementPrinterHelper.writeAnnotations(ref);
        if (printQualified(ref)) {
            printer.write(ref.getQualifiedName());
        }else {
            printer.write(ref.getSimpleName());
        }
        if ((ref.getBoundingType()) != null) {
            if (ref.isUpper()) {
                printer.write(" extends ");
            }else {
                printer.write(" super ");
            }
            scan(ref.getBoundingType());
        }
    }

    @java.lang.Override
    public <T> void visitCtConditional(spoon.reflect.code.CtConditional<T> conditional) {
        enterCtExpression(conditional);
        spoon.reflect.code.CtExpression<java.lang.Boolean> condition = conditional.getCondition();
        boolean parent;
        try {
            parent = ((conditional.getParent()) instanceof spoon.reflect.code.CtAssignment) || ((conditional.getParent()) instanceof spoon.reflect.declaration.CtVariable);
        } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
            parent = false;
        }
        if (parent) {
            printer.write("(");
        }
        scan(condition);
        if (parent) {
            printer.write(")");
        }
        printer.write(" ? ");
        spoon.reflect.code.CtExpression<T> thenExpression = conditional.getThenExpression();
        scan(thenExpression);
        printer.write(" : ");
        spoon.reflect.code.CtExpression<T> elseExpression = conditional.getElseExpression();
        boolean isAssign = false;
        if (isAssign = elseExpression instanceof spoon.reflect.code.CtAssignment) {
            printer.write("(");
        }
        scan(elseExpression);
        if (isAssign) {
            printer.write(")");
        }
        exitCtExpression(conditional);
    }

    @java.lang.Override
    public <T> void visitCtConstructor(spoon.reflect.declaration.CtConstructor<T> constructor) {
        elementPrinterHelper.writeComment(constructor);
        elementPrinterHelper.visitCtNamedElement(constructor, sourceCompilationUnit);
        elementPrinterHelper.writeModifiers(constructor);
        elementPrinterHelper.writeFormalTypeParameters(constructor);
        if ((constructor.getFormalCtTypeParameters().size()) > 0) {
            printer.write(' ');
        }
        if ((constructor.getDeclaringType()) != null) {
            if (constructor.getDeclaringType().isLocalType()) {
                printer.write(constructor.getDeclaringType().getSimpleName().replaceAll("^[0-9]*", ""));
            }else {
                printer.write(constructor.getDeclaringType().getSimpleName());
            }
        }
        elementPrinterHelper.writeExecutableParameters(constructor);
        elementPrinterHelper.writeThrowsClause(constructor);
        printer.write(" ");
        scan(constructor.getBody());
    }

    @java.lang.Override
    public void visitCtContinue(spoon.reflect.code.CtContinue continueStatement) {
        enterCtStatement(continueStatement);
        printer.write("continue");
        if ((continueStatement.getTargetLabel()) != null) {
            printer.write((" " + (continueStatement.getTargetLabel())));
        }
    }

    @java.lang.Override
    public void visitCtDo(spoon.reflect.code.CtDo doLoop) {
        enterCtStatement(doLoop);
        printer.write("do");
        elementPrinterHelper.writeIfOrLoopBlock(doLoop.getBody());
        printer.write("while (");
        scan(doLoop.getLoopingExpression());
        printer.write(" )");
    }

    @java.lang.Override
    public <T extends java.lang.Enum<?>> void visitCtEnum(spoon.reflect.declaration.CtEnum<T> ctEnum) {
        visitCtType(ctEnum);
        printer.write(("enum " + (ctEnum.getSimpleName())));
        elementPrinterHelper.writeImplementsClause(ctEnum);
        context.pushCurrentThis(ctEnum);
        printer.write(" {").incTab().writeln();
        if ((ctEnum.getEnumValues().size()) == 0) {
            printer.writeTabs().write(";").writeln();
        }else {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter(null, ", ", ";")) {
                for (spoon.reflect.declaration.CtEnumValue<?> enumValue : ctEnum.getEnumValues()) {
                    lp.printSeparatorIfAppropriate();
                    scan(enumValue);
                }
            }
        }
        elementPrinterHelper.writeElementList(ctEnum.getTypeMembers());
        printer.decTab().writeTabs().write("}");
        context.popCurrentThis();
    }

    @java.lang.Override
    public <T> void visitCtExecutableReference(spoon.reflect.reference.CtExecutableReference<T> reference) {
        printer.write(reference.getSignature());
    }

    @java.lang.Override
    public <T> void visitCtField(spoon.reflect.declaration.CtField<T> f) {
        elementPrinterHelper.writeComment(f);
        elementPrinterHelper.visitCtNamedElement(f, sourceCompilationUnit);
        elementPrinterHelper.writeModifiers(f);
        scan(f.getType());
        printer.write(" ");
        printer.write(f.getSimpleName());
        if ((f.getDefaultExpression()) != null) {
            printer.write(" = ");
            scan(f.getDefaultExpression());
        }
        printer.write(";");
    }

    @java.lang.Override
    public <T> void visitCtEnumValue(spoon.reflect.declaration.CtEnumValue<T> enumValue) {
        elementPrinterHelper.visitCtNamedElement(enumValue, sourceCompilationUnit);
        printer.write(enumValue.getSimpleName());
        if ((enumValue.getDefaultExpression()) != null) {
            spoon.reflect.code.CtConstructorCall<?> constructorCall = ((spoon.reflect.code.CtConstructorCall<?>) (enumValue.getDefaultExpression()));
            if ((constructorCall.getArguments().size()) > 0) {
                printer.write("(");
                boolean first = true;
                for (spoon.reflect.code.CtExpression<?> ctexpr : constructorCall.getArguments()) {
                    if (first) {
                        first = false;
                    }else {
                        printer.write(",");
                    }
                    scan(ctexpr);
                }
                printer.write(")");
            }
            if (constructorCall instanceof spoon.reflect.code.CtNewClass) {
                scan(((spoon.reflect.code.CtNewClass<?>) (constructorCall)).getAnonymousClass());
            }
        }
    }

    @java.lang.Override
    public <T> void visitCtFieldRead(spoon.reflect.code.CtFieldRead<T> fieldRead) {
        printCtFieldAccess(fieldRead);
    }

    @java.lang.Override
    public <T> void visitCtFieldWrite(spoon.reflect.code.CtFieldWrite<T> fieldWrite) {
        printCtFieldAccess(fieldWrite);
    }

    private <T> void printCtFieldAccess(spoon.reflect.code.CtFieldAccess<T> f) {
        enterCtExpression(f);
        try (final spoon.reflect.visitor.PrintingContext.Writable _context = context.modify()) {
            if ((f.getVariable().isStatic()) && ((f.getTarget()) instanceof spoon.reflect.code.CtTypeAccess)) {
                _context.ignoreGenerics(true);
            }
            spoon.reflect.code.CtExpression<?> target = f.getTarget();
            if (target != null) {
                boolean isInitializeStaticFinalField = isInitializeStaticFinalField(f.getTarget());
                boolean isStaticField = f.getVariable().isStatic();
                boolean isImportedField = importsContext.isImported(f.getVariable());
                if ((!isInitializeStaticFinalField) && (!(isStaticField && isImportedField))) {
                    if (target.isImplicit()) {
                        final spoon.reflect.declaration.CtField<?> field = f.getVariable().getFieldDeclaration();
                        final java.lang.String fieldName = (field != null) ? field.getSimpleName() : new java.lang.String();
                        spoon.reflect.declaration.CtVariable<?> var = f.getVariable().map(new spoon.reflect.visitor.filter.PotentialVariableDeclarationFunction(fieldName)).first();
                        if (var != field) {
                            target.setImplicit(false);
                        }
                    }
                    printer.snapshotLength();
                    scan(target);
                    if (printer.hasNewContent()) {
                        printer.write(".");
                    }
                }
                _context.ignoreStaticAccess(true);
            }
            scan(f.getVariable());
        }
        exitCtExpression(f);
    }

    private <T> boolean isInitializeStaticFinalField(spoon.reflect.code.CtExpression<T> targetExp) {
        final spoon.reflect.declaration.CtElement parent;
        final spoon.reflect.declaration.CtAnonymousExecutable anonymousParent;
        try {
            parent = targetExp.getParent();
            anonymousParent = targetExp.getParent(spoon.reflect.declaration.CtAnonymousExecutable.class);
        } catch (spoon.reflect.declaration.ParentNotInitializedException e) {
            return false;
        }
        if ((((((parent instanceof spoon.reflect.code.CtFieldWrite) && (targetExp.equals(((spoon.reflect.code.CtFieldWrite) (parent)).getTarget()))) && (anonymousParent != null)) && ((((spoon.reflect.code.CtFieldWrite) (parent)).getVariable()) != null)) && (((spoon.reflect.code.CtFieldWrite) (parent)).getVariable().getModifiers().contains(spoon.reflect.declaration.ModifierKind.STATIC))) && (((spoon.reflect.code.CtFieldWrite) (parent)).getVariable().getModifiers().contains(spoon.reflect.declaration.ModifierKind.FINAL))) {
            return true;
        }
        return false;
    }

    @java.lang.Override
    public <T> void visitCtThisAccess(spoon.reflect.code.CtThisAccess<T> thisAccess) {
        try {
            enterCtExpression(thisAccess);
            spoon.reflect.code.CtTypeAccess target = ((spoon.reflect.code.CtTypeAccess) (thisAccess.getTarget()));
            spoon.reflect.reference.CtTypeReference targetType = target.getAccessedType();
            if (thisAccess.isImplicit()) {
                return ;
            }
            if ((targetType == null) || (((thisAccess.getParent(spoon.reflect.declaration.CtType.class)) != null) && (thisAccess.getParent(spoon.reflect.declaration.CtType.class).isTopLevel()))) {
                printer.write("this");
                return ;
            }
            if (targetType.isAnonymous()) {
                printer.write("this");
                return ;
            }
            if (!(context.currentThis.isEmpty())) {
                spoon.reflect.declaration.CtType lastType = context.currentThis.peekFirst().type;
                java.lang.String lastTypeQualifiedName = lastType.getQualifiedName();
                java.lang.String targetTypeQualifiedName = targetType.getQualifiedName();
                if (!(lastTypeQualifiedName.equals(targetTypeQualifiedName))) {
                    printer.snapshotLength();
                    visitCtTypeReferenceWithoutGenerics(targetType);
                    if (printer.hasNewContent()) {
                        printer.write(".");
                    }
                    printer.write("this");
                    return ;
                }
            }
            printer.write("this");
        } finally {
            exitCtExpression(thisAccess);
        }
    }

    @java.lang.Override
    public <T> void visitCtSuperAccess(spoon.reflect.code.CtSuperAccess<T> f) {
        enterCtExpression(f);
        if ((f.getTarget()) != null) {
            scan(f.getTarget());
            printer.write(".");
        }
        printer.write("super");
        exitCtExpression(f);
    }

    @java.lang.Override
    public void visitCtJavaDoc(spoon.reflect.code.CtJavaDoc comment) {
        visitCtComment(comment);
    }

    @java.lang.Override
    public void visitCtJavaDocTag(spoon.reflect.code.CtJavaDocTag docTag) {
        printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.COMMENT_STAR);
        printer.write(spoon.reflect.code.CtJavaDocTag.JAVADOC_TAG_PREFIX);
        printer.write(docTag.getType().name().toLowerCase());
        printer.write(" ");
        if (docTag.getType().hasParam()) {
            printer.write(docTag.getParam()).writeln().writeTabs();
        }
        java.lang.String[] tagLines = docTag.getContent().split(spoon.reflect.visitor.DefaultJavaPrettyPrinter.LINE_SEPARATORS_RE);
        for (int i = 0; i < (tagLines.length); i++) {
            java.lang.String com = tagLines[i];
            if ((i > 0) || (docTag.getType().hasParam())) {
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.COMMENT_STAR);
            }
            if (docTag.getType().hasParam()) {
                printer.write("\t\t");
            }
            printer.write(com.trim()).writeln().writeTabs();
        }
    }

    @java.lang.Override
    public void visitCtComment(spoon.reflect.code.CtComment comment) {
        if ((!(env.isCommentsEnabled())) && ((context.elementStack.size()) > 1)) {
            return ;
        }
        switch (comment.getCommentType()) {
            case FILE :
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.JAVADOC_START).writeln();
                break;
            case JAVADOC :
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.JAVADOC_START).writeln().writeTabs();
                break;
            case INLINE :
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.INLINE_COMMENT_START);
                break;
            case BLOCK :
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.BLOCK_COMMENT_START);
                break;
        }
        java.lang.String content = comment.getContent();
        switch (comment.getCommentType()) {
            case INLINE :
                printer.write(content);
                break;
            default :
                java.lang.String[] lines = content.split(spoon.reflect.visitor.DefaultJavaPrettyPrinter.LINE_SEPARATORS_RE);
                for (int i = 0; i < (lines.length); i++) {
                    java.lang.String com = lines[i];
                    if ((comment.getCommentType()) == (spoon.reflect.code.CtComment.CommentType.BLOCK)) {
                        printer.write(com);
                        if ((lines.length) > 1) {
                            printer.writeln().writeTabs();
                        }
                    }else {
                        if ((com.length()) > 0) {
                            printer.write(((spoon.reflect.visitor.DefaultJavaPrettyPrinter.COMMENT_STAR) + com)).writeln().writeTabs();
                        }else {
                            printer.write((" *" + com)).writeln().writeTabs();
                        }
                    }
                }
                if (comment instanceof spoon.reflect.code.CtJavaDoc) {
                    if (!(((spoon.reflect.code.CtJavaDoc) (comment)).getTags().isEmpty())) {
                        printer.write(" *").writeln().writeTabs();
                    }
                    for (spoon.reflect.code.CtJavaDocTag docTag : ((spoon.reflect.code.CtJavaDoc) (comment)).getTags()) {
                        scan(docTag);
                    }
                }
                break;
        }
        switch (comment.getCommentType()) {
            case BLOCK :
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.BLOCK_COMMENT_END);
                break;
            case FILE :
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.BLOCK_COMMENT_END);
                break;
            case JAVADOC :
                printer.write(spoon.reflect.visitor.DefaultJavaPrettyPrinter.BLOCK_COMMENT_END);
                break;
        }
    }

    @java.lang.Override
    public <T> void visitCtAnnotationFieldAccess(spoon.reflect.code.CtAnnotationFieldAccess<T> annotationFieldAccess) {
        enterCtExpression(annotationFieldAccess);
        try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify()) {
            if ((annotationFieldAccess.getTarget()) != null) {
                scan(annotationFieldAccess.getTarget());
                printer.write(".");
                _context.ignoreStaticAccess(true);
            }
            _context.ignoreGenerics(true);
            scan(annotationFieldAccess.getVariable());
            printer.write("()");
        }
        exitCtExpression(annotationFieldAccess);
    }

    @java.lang.Override
    public <T> void visitCtFieldReference(spoon.reflect.reference.CtFieldReference<T> reference) {
        boolean isStatic = (reference.getSimpleName().equals("class")) || ((!(reference.getSimpleName().equals("super"))) && (reference.isStatic()));
        boolean printType = true;
        if ((reference.isFinal()) && (reference.isStatic())) {
            spoon.reflect.reference.CtTypeReference<?> declTypeRef = reference.getDeclaringType();
            if (declTypeRef.isAnonymous()) {
                printType = false;
            }else {
                if (context.isInCurrentScope(declTypeRef)) {
                    printType = false;
                }
            }
        }
        if ((isStatic && printType) && (!(context.ignoreStaticAccess()))) {
            try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify().ignoreGenerics(true)) {
                scan(reference.getDeclaringType());
            }
            printer.write(".");
        }
        printer.write(reference.getSimpleName());
    }

    @java.lang.Override
    public void visitCtFor(spoon.reflect.code.CtFor forLoop) {
        enterCtStatement(forLoop);
        printer.write("for (");
        java.util.List<spoon.reflect.code.CtStatement> st = forLoop.getForInit();
        if ((st.size()) > 0) {
            scan(st.get(0));
        }
        if ((st.size()) > 1) {
            try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify().noTypeDecl(true)) {
                for (int i = 1; i < (st.size()); i++) {
                    printer.write(", ");
                    scan(st.get(i));
                }
            }
        }
        printer.write("; ");
        scan(forLoop.getExpression());
        printer.write(";");
        if (!(forLoop.getForUpdate().isEmpty())) {
            printer.write(" ");
        }
        try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter(null, " , ", null)) {
            for (spoon.reflect.code.CtStatement s : forLoop.getForUpdate()) {
                lp.printSeparatorIfAppropriate();
                scan(s);
            }
        }
        printer.write(")");
        elementPrinterHelper.writeIfOrLoopBlock(forLoop.getBody());
    }

    @java.lang.Override
    public void visitCtForEach(spoon.reflect.code.CtForEach foreach) {
        enterCtStatement(foreach);
        printer.write("for (");
        scan(foreach.getVariable());
        printer.write(" : ");
        scan(foreach.getExpression());
        printer.write(")");
        elementPrinterHelper.writeIfOrLoopBlock(foreach.getBody());
    }

    @java.lang.Override
    public void visitCtIf(spoon.reflect.code.CtIf ifElement) {
        enterCtStatement(ifElement);
        printer.write("if (");
        scan(ifElement.getCondition());
        printer.write(")");
        elementPrinterHelper.writeIfOrLoopBlock(ifElement.getThenStatement());
        if ((ifElement.getElseStatement()) != null) {
            java.util.List<spoon.reflect.code.CtComment> comments = elementPrinterHelper.getComments(ifElement, spoon.reflect.visitor.printer.CommentOffset.INSIDE);
            for (spoon.reflect.code.CtComment comment : comments) {
                spoon.reflect.cu.SourcePosition thenPosition = ((ifElement.getThenStatement().getPosition()) == null) ? ((spoon.reflect.code.CtBlock) (ifElement.getThenStatement())).getStatement(0).getPosition() : ifElement.getThenStatement().getPosition();
                if ((comment.getPosition().getSourceStart()) > (thenPosition.getSourceEnd())) {
                    elementPrinterHelper.writeComment(comment);
                }
            }
            printer.write("else");
            elementPrinterHelper.writeIfOrLoopBlock(ifElement.getElseStatement());
        }
    }

    @java.lang.Override
    public <T> void visitCtInterface(spoon.reflect.declaration.CtInterface<T> intrface) {
        visitCtType(intrface);
        printer.write(("interface " + (intrface.getSimpleName())));
        if ((intrface.getFormalCtTypeParameters()) != null) {
            elementPrinterHelper.writeFormalTypeParameters(intrface);
        }
        if ((intrface.getSuperInterfaces().size()) > 0) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter(" extends ", " , ", null)) {
                for (spoon.reflect.reference.CtTypeReference<?> ref : intrface.getSuperInterfaces()) {
                    lp.printSeparatorIfAppropriate();
                    scan(ref);
                }
            }
        }
        context.pushCurrentThis(intrface);
        printer.write(" {").incTab();
        elementPrinterHelper.writeElementList(intrface.getTypeMembers());
        printer.decTab().writeTabs().write("}");
        context.popCurrentThis();
    }

    @java.lang.Override
    public <T> void visitCtInvocation(spoon.reflect.code.CtInvocation<T> invocation) {
        enterCtStatement(invocation);
        enterCtExpression(invocation);
        if (invocation.getExecutable().isConstructor()) {
            elementPrinterHelper.writeActualTypeArguments(invocation.getExecutable());
            spoon.reflect.declaration.CtType<?> parentType;
            try {
                parentType = invocation.getParent(spoon.reflect.declaration.CtType.class);
            } catch (spoon.reflect.declaration.ParentNotInitializedException e) {
                parentType = null;
            }
            if (((parentType != null) && ((parentType.getQualifiedName()) != null)) && (parentType.getQualifiedName().equals(invocation.getExecutable().getDeclaringType().getQualifiedName()))) {
                printer.write("this");
            }else {
                printer.snapshotLength();
                scan(invocation.getTarget());
                if (printer.hasNewContent()) {
                    printer.write(".");
                }
                printer.write("super");
            }
        }else {
            printer.snapshotLength();
            if (!(this.importsContext.isImported(invocation.getExecutable()))) {
                try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify()) {
                    if ((invocation.getTarget()) instanceof spoon.reflect.code.CtTypeAccess) {
                        _context.ignoreGenerics(true);
                    }
                    scan(invocation.getTarget());
                }
                if (printer.hasNewContent()) {
                    printer.write(".");
                }
            }
            elementPrinterHelper.writeActualTypeArguments(invocation);
            if (env.isPreserveLineNumbers()) {
                printer.adjustStartPosition(invocation);
            }
            printer.write(invocation.getExecutable().getSimpleName());
        }
        try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("(", ", ", ")")) {
            for (spoon.reflect.code.CtExpression<?> e : invocation.getArguments()) {
                lp.printSeparatorIfAppropriate();
                scan(e);
            }
        }
        exitCtExpression(invocation);
    }

    @java.lang.Override
    public <T> void visitCtLiteral(spoon.reflect.code.CtLiteral<T> literal) {
        enterCtExpression(literal);
        if ((literal.getValue()) == null) {
            printer.write("null");
        }else
            if ((literal.getValue()) instanceof java.lang.Long) {
                printer.write(((literal.getValue()) + "L"));
            }else
                if ((literal.getValue()) instanceof java.lang.Float) {
                    printer.write(((literal.getValue()) + "F"));
                }else
                    if ((literal.getValue()) instanceof java.lang.Character) {
                        printer.write("'");
                        boolean mayContainsSpecialCharacter = true;
                        spoon.reflect.cu.SourcePosition position = literal.getPosition();
                        if (position != null) {
                            int stringLength = ((position.getSourceEnd()) - (position.getSourceStart())) - 1;
                            mayContainsSpecialCharacter = stringLength != 1;
                        }
                        printer.writeCharLiteral(((java.lang.Character) (literal.getValue())), mayContainsSpecialCharacter);
                        printer.write("'");
                    }else
                        if ((literal.getValue()) instanceof java.lang.String) {
                            printer.write('\"');
                            boolean mayContainsSpecialCharacters = true;
                            spoon.reflect.cu.SourcePosition position = literal.getPosition();
                            if (position != null) {
                                int stringLength = ((position.getSourceEnd()) - (position.getSourceStart())) - 1;
                                mayContainsSpecialCharacters = (((java.lang.String) (literal.getValue())).length()) != stringLength;
                            }
                            printer.writeStringLiteral(((java.lang.String) (literal.getValue())), mayContainsSpecialCharacters);
                            printer.write('\"');
                        }else
                            if ((literal.getValue()) instanceof java.lang.Class) {
                                printer.write(((java.lang.Class<?>) (literal.getValue())).getName());
                            }else {
                                printer.write(literal.getValue().toString());
                            }
                        
                    
                
            
        
        exitCtExpression(literal);
    }

    @java.lang.Override
    public <T> void visitCtLocalVariable(spoon.reflect.code.CtLocalVariable<T> localVariable) {
        if (!(context.noTypeDecl())) {
            enterCtStatement(localVariable);
        }
        if (env.isPreserveLineNumbers()) {
            printer.adjustStartPosition(localVariable);
        }
        if (!(context.noTypeDecl())) {
            elementPrinterHelper.writeModifiers(localVariable);
            scan(localVariable.getType());
            printer.write(" ");
        }
        printer.write(localVariable.getSimpleName());
        if ((localVariable.getDefaultExpression()) != null) {
            printer.write(" = ");
            scan(localVariable.getDefaultExpression());
        }
    }

    @java.lang.Override
    public <T> void visitCtLocalVariableReference(spoon.reflect.reference.CtLocalVariableReference<T> reference) {
        printer.write(reference.getSimpleName());
    }

    @java.lang.Override
    public <T> void visitCtCatchVariable(spoon.reflect.code.CtCatchVariable<T> catchVariable) {
        if (env.isPreserveLineNumbers()) {
            printer.adjustStartPosition(catchVariable);
        }
        elementPrinterHelper.writeModifiers(catchVariable);
        scan(catchVariable.getType());
        printer.write(" ");
        printer.write(catchVariable.getSimpleName());
    }

    @java.lang.Override
    public <T> void visitCtCatchVariableReference(spoon.reflect.reference.CtCatchVariableReference<T> reference) {
        printer.write(reference.getSimpleName());
    }

    @java.lang.Override
    public <T> void visitCtMethod(spoon.reflect.declaration.CtMethod<T> m) {
        elementPrinterHelper.writeComment(m);
        elementPrinterHelper.visitCtNamedElement(m, sourceCompilationUnit);
        elementPrinterHelper.writeModifiers(m);
        if (m.isDefaultMethod()) {
            printer.write("default ");
        }
        elementPrinterHelper.writeFormalTypeParameters(m);
        if ((m.getFormalCtTypeParameters().size()) > 0) {
            printer.write(' ');
        }
        try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify().ignoreGenerics(false)) {
            scan(m.getType());
        }
        printer.write(" ");
        printer.write(m.getSimpleName());
        elementPrinterHelper.writeExecutableParameters(m);
        elementPrinterHelper.writeThrowsClause(m);
        if ((m.getBody()) != null) {
            printer.write(" ");
            scan(m.getBody());
            if ((m.getBody().getPosition()) != null) {
                if ((m.getBody().getPosition().getCompilationUnit()) == (sourceCompilationUnit)) {
                    if ((m.getBody().getStatements().isEmpty()) || (!((m.getBody().getStatements().get(((m.getBody().getStatements().size()) - 1))) instanceof spoon.reflect.code.CtReturn))) {
                        printer.putLineNumberMapping(m.getBody().getPosition().getEndLine());
                    }
                }else {
                    printer.undefineLine();
                }
            }else {
                printer.undefineLine();
            }
        }else {
            printer.write(";");
        }
    }

    @java.lang.Override
    public <T> void visitCtAnnotationMethod(spoon.reflect.declaration.CtAnnotationMethod<T> annotationMethod) {
        elementPrinterHelper.writeComment(annotationMethod);
        elementPrinterHelper.visitCtNamedElement(annotationMethod, sourceCompilationUnit);
        elementPrinterHelper.writeModifiers(annotationMethod);
        scan(annotationMethod.getType());
        printer.write(" ");
        printer.write(annotationMethod.getSimpleName());
        printer.write("()");
        if ((annotationMethod.getDefaultExpression()) != null) {
            printer.write(" default ");
            scan(annotationMethod.getDefaultExpression());
        }
        printer.write(";");
    }

    @java.lang.Override
    @java.lang.SuppressWarnings(value = "rawtypes")
    public <T> void visitCtNewArray(spoon.reflect.code.CtNewArray<T> newArray) {
        enterCtExpression(newArray);
        boolean isNotInAnnotation;
        try {
            isNotInAnnotation = ((newArray.getParent(spoon.reflect.declaration.CtAnnotationType.class)) == null) && ((newArray.getParent(spoon.reflect.declaration.CtAnnotation.class)) == null);
        } catch (spoon.reflect.declaration.ParentNotInitializedException e) {
            isNotInAnnotation = true;
        }
        if (isNotInAnnotation) {
            spoon.reflect.reference.CtTypeReference<?> ref = newArray.getType();
            if (ref != null) {
                printer.write("new ");
            }
            try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify().skipArray(true)) {
                scan(ref);
            }
            for (int i = 0; ref instanceof spoon.reflect.reference.CtArrayTypeReference; i++) {
                printer.write("[");
                if ((newArray.getDimensionExpressions().size()) > i) {
                    spoon.reflect.code.CtExpression<java.lang.Integer> e = newArray.getDimensionExpressions().get(i);
                    scan(e);
                }
                printer.write("]");
                ref = ((spoon.reflect.reference.CtArrayTypeReference) (ref)).getComponentType();
            }
        }
        if ((newArray.getDimensionExpressions().size()) == 0) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("{ ", " , ", " }")) {
                for (spoon.reflect.code.CtExpression e : newArray.getElements()) {
                    lp.printSeparatorIfAppropriate();
                    scan(e);
                }
                elementPrinterHelper.writeComment(newArray, spoon.reflect.visitor.printer.CommentOffset.INSIDE);
            }
        }
        elementPrinterHelper.writeComment(newArray, spoon.reflect.visitor.printer.CommentOffset.AFTER);
        exitCtExpression(newArray);
    }

    @java.lang.Override
    public <T> void visitCtConstructorCall(spoon.reflect.code.CtConstructorCall<T> ctConstructorCall) {
        enterCtStatement(ctConstructorCall);
        enterCtExpression(ctConstructorCall);
        printConstructorCall(ctConstructorCall);
        exitCtExpression(ctConstructorCall);
    }

    @java.lang.Override
    public <T> void visitCtNewClass(spoon.reflect.code.CtNewClass<T> newClass) {
        enterCtStatement(newClass);
        enterCtExpression(newClass);
        printConstructorCall(newClass);
        scan(newClass.getAnonymousClass());
        exitCtExpression(newClass);
    }

    private <T> void printConstructorCall(spoon.reflect.code.CtConstructorCall<T> ctConstructorCall) {
        try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify()) {
            if ((ctConstructorCall.getTarget()) != null) {
                scan(ctConstructorCall.getTarget());
                printer.write(".");
                _context.ignoreEnclosingClass(true);
            }
            if (hasDeclaringTypeWithGenerics(ctConstructorCall.getType())) {
                _context.ignoreEnclosingClass(true);
            }
            printer.write("new ");
            if ((ctConstructorCall.getActualTypeArguments().size()) > 0) {
                elementPrinterHelper.writeActualTypeArguments(ctConstructorCall);
            }
            scan(ctConstructorCall.getType());
        }
        try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("(", ", ", ")")) {
            for (spoon.reflect.code.CtCodeElement exp : ctConstructorCall.getArguments()) {
                lp.printSeparatorIfAppropriate();
                scan(exp);
            }
        }
    }

    private <T> boolean hasDeclaringTypeWithGenerics(spoon.reflect.reference.CtTypeReference<T> reference) {
        if (reference == null) {
            return false;
        }
        if ((reference.getDeclaringType()) == null) {
            return false;
        }
        if (reference.isLocalType()) {
            return false;
        }
        if ((reference.getDeclaringType().getActualTypeArguments().size()) != 0) {
            return true;
        }
        return hasDeclaringTypeWithGenerics(reference.getDeclaringType());
    }

    @java.lang.Override
    public <T> void visitCtLambda(spoon.reflect.code.CtLambda<T> lambda) {
        enterCtExpression(lambda);
        try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("(", ",", ") -> ")) {
            if ((lambda.getParameters().size()) > 0) {
                for (spoon.reflect.declaration.CtParameter<?> parameter : lambda.getParameters()) {
                    lp.printSeparatorIfAppropriate();
                    scan(parameter);
                }
            }
        }
        if ((lambda.getBody()) != null) {
            scan(lambda.getBody());
        }else {
            scan(lambda.getExpression());
        }
        exitCtExpression(lambda);
    }

    @java.lang.Override
    public <T, E extends spoon.reflect.code.CtExpression<?>> void visitCtExecutableReferenceExpression(spoon.reflect.code.CtExecutableReferenceExpression<T, E> expression) {
        enterCtExpression(expression);
        scan(expression.getTarget());
        printer.write("::");
        if (expression.getExecutable().isConstructor()) {
            printer.write("new");
        }else {
            printer.write(expression.getExecutable().getSimpleName());
        }
        exitCtExpression(expression);
    }

    @java.lang.Override
    public <T, A extends T> void visitCtOperatorAssignment(spoon.reflect.code.CtOperatorAssignment<T, A> assignment) {
        enterCtStatement(assignment);
        enterCtExpression(assignment);
        scan(assignment.getAssigned());
        printer.write(" ");
        printer.writeOperator(assignment.getKind());
        printer.write("= ");
        scan(assignment.getAssignment());
        exitCtExpression(assignment);
    }

    @java.lang.Override
    public void visitCtPackage(spoon.reflect.declaration.CtPackage ctPackage) {
        if (!(ctPackage.isUnnamedPackage())) {
            printer.write((("package " + (ctPackage.getQualifiedName())) + ";"));
        }else {
            printer.write("// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)\n");
        }
    }

    @java.lang.Override
    public void visitCtPackageReference(spoon.reflect.reference.CtPackageReference reference) {
        printer.write(reference.getSimpleName());
    }

    @java.lang.Override
    public <T> void visitCtParameter(spoon.reflect.declaration.CtParameter<T> parameter) {
        elementPrinterHelper.writeComment(parameter);
        elementPrinterHelper.writeAnnotations(parameter);
        elementPrinterHelper.writeModifiers(parameter);
        if (parameter.isVarArgs()) {
            scan(((spoon.reflect.reference.CtArrayTypeReference<T>) (parameter.getType())).getComponentType());
            printer.write("...");
        }else {
            scan(parameter.getType());
        }
        printer.write(" ");
        printer.write(parameter.getSimpleName());
    }

    @java.lang.Override
    public <T> void visitCtParameterReference(spoon.reflect.reference.CtParameterReference<T> reference) {
        printer.write(reference.getSimpleName());
    }

    @java.lang.Override
    public <R> void visitCtReturn(spoon.reflect.code.CtReturn<R> returnStatement) {
        enterCtStatement(returnStatement);
        printer.write("return ");
        scan(returnStatement.getReturnedExpression());
    }

    private <T> void visitCtType(spoon.reflect.declaration.CtType<T> type) {
        elementPrinterHelper.writeComment(type, spoon.reflect.visitor.printer.CommentOffset.BEFORE);
        printer.mapLine(type, sourceCompilationUnit);
        if (type.isTopLevel()) {
            context.currentTopLevel = type;
        }
        elementPrinterHelper.visitCtNamedElement(type, sourceCompilationUnit);
        elementPrinterHelper.writeModifiers(type);
    }

    @java.lang.Override
    public void visitCtStatementList(spoon.reflect.code.CtStatementList statements) {
        for (spoon.reflect.code.CtStatement s : statements.getStatements()) {
            scan(s);
        }
    }

    @java.lang.Override
    public <E> void visitCtSwitch(spoon.reflect.code.CtSwitch<E> switchStatement) {
        enterCtStatement(switchStatement);
        printer.write("switch (");
        scan(switchStatement.getSelector());
        printer.write(") {").incTab();
        for (spoon.reflect.code.CtCase<?> c : switchStatement.getCases()) {
            printer.writeln().writeTabs();
            scan(c);
        }
        if (env.isPreserveLineNumbers()) {
            printer.decTab().write("}");
        }else {
            printer.decTab().writeln().writeTabs().write("}");
        }
    }

    @java.lang.Override
    public void visitCtSynchronized(spoon.reflect.code.CtSynchronized synchro) {
        enterCtStatement(synchro);
        printer.write("synchronized");
        if ((synchro.getExpression()) != null) {
            printer.write("(");
            scan(synchro.getExpression());
            printer.write(") ");
        }
        scan(synchro.getBlock());
    }

    @java.lang.Override
    public void visitCtThrow(spoon.reflect.code.CtThrow throwStatement) {
        enterCtStatement(throwStatement);
        printer.write("throw ");
        scan(throwStatement.getThrownExpression());
    }

    @java.lang.Override
    public void visitCtTry(spoon.reflect.code.CtTry tryBlock) {
        enterCtStatement(tryBlock);
        printer.write("try ");
        scan(tryBlock.getBody());
        for (spoon.reflect.code.CtCatch c : tryBlock.getCatchers()) {
            scan(c);
        }
        if ((tryBlock.getFinalizer()) != null) {
            printer.write(" finally ");
            scan(tryBlock.getFinalizer());
        }
    }

    @java.lang.Override
    public void visitCtTryWithResource(spoon.reflect.code.CtTryWithResource tryWithResource) {
        enterCtStatement(tryWithResource);
        printer.write("try ");
        if (((tryWithResource.getResources()) != null) && (!(tryWithResource.getResources().isEmpty()))) {
            try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter("(", ";", ") ")) {
                for (spoon.reflect.code.CtLocalVariable<?> r : tryWithResource.getResources()) {
                    lp.printSeparatorIfAppropriate();
                    scan(r);
                }
            }
        }
        scan(tryWithResource.getBody());
        for (spoon.reflect.code.CtCatch c : tryWithResource.getCatchers()) {
            scan(c);
        }
        if ((tryWithResource.getFinalizer()) != null) {
            printer.write(" finally ");
            scan(tryWithResource.getFinalizer());
        }
    }

    @java.lang.Override
    public void visitCtTypeParameterReference(spoon.reflect.reference.CtTypeParameterReference ref) {
        if (ref.isImplicit()) {
            return ;
        }
        elementPrinterHelper.writeAnnotations(ref);
        if (printQualified(ref)) {
            printer.write(ref.getQualifiedName());
        }else {
            printer.write(ref.getSimpleName());
        }
    }

    @java.lang.Override
    public void visitCtWildcardReference(spoon.reflect.reference.CtWildcardReference wildcardReference) {
        if (wildcardReference.isImplicit()) {
            return ;
        }
        elementPrinterHelper.writeAnnotations(wildcardReference);
        if (printQualified(wildcardReference)) {
            printer.write(wildcardReference.getQualifiedName());
        }else {
            printer.write(wildcardReference.getSimpleName());
        }
        if ((wildcardReference.getBoundingType()) != null) {
            if (wildcardReference.isUpper()) {
                printer.write(" extends ");
            }else {
                printer.write(" super ");
            }
            scan(wildcardReference.getBoundingType());
        }
    }

    private boolean printQualified(spoon.reflect.reference.CtTypeReference<?> ref) {
        if ((importsContext.isImported(ref)) || (((this.env.isAutoImports()) && ((ref.getPackage()) != null)) && (ref.getPackage().getSimpleName().equals("java.lang")))) {
            for (spoon.reflect.visitor.TypeContext typeContext : context.currentThis) {
                if ((typeContext.getSimpleName().equals(ref.getSimpleName())) && (!(java.util.Objects.equals(typeContext.getPackage(), ref.getPackage())))) {
                    return true;
                }
                if (typeContext.isNameConflict(ref.getSimpleName())) {
                    return true;
                }
            }
            return false;
        }else {
            return true;
        }
    }

    @java.lang.Override
    public <T> void visitCtIntersectionTypeReference(spoon.reflect.reference.CtIntersectionTypeReference<T> reference) {
        try (spoon.reflect.visitor.printer.ListPrinter lp = printer.createListPrinter(null, " & ", null)) {
            for (spoon.reflect.reference.CtTypeReference<?> bound : reference.getBounds()) {
                lp.printSeparatorIfAppropriate();
                scan(bound);
            }
        }
    }

    @java.lang.Override
    public <T> void visitCtTypeReference(spoon.reflect.reference.CtTypeReference<T> ref) {
        visitCtTypeReference(ref, true);
    }

    @java.lang.Override
    public <T> void visitCtTypeAccess(spoon.reflect.code.CtTypeAccess<T> typeAccess) {
        if (typeAccess.isImplicit()) {
            return ;
        }
        enterCtExpression(typeAccess);
        scan(typeAccess.getAccessedType());
        exitCtExpression(typeAccess);
    }

    private void visitCtTypeReferenceWithoutGenerics(spoon.reflect.reference.CtTypeReference<?> ref) {
        visitCtTypeReference(ref, false);
    }

    private void visitCtTypeReference(spoon.reflect.reference.CtTypeReference<?> ref, boolean withGenerics) {
        if (ref.isImplicit()) {
            return ;
        }
        if (ref.isPrimitive()) {
            elementPrinterHelper.writeAnnotations(ref);
            printer.write(ref.getSimpleName());
            return ;
        }
        boolean isInner = (ref.getDeclaringType()) != null;
        if (isInner) {
            if ((!(context.ignoreEnclosingClass())) && (!(ref.isLocalType()))) {
                spoon.reflect.reference.CtTypeReference<?> accessType = ref.getAccessType();
                if (!(accessType.isAnonymous())) {
                    try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify()) {
                        if (!withGenerics) {
                            _context.ignoreGenerics(true);
                        }
                        scan(accessType);
                    }
                    printer.write(".");
                }
            }
            elementPrinterHelper.writeAnnotations(ref);
            if (ref.isLocalType()) {
                printer.write(ref.getSimpleName().replaceAll("^[0-9]*", ""));
            }else {
                printer.write(ref.getSimpleName());
            }
        }else {
            if (((ref.getPackage()) != null) && (printQualified(ref))) {
                if (!(ref.getPackage().isUnnamedPackage())) {
                    scan(ref.getPackage());
                    printer.write(spoon.reflect.declaration.CtPackage.PACKAGE_SEPARATOR);
                }
            }
            elementPrinterHelper.writeAnnotations(ref);
            printer.write(ref.getSimpleName());
        }
        if (withGenerics && (!(context.ignoreGenerics()))) {
            try (spoon.reflect.visitor.PrintingContext.Writable _context = context.modify().ignoreEnclosingClass(false)) {
                elementPrinterHelper.writeActualTypeArguments(ref);
            }
        }
    }

    @java.lang.Override
    public <T> void visitCtUnaryOperator(spoon.reflect.code.CtUnaryOperator<T> operator) {
        enterCtStatement(operator);
        enterCtExpression(operator);
        printer.preWriteUnaryOperator(operator.getKind());
        scan(operator.getOperand());
        printer.postWriteUnaryOperator(operator.getKind());
        exitCtExpression(operator);
    }

    @java.lang.Override
    public <T> void visitCtVariableRead(spoon.reflect.code.CtVariableRead<T> variableRead) {
        enterCtExpression(variableRead);
        printer.write(variableRead.getVariable().getSimpleName());
        exitCtExpression(variableRead);
    }

    @java.lang.Override
    public <T> void visitCtVariableWrite(spoon.reflect.code.CtVariableWrite<T> variableWrite) {
        enterCtExpression(variableWrite);
        printer.write(variableWrite.getVariable().getSimpleName());
        exitCtExpression(variableWrite);
    }

    public void visitCtWhile(spoon.reflect.code.CtWhile whileLoop) {
        enterCtStatement(whileLoop);
        printer.write("while (");
        scan(whileLoop.getLoopingExpression());
        printer.write(")");
        elementPrinterHelper.writeIfOrLoopBlock(whileLoop.getBody());
    }

    @java.lang.Override
    public <T> void visitCtCodeSnippetExpression(spoon.reflect.code.CtCodeSnippetExpression<T> expression) {
        elementPrinterHelper.writeComment(expression);
        printer.write(expression.getValue());
    }

    @java.lang.Override
    public void visitCtCodeSnippetStatement(spoon.reflect.code.CtCodeSnippetStatement statement) {
        elementPrinterHelper.writeComment(statement);
        printer.write(statement.getValue());
    }

    public spoon.reflect.visitor.printer.ElementPrinterHelper getElementPrinterHelper() {
        return elementPrinterHelper;
    }

    public spoon.reflect.visitor.PrintingContext getContext() {
        return context;
    }

    @java.lang.Override
    public <T> void visitCtUnboundVariableReference(spoon.reflect.reference.CtUnboundVariableReference<T> reference) {
        printer.write(reference.getSimpleName());
    }

    @java.lang.Override
    public java.lang.String getPackageDeclaration() {
        return printPackageInfo(context.currentTopLevel.getPackage());
    }

    @java.lang.Override
    public java.lang.String printPackageInfo(spoon.reflect.declaration.CtPackage pack) {
        spoon.reflect.visitor.printer.PrinterHelper bck = printer;
        spoon.reflect.visitor.printer.ElementPrinterHelper bck2 = elementPrinterHelper;
        printer = new spoon.reflect.visitor.printer.PrinterHelper(env);
        elementPrinterHelper = new spoon.reflect.visitor.printer.ElementPrinterHelper(printer, this, env);
        elementPrinterHelper.writeComment(pack);
        elementPrinterHelper.writeAnnotations(pack);
        if (!(pack.isUnnamedPackage())) {
            printer.write((("package " + (pack.getQualifiedName())) + ";"));
        }
        java.lang.String ret = printer.toString();
        elementPrinterHelper = bck2;
        printer = bck;
        return ret;
    }

    @java.lang.Override
    public java.lang.String getResult() {
        return printer.toString();
    }

    @java.lang.Override
    public void reset() {
        printer = new spoon.reflect.visitor.printer.PrinterHelper(env);
        elementPrinterHelper.setPrinter(printer);
        context = new spoon.reflect.visitor.PrintingContext();
        if (env.isAutoImports()) {
            this.importsContext = new spoon.reflect.visitor.ImportScannerImpl();
        }else {
            this.importsContext = new spoon.reflect.visitor.MinimalImportScanner();
        }
    }

    @java.lang.Override
    public void calculate(spoon.reflect.cu.CompilationUnit sourceCompilationUnit, java.util.List<spoon.reflect.declaration.CtType<?>> types) {
        this.sourceCompilationUnit = sourceCompilationUnit;
        if (env.isAutoImports()) {
            this.importsContext = new spoon.reflect.visitor.ImportScannerImpl();
        }else {
            this.importsContext = new spoon.reflect.visitor.MinimalImportScanner();
        }
        java.util.Set<spoon.reflect.reference.CtReference> imports = new java.util.HashSet<>();
        for (spoon.reflect.declaration.CtType<?> t : types) {
            imports.addAll(computeImports(t));
        }
        elementPrinterHelper.writeHeader(types, imports);
        for (spoon.reflect.declaration.CtType<?> t : types) {
            scan(t);
            if (!(env.isPreserveLineNumbers())) {
                printer.writeln().writeln().writeTabs();
            }else {
                printer.adjustEndPosition(t);
            }
        }
    }

    @java.lang.Override
    public java.util.Map<java.lang.Integer, java.lang.Integer> getLineNumberMapping() {
        return printer.getLineNumberMapping();
    }
}

