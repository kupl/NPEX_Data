package com.linkedin.pinot.perf.generated;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.infra.Control;
import org.openjdk.jmh.infra.IterationParams;
import org.openjdk.jmh.infra.ThreadParams;
import org.openjdk.jmh.results.AggregationPolicy;
import org.openjdk.jmh.results.AverageTimeResult;
import org.openjdk.jmh.results.BenchmarkTaskResult;
import org.openjdk.jmh.results.RawResults;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.ResultRole;
import org.openjdk.jmh.results.SampleTimeResult;
import org.openjdk.jmh.results.ScalarResult;
import org.openjdk.jmh.results.SingleShotResult;
import org.openjdk.jmh.results.ThroughputResult;
import org.openjdk.jmh.runner.FailureAssistException;
import org.openjdk.jmh.runner.InfraControl;
import org.openjdk.jmh.util.SampleBuffer;
public final class BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest {
    boolean p000;

    boolean p001;

    boolean p002;

    boolean p003;

    boolean p004;

    boolean p005;

    boolean p006;

    boolean p007;

    boolean p008;

    boolean p009;

    boolean p010;

    boolean p011;

    boolean p012;

    boolean p013;

    boolean p014;

    boolean p015;

    boolean p016;

    boolean p017;

    boolean p018;

    boolean p019;

    boolean p020;

    boolean p021;

    boolean p022;

    boolean p023;

    boolean p024;

    boolean p025;

    boolean p026;

    boolean p027;

    boolean p028;

    boolean p029;

    boolean p030;

    boolean p031;

    boolean p032;

    boolean p033;

    boolean p034;

    boolean p035;

    boolean p036;

    boolean p037;

    boolean p038;

    boolean p039;

    boolean p040;

    boolean p041;

    boolean p042;

    boolean p043;

    boolean p044;

    boolean p045;

    boolean p046;

    boolean p047;

    boolean p048;

    boolean p049;

    boolean p050;

    boolean p051;

    boolean p052;

    boolean p053;

    boolean p054;

    boolean p055;

    boolean p056;

    boolean p057;

    boolean p058;

    boolean p059;

    boolean p060;

    boolean p061;

    boolean p062;

    boolean p063;

    boolean p064;

    boolean p065;

    boolean p066;

    boolean p067;

    boolean p068;

    boolean p069;

    boolean p070;

    boolean p071;

    boolean p072;

    boolean p073;

    boolean p074;

    boolean p075;

    boolean p076;

    boolean p077;

    boolean p078;

    boolean p079;

    boolean p080;

    boolean p081;

    boolean p082;

    boolean p083;

    boolean p084;

    boolean p085;

    boolean p086;

    boolean p087;

    boolean p088;

    boolean p089;

    boolean p090;

    boolean p091;

    boolean p092;

    boolean p093;

    boolean p094;

    boolean p095;

    boolean p096;

    boolean p097;

    boolean p098;

    boolean p099;

    boolean p100;

    boolean p101;

    boolean p102;

    boolean p103;

    boolean p104;

    boolean p105;

    boolean p106;

    boolean p107;

    boolean p108;

    boolean p109;

    boolean p110;

    boolean p111;

    boolean p112;

    boolean p113;

    boolean p114;

    boolean p115;

    boolean p116;

    boolean p117;

    boolean p118;

    boolean p119;

    boolean p120;

    boolean p121;

    boolean p122;

    boolean p123;

    boolean p124;

    boolean p125;

    boolean p126;

    boolean p127;

    boolean p128;

    boolean p129;

    boolean p130;

    boolean p131;

    boolean p132;

    boolean p133;

    boolean p134;

    boolean p135;

    boolean p136;

    boolean p137;

    boolean p138;

    boolean p139;

    boolean p140;

    boolean p141;

    boolean p142;

    boolean p143;

    boolean p144;

    boolean p145;

    boolean p146;

    boolean p147;

    boolean p148;

    boolean p149;

    boolean p150;

    boolean p151;

    boolean p152;

    boolean p153;

    boolean p154;

    boolean p155;

    boolean p156;

    boolean p157;

    boolean p158;

    boolean p159;

    boolean p160;

    boolean p161;

    boolean p162;

    boolean p163;

    boolean p164;

    boolean p165;

    boolean p166;

    boolean p167;

