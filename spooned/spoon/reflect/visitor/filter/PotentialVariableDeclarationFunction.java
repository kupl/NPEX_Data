package spoon.reflect.visitor.filter;


public class PotentialVariableDeclarationFunction implements spoon.reflect.visitor.chain.CtConsumableFunction<spoon.reflect.declaration.CtElement> , spoon.reflect.visitor.chain.CtQueryAware {
    private boolean isTypeOnTheWay;

    private final java.lang.String variableName;

    private spoon.reflect.visitor.chain.CtQuery query;

    public PotentialVariableDeclarationFunction() {
        this.variableName = null;
    }

    public PotentialVariableDeclarationFunction(java.lang.String variableName) {
        this.variableName = variableName;
    }

    @java.lang.Override
    public void apply(spoon.reflect.declaration.CtElement input, spoon.reflect.visitor.chain.CtConsumer<java.lang.Object> outputConsumer) {
        isTypeOnTheWay = false;
        spoon.reflect.visitor.chain.CtQuery siblingsQuery = input.getFactory().createQuery().map(new spoon.reflect.visitor.filter.SiblingsFunction().mode(spoon.reflect.visitor.filter.SiblingsFunction.Mode.PREVIOUS)).select(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.declaration.CtVariable.class));
        if ((variableName) != null) {
            siblingsQuery = siblingsQuery.select(new spoon.reflect.visitor.filter.NameFilter<>(variableName));
        }
        spoon.reflect.declaration.CtElement scopeElement = input;
        while (((scopeElement != null) && (!(scopeElement instanceof spoon.reflect.declaration.CtPackage))) && (scopeElement.isParentInitialized())) {
            spoon.reflect.declaration.CtElement parent = scopeElement.getParent();
            if (parent instanceof spoon.reflect.declaration.CtType<?>) {
                isTypeOnTheWay = true;
                java.util.Collection<spoon.reflect.reference.CtFieldReference<?>> allFields = ((spoon.reflect.declaration.CtType<?>) (parent)).getAllFields();
                for (spoon.reflect.reference.CtFieldReference<?> fieldReference : allFields) {
                    if (sendToOutput(fieldReference.getFieldDeclaration(), outputConsumer)) {
                        return ;
                    }
                }
            }else
                if ((parent instanceof spoon.reflect.code.CtBodyHolder) || (parent instanceof spoon.reflect.code.CtStatementList)) {
                    siblingsQuery.setInput(scopeElement).forEach(outputConsumer);
                    if (query.isTerminated()) {
                        return ;
                    }
                    if (parent instanceof spoon.reflect.code.CtCatch) {
                        spoon.reflect.code.CtCatch ctCatch = ((spoon.reflect.code.CtCatch) (parent));
                        if (sendToOutput(ctCatch.getParameter(), outputConsumer)) {
                            return ;
                        }
                    }else
                        if (parent instanceof spoon.reflect.declaration.CtExecutable) {
                            spoon.reflect.declaration.CtExecutable<?> exec = ((spoon.reflect.declaration.CtExecutable<?>) (parent));
                            for (spoon.reflect.declaration.CtParameter<?> param : exec.getParameters()) {
                                if (sendToOutput(param, outputConsumer)) {
                                    return ;
                                }
                            }
                        }
                    
                }
            
            scopeElement = parent;
        } 
    }

    private boolean sendToOutput(spoon.reflect.declaration.CtVariable<?> var, spoon.reflect.visitor.chain.CtConsumer<java.lang.Object> output) {
        if (((variableName) == null) || (variableName.equals(var.getSimpleName()))) {
            output.accept(var);
        }
        return query.isTerminated();
    }

    public boolean isTypeOnTheWay() {
        return isTypeOnTheWay;
    }

    @java.lang.Override
    public void setQuery(spoon.reflect.visitor.chain.CtQuery query) {
        this.query = query;
    }
}

