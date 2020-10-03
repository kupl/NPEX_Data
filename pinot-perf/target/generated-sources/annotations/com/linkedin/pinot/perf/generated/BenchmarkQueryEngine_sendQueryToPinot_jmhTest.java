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
public final class BenchmarkQueryEngine_sendQueryToPinot_jmhTest {
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

    public org.openjdk.jmh.results.BenchmarkTaskResult sendQueryToPinot_Throughput(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 61, Element: sendQueryToPinot_Throughput");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 66, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 67, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 68, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 69, Element: _jmh_tryInit_f_benchmarkqueryengine0_G");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G = _jmh_tryInit_f_benchmarkqueryengine0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 71, Element: preSetup");
            control.preSetup();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 74, Element: announceWarmupReady");
            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 76, Element: sendQueryToPinot");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 76, Element: consume");
                blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
                res.allOps++;
            } 
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 81, Element: sendQueryToPinot_thrpt_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.sendQueryToPinot_thrpt_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, l_benchmarkqueryengine0_G);
            notifyControl.stopMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 83, Element: announceWarmdownReady");
            control.announceWarmdownReady();
            try {
                while (control.warmdownShouldWait) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 86, Element: sendQueryToPinot");
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 86, Element: consume");
                    blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
                    res.allOps++;
                } 
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 89, Element: preTearDown");
                control.preTearDown();
            } catch (java.lang.InterruptedException ie) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 91, Element: preTearDownForce");
                control.preTearDownForce();
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 94, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 95, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkqueryengine0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 97, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkqueryengine0_G.readyTrial) {
                            l_benchmarkqueryengine0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 105, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.set(l_benchmarkqueryengine0_G, 0);
                    }
                } else {
                    long l_benchmarkqueryengine0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 109, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.get(l_benchmarkqueryengine0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 110, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkqueryengine0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 111, Element: max");
                        l_benchmarkqueryengine0_G_backoff = java.lang.Math.max(1024, l_benchmarkqueryengine0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 112, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 113, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 113, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 116, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.f_benchmarkqueryengine0_G = null;
                }
            }
            res.allOps += res.measuredOps;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 121, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 122, Element: getOpsPerInvocation");
            int opsPerInv = benchmarkParams.getOpsPerInvocation();
            res.allOps *= opsPerInv;
            res.allOps /= batchSize;
            res.measuredOps *= opsPerInv;
            res.measuredOps /= batchSize;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 127, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(res.allOps, res.measuredOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 128, Element: getTime");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 128, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 128, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 128, Element: add");
            results.add(new org.openjdk.jmh.results.ThroughputResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "sendQueryToPinot", res.measuredOps, res.getTime(), benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 132, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void sendQueryToPinot_thrpt_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 135, Element: sendQueryToPinot_thrpt_jmhStub");
        long operations = 0;
        long realTime = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 138, Element: nanoTime");
        result.startTime = java.lang.System.nanoTime();
        do {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 140, Element: sendQueryToPinot");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 140, Element: consume");
            blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
            operations++;
        } while (!control.isDone );
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 143, Element: nanoTime");
        result.stopTime = java.lang.System.nanoTime();
        result.realTime = realTime;
        result.measuredOps = operations;
    }

    public org.openjdk.jmh.results.BenchmarkTaskResult sendQueryToPinot_AverageTime(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 149, Element: sendQueryToPinot_AverageTime");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 154, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 155, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 156, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 157, Element: _jmh_tryInit_f_benchmarkqueryengine0_G");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G = _jmh_tryInit_f_benchmarkqueryengine0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 159, Element: preSetup");
            control.preSetup();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 162, Element: announceWarmupReady");
            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 164, Element: sendQueryToPinot");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 164, Element: consume");
                blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
                res.allOps++;
            } 
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 169, Element: sendQueryToPinot_avgt_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.sendQueryToPinot_avgt_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, l_benchmarkqueryengine0_G);
            notifyControl.stopMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 171, Element: announceWarmdownReady");
            control.announceWarmdownReady();
            try {
                while (control.warmdownShouldWait) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 174, Element: sendQueryToPinot");
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 174, Element: consume");
                    blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
                    res.allOps++;
                } 
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 177, Element: preTearDown");
                control.preTearDown();
            } catch (java.lang.InterruptedException ie) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 179, Element: preTearDownForce");
                control.preTearDownForce();
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 182, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 183, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkqueryengine0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 185, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkqueryengine0_G.readyTrial) {
                            l_benchmarkqueryengine0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 193, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.set(l_benchmarkqueryengine0_G, 0);
                    }
                } else {
                    long l_benchmarkqueryengine0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 197, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.get(l_benchmarkqueryengine0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 198, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkqueryengine0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 199, Element: max");
                        l_benchmarkqueryengine0_G_backoff = java.lang.Math.max(1024, l_benchmarkqueryengine0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 200, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 201, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 201, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 204, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.f_benchmarkqueryengine0_G = null;
                }
            }
            res.allOps += res.measuredOps;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 209, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 210, Element: getOpsPerInvocation");
            int opsPerInv = benchmarkParams.getOpsPerInvocation();
            res.allOps *= opsPerInv;
            res.allOps /= batchSize;
            res.measuredOps *= opsPerInv;
            res.measuredOps /= batchSize;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 215, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(res.allOps, res.measuredOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 216, Element: getTime");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 216, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 216, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 216, Element: add");
            results.add(new org.openjdk.jmh.results.AverageTimeResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "sendQueryToPinot", res.measuredOps, res.getTime(), benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 220, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void sendQueryToPinot_avgt_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 223, Element: sendQueryToPinot_avgt_jmhStub");
        long operations = 0;
        long realTime = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 226, Element: nanoTime");
        result.startTime = java.lang.System.nanoTime();
        do {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 228, Element: sendQueryToPinot");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 228, Element: consume");
            blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
            operations++;
        } while (!control.isDone );
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 231, Element: nanoTime");
        result.stopTime = java.lang.System.nanoTime();
        result.realTime = realTime;
        result.measuredOps = operations;
    }

    public org.openjdk.jmh.results.BenchmarkTaskResult sendQueryToPinot_SampleTime(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 237, Element: sendQueryToPinot_SampleTime");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 242, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 243, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 244, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 245, Element: _jmh_tryInit_f_benchmarkqueryengine0_G");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G = _jmh_tryInit_f_benchmarkqueryengine0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 247, Element: preSetup");
            control.preSetup();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 250, Element: announceWarmupReady");
            control.announceWarmupReady();
            while (control.warmupShouldWait) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 252, Element: sendQueryToPinot");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 252, Element: consume");
                blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
                res.allOps++;
            } 
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 257, Element: getDuration");
            int targetSamples = ((int) (control.getDuration(java.util.concurrent.TimeUnit.MILLISECONDS) * 20));// at max, 20 timestamps per millisecond

            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 258, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 259, Element: getOpsPerInvocation");
            int opsPerInv = benchmarkParams.getOpsPerInvocation();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 260, Element: <init>");
            org.openjdk.jmh.util.SampleBuffer buffer = new org.openjdk.jmh.util.SampleBuffer();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 261, Element: sendQueryToPinot_sample_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.sendQueryToPinot_sample_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, buffer, targetSamples, opsPerInv, batchSize, l_benchmarkqueryengine0_G);
            notifyControl.stopMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 263, Element: announceWarmdownReady");
            control.announceWarmdownReady();
            try {
                while (control.warmdownShouldWait) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 266, Element: sendQueryToPinot");
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 266, Element: consume");
                    blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
                    res.allOps++;
                } 
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 269, Element: preTearDown");
                control.preTearDown();
            } catch (java.lang.InterruptedException ie) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 271, Element: preTearDownForce");
                control.preTearDownForce();
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 274, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 275, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkqueryengine0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 277, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkqueryengine0_G.readyTrial) {
                            l_benchmarkqueryengine0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 285, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.set(l_benchmarkqueryengine0_G, 0);
                    }
                } else {
                    long l_benchmarkqueryengine0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 289, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.get(l_benchmarkqueryengine0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 290, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkqueryengine0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 291, Element: max");
                        l_benchmarkqueryengine0_G_backoff = java.lang.Math.max(1024, l_benchmarkqueryengine0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 292, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 293, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 293, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 296, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.f_benchmarkqueryengine0_G = null;
                }
            }
            res.allOps += res.measuredOps * batchSize;
            res.allOps *= opsPerInv;
            res.allOps /= batchSize;
            res.measuredOps *= opsPerInv;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 304, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(res.allOps, res.measuredOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 305, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 305, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 305, Element: add");
            results.add(new org.openjdk.jmh.results.SampleTimeResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "sendQueryToPinot", buffer, benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 309, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void sendQueryToPinot_sample_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, org.openjdk.jmh.util.SampleBuffer buffer, int targetSamples, long opsPerInv, int batchSize, com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 312, Element: sendQueryToPinot_sample_jmhStub");
        long realTime = 0;
        long operations = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 315, Element: nanoTime");
        int rnd = ((int) (java.lang.System.nanoTime()));
        int rndMask = startRndMask;
        long time = 0;
        int currentStride = 0;
        do {
            rnd = (rnd * 1664525) + 1013904223;
            boolean sample = (rnd & rndMask) == 0;
            if (sample) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 323, Element: nanoTime");
                time = java.lang.System.nanoTime();
            }
            for (int b = 0; b < batchSize; b++) {
                if (control.volatileSpoiler)
                    return;

                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 327, Element: sendQueryToPinot");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 327, Element: consume");
                blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
            }
            if (sample) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 330, Element: nanoTime");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 330, Element: add");
                buffer.add((java.lang.System.nanoTime() - time) / opsPerInv);
                if ((currentStride++) > targetSamples) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 332, Element: half");
                    buffer.half();
                    currentStride = 0;
                    rndMask = (rndMask << 1) + 1;
                }
            }
            operations++;
        } while (!control.isDone );
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 339, Element: max");
        startRndMask = java.lang.Math.max(startRndMask, rndMask);
        result.realTime = realTime;
        result.measuredOps = operations;
    }

    public org.openjdk.jmh.results.BenchmarkTaskResult sendQueryToPinot_SingleShotTime(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.infra.ThreadParams threadParams) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 345, Element: sendQueryToPinot_SingleShotTime");
        this.benchmarkParams = control.benchmarkParams;
        this.iterationParams = control.iterationParams;
        this.threadParams = threadParams;
        this.notifyControl = control.notifyControl;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 350, Element: <init>");
        this.blackhole = new org.openjdk.jmh.infra.Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 351, Element: getSubgroupIndex");
        if (threadParams.getSubgroupIndex() == 0) {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 352, Element: _jmh_tryInit_f_benchmarkqueryengine0_G");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G = _jmh_tryInit_f_benchmarkqueryengine0_G(control);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 354, Element: preSetup");
            control.preSetup();
            notifyControl.startMeasurement = true;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 358, Element: <init>");
            org.openjdk.jmh.results.RawResults res = new org.openjdk.jmh.results.RawResults();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 359, Element: getBatchSize");
            int batchSize = iterationParams.getBatchSize();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 360, Element: sendQueryToPinot_ss_jmhStub");
            com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.sendQueryToPinot_ss_jmhStub(control, res, benchmarkParams, iterationParams, threadParams, blackhole, notifyControl, startRndMask, batchSize, l_benchmarkqueryengine0_G);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 361, Element: preTearDown");
            control.preTearDown();
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 363, Element: isLastIteration");
            if (control.isLastIteration()) {
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 364, Element: compareAndSet");
                if (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.compareAndSet(l_benchmarkqueryengine0_G, 0, 1)) {
                    try {
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 366, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        if (l_benchmarkqueryengine0_G.readyTrial) {
                            l_benchmarkqueryengine0_G.readyTrial = false;
                        }
                    } catch (java.lang.Throwable t) {
                        control.isFailing = true;
                        throw t;
                    } finally {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 374, Element: set");
                        com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.set(l_benchmarkqueryengine0_G, 0);
                    }
                } else {
                    long l_benchmarkqueryengine0_G_backoff = 1;
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 378, Element: get");
                    while (com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType.tearTrialMutexUpdater.get(l_benchmarkqueryengine0_G) == 1) {
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 379, Element: sleep");
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(l_benchmarkqueryengine0_G_backoff);
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 380, Element: max");
                        l_benchmarkqueryengine0_G_backoff = java.lang.Math.max(1024, l_benchmarkqueryengine0_G_backoff * 2);
                        if (control.isFailing) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 381, Element: <init>");
                            throw new org.openjdk.jmh.runner.FailureAssistException();
                        }
                        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 382, Element: interrupted");
                        if (java.lang.Thread.interrupted()) {
                            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 382, Element: <init>");
                            throw new java.lang.InterruptedException();
                        }
                    } 
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 385, Element: getClass");
                synchronized(this.getClass()) {
                    com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.f_benchmarkqueryengine0_G = null;
                }
            }
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 389, Element: getOpsPerInvocation");
            int opsPerInv = control.benchmarkParams.getOpsPerInvocation();
            long totalOps = opsPerInv;
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 391, Element: <init>");
            org.openjdk.jmh.results.BenchmarkTaskResult results = new org.openjdk.jmh.results.BenchmarkTaskResult(totalOps, totalOps);
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 392, Element: getTime");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 392, Element: getTimeUnit");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 392, Element: <init>");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 392, Element: add");
            results.add(new org.openjdk.jmh.results.SingleShotResult(org.openjdk.jmh.results.ResultRole.PRIMARY, "sendQueryToPinot", res.getTime(), benchmarkParams.getTimeUnit()));
            this.blackhole = null;
            return results;
        } else {
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 396, Element: <init>");
            throw new java.lang.IllegalStateException("Harness failed to distribute threads among groups properly");
        }
    }

    public static void sendQueryToPinot_ss_jmhStub(org.openjdk.jmh.runner.InfraControl control, org.openjdk.jmh.results.RawResults result, org.openjdk.jmh.infra.BenchmarkParams benchmarkParams, org.openjdk.jmh.infra.IterationParams iterationParams, org.openjdk.jmh.infra.ThreadParams threadParams, org.openjdk.jmh.infra.Blackhole blackhole, org.openjdk.jmh.infra.Control notifyControl, int startRndMask, int batchSize, com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType l_benchmarkqueryengine0_G) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 399, Element: sendQueryToPinot_ss_jmhStub");
        long realTime = 0;
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 401, Element: nanoTime");
        result.startTime = java.lang.System.nanoTime();
        for (int b = 0; b < batchSize; b++) {
            if (control.volatileSpoiler)
                return;

            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 404, Element: sendQueryToPinot");
            System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 404, Element: consume");
            blackhole.consume(l_benchmarkqueryengine0_G.sendQueryToPinot());
        }
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 406, Element: nanoTime");
        result.stopTime = java.lang.System.nanoTime();
        result.realTime = realTime;
    }

    static volatile com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType f_benchmarkqueryengine0_G;

    com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType _jmh_tryInit_f_benchmarkqueryengine0_G(org.openjdk.jmh.runner.InfraControl control) throws java.lang.Throwable {
        System.out.println("[ENTRY] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 413, Element: _jmh_tryInit_f_benchmarkqueryengine0_G");
        com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType val = com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.f_benchmarkqueryengine0_G;
        if (val != null) {
            return val;
        }
        System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 418, Element: getClass");
        synchronized(this.getClass()) {
            try {
                if (control.isFailing) {
                    System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 420, Element: <init>");
                    throw new org.openjdk.jmh.runner.FailureAssistException();
                }
                val = com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.f_benchmarkqueryengine0_G;
                if (val != null) {
                    return val;
                }
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 425, Element: <init>");
                val = new com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_jmhType();
                java.lang.reflect.Field f;
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 427, Element: getDeclaredField");
                f = com.linkedin.pinot.perf.BenchmarkQueryEngine.class.getDeclaredField("optimizationFlags");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 428, Element: setAccessible");
                f.setAccessible(true);
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 429, Element: getParam");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 429, Element: set");
                f.set(val, control.getParam("optimizationFlags"));
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 430, Element: getDeclaredField");
                f = com.linkedin.pinot.perf.BenchmarkQueryEngine.class.getDeclaredField("queryPattern");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 431, Element: setAccessible");
                f.setAccessible(true);
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 432, Element: getParam");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 432, Element: valueOf");
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 432, Element: set");
                f.set(val, java.lang.Integer.valueOf(control.getParam("queryPattern")));
                System.out.println("[CALLSITE] Filepath: pinot-perf/target/generated-sources/annotations/com/linkedin/pinot/perf/generated/BenchmarkQueryEngine_sendQueryToPinot_jmhTest.java, Line: 433, Element: startPinot");
                val.startPinot();
                val.readyTrial = true;
                com.linkedin.pinot.perf.generated.BenchmarkQueryEngine_sendQueryToPinot_jmhTest.f_benchmarkqueryengine0_G = val;
            } catch (java.lang.Throwable t) {
                control.isFailing = true;
                throw t;
            }
        }
        return val;
    }
}