    boolean p168;

    boolean p169;

    boolean p170;

    boolean p171;

    boolean p172;

    boolean p173;

    boolean p174;

    boolean p175;

    boolean p176;

    boolean p177;

    boolean p178;

    boolean p179;

    boolean p180;

    boolean p181;

    boolean p182;

    boolean p183;

    boolean p184;

    boolean p185;

    boolean p186;

    boolean p187;

    boolean p188;

    boolean p189;

    boolean p190;

    boolean p191;

    boolean p192;

    boolean p193;

    boolean p194;

    boolean p195;

    boolean p196;

    boolean p197;

    boolean p198;

    boolean p199;

    boolean p200;

    boolean p201;

    boolean p202;

    boolean p203;

    boolean p204;

    boolean p205;

    boolean p206;

    boolean p207;

    boolean p208;

    boolean p209;

    boolean p210;

    boolean p211;

    boolean p212;

    boolean p213;

    boolean p214;

    boolean p215;

    boolean p216;

    boolean p217;

    boolean p218;

    boolean p219;

    boolean p220;

    boolean p221;

    boolean p222;

    boolean p223;

    boolean p224;

    boolean p225;

    boolean p226;

    boolean p227;

    boolean p228;

    boolean p229;

    boolean p230;

    boolean p231;

    boolean p232;

    boolean p233;

    boolean p234;

    boolean p235;

    boolean p236;

    boolean p237;

    boolean p238;

    boolean p239;

    boolean p240;

    boolean p241;

    boolean p242;

    boolean p243;

    boolean p244;

    boolean p245;

    boolean p246;

    boolean p247;

    boolean p248;

    boolean p249;

    boolean p250;

    boolean p251;

    boolean p252;

    boolean p253;

    boolean p254;

    boolean p255;

    int startRndMask;

    org.openjdk.jmh.infra.BenchmarkParams benchmarkParams;

    org.openjdk.jmh.infra.IterationParams iterationParams;

    org.openjdk.jmh.infra.ThreadParams threadParams;

    org.openjdk.jmh.infra.Blackhole blackhole;

    org.openjdk.jmh.infra.Control notifyControl;

