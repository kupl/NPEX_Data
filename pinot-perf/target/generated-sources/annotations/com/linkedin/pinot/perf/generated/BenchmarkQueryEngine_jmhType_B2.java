package com.linkedin.pinot.perf.generated;
public class BenchmarkQueryEngine_jmhType_B2 extends com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B1 {
    public volatile int setupTrialMutex;

    public volatile int tearTrialMutex;

    public static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2> setupTrialMutexUpdater = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2.class, "setupTrialMutex");

    public static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2> tearTrialMutexUpdater = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2.class, "tearTrialMutex");

    public volatile int setupIterationMutex;

    public volatile int tearIterationMutex;

    public static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2> setupIterationMutexUpdater = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2.class, "setupIterationMutex");

    public static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2> tearIterationMutexUpdater = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2.class, "tearIterationMutex");

    public volatile int setupInvocationMutex;

    public volatile int tearInvocationMutex;

    public static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2> setupInvocationMutexUpdater = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2.class, "setupInvocationMutex");

    public static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2> tearInvocationMutexUpdater = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType_B2.class, "tearInvocationMutex");

    public volatile boolean readyTrial;

    public volatile boolean readyIteration;

    public volatile boolean readyInvocation;
}