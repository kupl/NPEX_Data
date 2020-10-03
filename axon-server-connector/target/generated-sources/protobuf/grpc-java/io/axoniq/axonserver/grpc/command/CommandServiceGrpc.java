package io.axoniq.axonserver.grpc.command;

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
    comments = "Source: command.proto")
public class CommandServiceGrpc {

  private CommandServiceGrpc() {}

  public static final String SERVICE_NAME = "io.axoniq.axonserver.grpc.command.CommandService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.command.CommandProviderOutbound,
      io.axoniq.axonserver.grpc.command.CommandProviderInbound> METHOD_OPEN_STREAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.command.CommandService", "OpenStream"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.command.CommandProviderOutbound.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.command.CommandProviderInbound.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.command.Command,
      io.axoniq.axonserver.grpc.command.CommandResponse> METHOD_DISPATCH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.command.CommandService", "Dispatch"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.command.Command.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.command.CommandResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommandServiceStub newStub(io.grpc.Channel channel) {
    return new CommandServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommandServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommandServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static CommandServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommandServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CommandServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandProviderOutbound> openStream(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandProviderInbound> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_OPEN_STREAM, responseObserver);
    }

    /**
     */
    public void dispatch(io.axoniq.axonserver.grpc.command.Command request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DISPATCH, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_OPEN_STREAM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.command.CommandProviderOutbound,
                io.axoniq.axonserver.grpc.command.CommandProviderInbound>(
                  this, METHODID_OPEN_STREAM)))
          .addMethod(
            METHOD_DISPATCH,
            asyncUnaryCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.command.Command,
                io.axoniq.axonserver.grpc.command.CommandResponse>(
                  this, METHODID_DISPATCH)))
          .build();
    }
  }

  /**
   */
  public static final class CommandServiceStub extends io.grpc.stub.AbstractStub<CommandServiceStub> {
    private CommandServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommandServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommandServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandProviderOutbound> openStream(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandProviderInbound> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_OPEN_STREAM, getCallOptions()), responseObserver);
    }

    /**
     */
    public void dispatch(io.axoniq.axonserver.grpc.command.Command request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DISPATCH, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommandServiceBlockingStub extends io.grpc.stub.AbstractStub<CommandServiceBlockingStub> {
    private CommandServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommandServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommandServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.axoniq.axonserver.grpc.command.CommandResponse dispatch(io.axoniq.axonserver.grpc.command.Command request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DISPATCH, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommandServiceFutureStub extends io.grpc.stub.AbstractStub<CommandServiceFutureStub> {
    private CommandServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommandServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommandServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.axoniq.axonserver.grpc.command.CommandResponse> dispatch(
        io.axoniq.axonserver.grpc.command.Command request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DISPATCH, getCallOptions()), request);
    }
  }

  private static final int METHODID_DISPATCH = 0;
  private static final int METHODID_OPEN_STREAM = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommandServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(CommandServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DISPATCH:
          serviceImpl.dispatch((io.axoniq.axonserver.grpc.command.Command) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandResponse>) responseObserver);
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
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.command.CommandProviderInbound>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CommandServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.axoniq.axonserver.grpc.command.CommandOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommandServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommandServiceDescriptorSupplier())
              .addMethod(METHOD_OPEN_STREAM)
              .addMethod(METHOD_DISPATCH)
              .build();
        }
      }
    }
    return result;
  }
}