    public org.openjdk.jmh.results.BenchmarkTaskResult benchmarkOffHeapMinSizeWithoutOverflow_Throughput(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 61, Element: benchmarkOffHeapMinSizeWithoutOverflow_Throughput");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 66, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 67, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 68, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 69, Element: _jmh_tryInit_f_benchmarkdictionary0_G");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G = _jmh_tryInit_f_benchmarkdictionary0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 71, Element: preSetup");
            control.preSetup();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 74, Element: announceWarmupReady");
            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 76, Element: benchmarkOffHeapMinSizeWithoutOverflow");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 76, Element: consume");
                blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
                res.allOps++;
            } 
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 81, Element: benchmarkOffHeapMinSizeWithoutOverflow_thrpt_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.benchmarkOffHeapMinSizeWithoutOverflow_thrpt_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, l_benchmarkdictionary0_G);
            notifyControl.stopMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 83, Element: announceWarmdownReady");
            control.announceWarmdownReady();
            try {
                while (control.warmdownShouldWait) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 86, Element: benchmarkOffHeapMinSizeWithoutOverflow");
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 86, Element: consume");
                    blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
                    res.allOps++;
                } 
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 89, Element: preTearDown");
                control.preTearDown();
            } catch (java.lang.InterruptedException ie) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 91, Element: preTearDownForce");
                control.preTearDownForce();
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 94, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 95, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkdictionary0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 97, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkdictionary0_G.readyTrial) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 99, Element: tearDown");
                            l_benchmarkdictionary0_G.tearDown();
                            l_benchmarkdictionary0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 106, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.set(l_benchmarkdictionary0_G, 0);
                    }
                } else {
                    long l_benchmarkdictionary0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 110, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.get(l_benchmarkdictionary0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 111, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkdictionary0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 112, Element: max");
                        l_benchmarkdictionary0_G_backoff = java.lang.Math.max(1024, l_benchmarkdictionary0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 113, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 114, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 114, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 117, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.f_benchmarkdictionary0_G = null;
                }
            }
            res.allOps += res.measuredOps;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 122, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 123, Element: getOpsPerInvocation");
            int opsPerInv = benchmarkParams.getOpsPerInvocation();
            res.allOps *= opsPerInv;
            res.allOps /= batchSize;
            res.measuredOps *= opsPerInv;
            res.measuredOps /= batchSize;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 128, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(res.allOps, res.measuredOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 129, Element: getTime");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 129, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 129, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 129, Element: add");
            results.add(new org.openjdk.jmh.results.ThroughputResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "benchmarkOffHeapMinSizeWithoutOverflow", res.measuredOps, res.getTime(), benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 133, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void benchmarkOffHeapMinSizeWithoutOverflow_thrpt_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 136, Element: benchmarkOffHeapMinSizeWithoutOverflow_thrpt_jmhStub");
        long operations = 0;
        long realTime = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 139, Element: nanoTime");
        result.startTime = java.lang.System.nanoTime();
        do {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 141, Element: benchmarkOffHeapMinSizeWithoutOverflow");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 141, Element: consume");
            blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
            operations++;
        } while (!control.isDone );
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 144, Element: nanoTime");
        result.stopTime = java.lang.System.nanoTime();
        result.realTime = realTime;
        result.measuredOps = operations;
    }

    public org.openjdk.jmh.results.BenchmarkTaskResult benchmarkOffHeapMinSizeWithoutOverflow_AverageTime(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 150, Element: benchmarkOffHeapMinSizeWithoutOverflow_AverageTime");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 155, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 156, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 157, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 158, Element: _jmh_tryInit_f_benchmarkdictionary0_G");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G = _jmh_tryInit_f_benchmarkdictionary0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 160, Element: preSetup");
            control.preSetup();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 163, Element: announceWarmupReady");
            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 165, Element: benchmarkOffHeapMinSizeWithoutOverflow");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 165, Element: consume");
                blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
                res.allOps++;
            } 
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 170, Element: benchmarkOffHeapMinSizeWithoutOverflow_avgt_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.benchmarkOffHeapMinSizeWithoutOverflow_avgt_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, l_benchmarkdictionary0_G);
            notifyControl.stopMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 172, Element: announceWarmdownReady");
            control.announceWarmdownReady();
            try {
                while (control.warmdownShouldWait) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 175, Element: benchmarkOffHeapMinSizeWithoutOverflow");
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 175, Element: consume");
                    blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
                    res.allOps++;
                } 
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 178, Element: preTearDown");
                control.preTearDown();
            } catch (java.lang.InterruptedException ie) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 180, Element: preTearDownForce");
                control.preTearDownForce();
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 183, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 184, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkdictionary0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 186, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkdictionary0_G.readyTrial) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 188, Element: tearDown");
                            l_benchmarkdictionary0_G.tearDown();
                            l_benchmarkdictionary0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 195, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.set(l_benchmarkdictionary0_G, 0);
                    }
                } else {
                    long l_benchmarkdictionary0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 199, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.get(l_benchmarkdictionary0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 200, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkdictionary0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 201, Element: max");
                        l_benchmarkdictionary0_G_backoff = java.lang.Math.max(1024, l_benchmarkdictionary0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 202, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 203, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 203, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 206, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.f_benchmarkdictionary0_G = null;
                }
            }
            res.allOps += res.measuredOps;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 211, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 212, Element: getOpsPerInvocation");
            int opsPerInv = benchmarkParams.getOpsPerInvocation();
            res.allOps *= opsPerInv;
            res.allOps /= batchSize;
            res.measuredOps *= opsPerInv;
            res.measuredOps /= batchSize;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 217, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(res.allOps, res.measuredOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 218, Element: getTime");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 218, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 218, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 218, Element: add");
            results.add(new org.openjdk.jmh.results.AverageTimeResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "benchmarkOffHeapMinSizeWithoutOverflow", res.measuredOps, res.getTime(), benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 222, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void benchmarkOffHeapMinSizeWithoutOverflow_avgt_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 225, Element: benchmarkOffHeapMinSizeWithoutOverflow_avgt_jmhStub");
        long operations = 0;
        long realTime = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 228, Element: nanoTime");
        result.startTime = java.lang.System.nanoTime();
        do {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 230, Element: benchmarkOffHeapMinSizeWithoutOverflow");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 230, Element: consume");
            blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
            operations++;
        } while (!control.isDone );
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 233, Element: nanoTime");
        result.stopTime = java.lang.System.nanoTime();
        result.realTime = realTime;
        result.measuredOps = operations;
    }

    public org.openjdk.jmh.results.BenchmarkTaskResult benchmarkOffHeapMinSizeWithoutOverflow_SampleTime(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 239, Element: benchmarkOffHeapMinSizeWithoutOverflow_SampleTime");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 244, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 245, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 246, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 247, Element: _jmh_tryInit_f_benchmarkdictionary0_G");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G = _jmh_tryInit_f_benchmarkdictionary0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 249, Element: preSetup");
            control.preSetup();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 252, Element: announceWarmupReady");
            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 254, Element: benchmarkOffHeapMinSizeWithoutOverflow");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 254, Element: consume");
                blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
                res.allOps++;
            } 
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 259, Element: getDuration");
            int targetSamples = ((int) (control.getDuration(java.util.concurrent.TimeUnit.MILLISECONDS) * 20));// at max, 20 timestamps per millisecond

            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 260, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 261, Element: getOpsPerInvocation");
            int opsPerInv = benchmarkParams.getOpsPerInvocation();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 262, Element: <init>");
            org.openjdk.jmh.util.SampleBuffer buffer = new org.openjdk.jmh.util.SampleBuffer();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 263, Element: benchmarkOffHeapMinSizeWithoutOverflow_sample_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.benchmarkOffHeapMinSizeWithoutOverflow_sample_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, buffer, targetSamples, opsPerInv, batchSize, l_benchmarkdictionary0_G);
            notifyControl.stopMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 265, Element: announceWarmdownReady");
            control.announceWarmdownReady();
            try {
                while (control.warmdownShouldWait) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 268, Element: benchmarkOffHeapMinSizeWithoutOverflow");
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 268, Element: consume");
                    blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
                    res.allOps++;
                } 
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 271, Element: preTearDown");
                control.preTearDown();
            } catch (java.lang.InterruptedException ie) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 273, Element: preTearDownForce");
                control.preTearDownForce();
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 276, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 277, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkdictionary0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 279, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkdictionary0_G.readyTrial) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 281, Element: tearDown");
                            l_benchmarkdictionary0_G.tearDown();
                            l_benchmarkdictionary0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 288, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.set(l_benchmarkdictionary0_G, 0);
                    }
                } else {
                    long l_benchmarkdictionary0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 292, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.get(l_benchmarkdictionary0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 293, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkdictionary0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 294, Element: max");
                        l_benchmarkdictionary0_G_backoff = java.lang.Math.max(1024, l_benchmarkdictionary0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 295, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 296, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 296, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 299, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.f_benchmarkdictionary0_G = null;
                }
            }
            res.allOps += res.measuredOps * batchSize;
            res.allOps *= opsPerInv;
            res.allOps /= batchSize;
            res.measuredOps *= opsPerInv;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 307, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(res.allOps, res.measuredOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 308, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 308, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 308, Element: add");
            results.add(new org.openjdk.jmh.results.SampleTimeResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "benchmarkOffHeapMinSizeWithoutOverflow", buffer, benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 312, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void benchmarkOffHeapMinSizeWithoutOverflow_sample_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, org.openjdk.jmh.util.SampleBuffer buffer, int targetSamples, long opsPerInv, int batchSize, com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 315, Element: benchmarkOffHeapMinSizeWithoutOverflow_sample_jmhStub");
        long realTime = 0;
        long operations = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 318, Element: nanoTime");
        int rnd = ((int) (java.lang.System.nanoTime()));
        int rndMask = startRndMask;
        long time = 0;
        int currentStride = 0;
        do {
            rnd = (rnd * 1664525) + 1013904223;
            boolean sample = (rnd & rndMask) == 0;
            if (sample) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 326, Element: nanoTime");
                time = java.lang.System.nanoTime();
            }
            for (int b = 0; b < batchSize; b++) {
                if (control.volatileSpoiler)
                    return;

                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 330, Element: benchmarkOffHeapMinSizeWithoutOverflow");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 330, Element: consume");
                blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
            }
            if (sample) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 333, Element: nanoTime");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 333, Element: add");
                buffer.add((java.lang.System.nanoTime() - time) / opsPerInv);
                if ((currentStride++) > targetSamples) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 335, Element: half");
                    buffer.half();
                    currentStride = 0;
                    rndMask = (rndMask << 1) + 1;
                }
            }
            operations++;
        } while (!control.isDone );
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 342, Element: max");
        startRndMask = java.lang.Math.max(startRndMask, rndMask);
        result.realTime = realTime;
        result.measuredOps = operations;
    }

    public org.openjdk.jmh.results.BenchmarkTaskResult benchmarkOffHeapMinSizeWithoutOverflow_SingleShotTime(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 348, Element: benchmarkOffHeapMinSizeWithoutOverflow_SingleShotTime");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 353, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 354, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 355, Element: _jmh_tryInit_f_benchmarkdictionary0_G");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G = _jmh_tryInit_f_benchmarkdictionary0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 357, Element: preSetup");
            control.preSetup();
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 361, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 362, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 363, Element: benchmarkOffHeapMinSizeWithoutOverflow_ss_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.benchmarkOffHeapMinSizeWithoutOverflow_ss_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, batchSize, l_benchmarkdictionary0_G);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 364, Element: preTearDown");
            control.preTearDown();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 366, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 367, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkdictionary0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 369, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkdictionary0_G.readyTrial) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 371, Element: tearDown");
                            l_benchmarkdictionary0_G.tearDown();
                            l_benchmarkdictionary0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 378, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.set(l_benchmarkdictionary0_G, 0);
                    }
                } else {
                    long l_benchmarkdictionary0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 382, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType.tearTrialMutexUpdater.get(l_benchmarkdictionary0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 383, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkdictionary0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 384, Element: max");
                        l_benchmarkdictionary0_G_backoff = java.lang.Math.max(1024, l_benchmarkdictionary0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 385, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 386, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 386, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 389, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.f_benchmarkdictionary0_G = null;
                }
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 393, Element: getOpsPerInvocation");
            int opsPerInv = control.benchmarkParams.getOpsPerInvocation();
            long totalOps = opsPerInv;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 395, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(totalOps, totalOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 396, Element: getTime");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 396, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 396, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 396, Element: add");
            results.add(new org.openjdk.jmh.results.SingleShotResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "benchmarkOffHeapMinSizeWithoutOverflow", res.getTime(), benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 400, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void benchmarkOffHeapMinSizeWithoutOverflow_ss_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, int batchSize, com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType l_benchmarkdictionary0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 403, Element: benchmarkOffHeapMinSizeWithoutOverflow_ss_jmhStub");
        long realTime = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 405, Element: nanoTime");
        result.startTime = java.lang.System.nanoTime();
        for (int b = 0; b < batchSize; b++) {
            if (control.volatileSpoiler)
                return;

            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 408, Element: benchmarkOffHeapMinSizeWithoutOverflow");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 408, Element: consume");
            blackhole.consume(l_benchmarkdictionary0_G.benchmarkOffHeapMinSizeWithoutOverflow());
        }
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 410, Element: nanoTime");
        result.stopTime = java.lang.System.nanoTime();
        result.realTime = realTime;
    }

    static volatile com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType f_benchmarkdictionary0_G;

    com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType _jmh_tryInit_f_benchmarkdictionary0_G(org.openjdk.jmh.runner.InfraControl control) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 417, Element: _jmh_tryInit_f_benchmarkdictionary0_G");
        com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType val = com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.f_benchmarkdictionary0_G;
        if (val != null) {
            return val;
        }
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 422, Element: getClass");
        synchronized(this.getClass()) {
            try {
                if (control.isFailing) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 424, Element: <init>");
                    throw new org.openjdk.jmh.runner.FailureAssistException();
                }
                val = com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.f_benchmarkdictionary0_G;
                if (val != null) {
                    return val;
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 429, Element: <init>");
                val = new com.linkedin.pinot.perf.generated.BenchmarkDictionary_jmhType();
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.java, Line: 430, Element: setUp");
                val.setUp();
                val.readyTrial = true;
                com.linkedin.pinot.perf.generated.BenchmarkDictionary_benchmarkOffHeapMinSizeWithoutOverflow_jmhTest.f_benchmarkdictionary0_G = val;
            } catch (java.lang.Throwable t) {
                control.isFailing = true;
                throw t;
            }
        }
        return val;
    }
}