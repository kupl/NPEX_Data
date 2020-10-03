package io.axoniq.axonserver.grpc.control;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.1.2)",
    comments = "Source: control.proto")
public class PlatformServiceGrpc {

  private PlatformServiceGrpc() {}

  public static final String SERVICE_NAME = "io.axoniq.axonserver.grpc.control.PlatformService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.control.ClientIdentification,
      io.axoniq.axonserver.grpc.control.PlatformInfo> METHOD_GET_PLATFORM_SERVER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.control.PlatformService", "GetPlatformServer"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.control.ClientIdentification.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.control.PlatformInfo.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.control.PlatformInboundInstruction,
      io.axoniq.axonserver.grpc.control.PlatformOutboundInstruction> METHOD_OPEN_STREAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.control.PlatformService", "OpenStream"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.control.PlatformInboundInstruction.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.control.PlatformOutboundInstruction.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlatformServiceStub newStub(io.grpc.Channel channel) {
    return new PlatformServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlatformServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PlatformServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static PlatformServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PlatformServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PlatformServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPlatformServer(io.axoniq.axonserver.grpc.control.ClientIdentification request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PLATFORM_SERVER, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformInboundInstruction> openStream(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformOutboundInstruction> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_OPEN_STREAM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_PLATFORM_SERVER,
            asyncUnaryCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.control.ClientIdentification,
                io.axoniq.axonserver.grpc.control.PlatformInfo>(
                  this, METHODID_GET_PLATFORM_SERVER)))
          .addMethod(
            METHOD_OPEN_STREAM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.control.PlatformInboundInstruction,
                io.axoniq.axonserver.grpc.control.PlatformOutboundInstruction>(
                  this, METHODID_OPEN_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class PlatformServiceStub extends io.grpc.stub.AbstractStub<PlatformServiceStub> {
    private PlatformServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlatformServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlatformServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlatformServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPlatformServer(io.axoniq.axonserver.grpc.control.ClientIdentification request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PLATFORM_SERVER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformInboundInstruction> openStream(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformOutboundInstruction> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_OPEN_STREAM, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PlatformServiceBlockingStub extends io.grpc.stub.AbstractStub<PlatformServiceBlockingStub> {
    private PlatformServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlatformServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlatformServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlatformServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.axoniq.axonserver.grpc.control.PlatformInfo getPlatformServer(io.axoniq.axonserver.grpc.control.ClientIdentification request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PLATFORM_SERVER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PlatformServiceFutureStub extends io.grpc.stub.AbstractStub<PlatformServiceFutureStub> {
    private PlatformServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlatformServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlatformServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlatformServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.axoniq.axonserver.grpc.control.PlatformInfo> getPlatformServer(
        io.axoniq.axonserver.grpc.control.ClientIdentification request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PLATFORM_SERVER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PLATFORM_SERVER = 0;
  private static final int METHODID_OPEN_STREAM = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlatformServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(PlatformServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PLATFORM_SERVER:
          serviceImpl.getPlatformServer((io.axoniq.axonserver.grpc.control.ClientIdentification) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPEN_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.openStream(
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.control.PlatformOutboundInstruction>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class PlatformServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.axoniq.axonserver.grpc.control.Control.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PlatformServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlatformServiceDescriptorSupplier())
              .addMethod(METHOD_GET_PLATFORM_SERVER)
              .addMethod(METHOD_OPEN_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}
