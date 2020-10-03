package spoon.reflect.visitor;


public class EarlyTerminatingScanner<T> extends spoon.reflect.visitor.CtScanner {
    private boolean terminate = false;

    private T result;

    private spoon.reflect.visitor.chain.CtScannerListener listener;

    protected void terminate() {
        terminate = true;
    }

    protected boolean isTerminated() {
        return terminate;
    }

    protected void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public spoon.reflect.visitor.chain.CtScannerListener getListener() {
        return listener;
    }

    public spoon.reflect.visitor.EarlyTerminatingScanner<T> setListener(spoon.reflect.visitor.chain.CtScannerListener listener) {
        this.listener = listener;
        return this;
    }

    @java.lang.Override
    public void scan(java.util.Collection<? extends spoon.reflect.declaration.CtElement> elements) {
        if ((isTerminated()) || (elements == null)) {
            return ;
        }
        for (spoon.reflect.declaration.CtElement e : new java.util.ArrayList<>(elements)) {
            scan(e);
            if (isTerminated()) {
                return ;
            }
        }
    }

    @java.lang.Override
    public void scan(spoon.reflect.declaration.CtElement element) {
        if ((element == null) || (isTerminated())) {
            return ;
        }
        if ((listener) == null) {
            doScan(element, spoon.reflect.visitor.chain.ScanningMode.NORMAL);
        }else {
            spoon.reflect.visitor.chain.ScanningMode mode = listener.enter(element);
            if (mode != (spoon.reflect.visitor.chain.ScanningMode.SKIP_ALL)) {
                doScan(element, mode);
                listener.exit(element);
            }
        }
    }

    protected void doScan(spoon.reflect.declaration.CtElement element, spoon.reflect.visitor.chain.ScanningMode mode) {
        super.scan(element);
    }

    @java.lang.Override
    public void scan(java.lang.Object o) {
        if ((isTerminated()) || (o == null)) {
            return ;
        }
        if (o instanceof spoon.reflect.declaration.CtElement) {
            scan(((spoon.reflect.declaration.CtElement) (o)));
        }else
            if (o instanceof java.util.Collection<?>) {
                scan(((java.util.Collection<? extends spoon.reflect.declaration.CtElement>) (o)));
            }else
                if (o instanceof java.util.Map<?, ?>) {
                    for (java.lang.Object obj : ((java.util.Map) (o)).values()) {
                        scan(obj);
                        if (isTerminated()) {
                            return ;
                        }
                    }
                }
            
        
    }
}

