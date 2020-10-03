package io.axoniq.axonserver.grpc.query;

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
    comments = "Source: query.proto")
public class QueryServiceGrpc {

  private QueryServiceGrpc() {}

  public static final String SERVICE_NAME = "io.axoniq.axonserver.grpc.query.QueryService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.query.QueryProviderOutbound,
      io.axoniq.axonserver.grpc.query.QueryProviderInbound> METHOD_OPEN_STREAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.query.QueryService", "OpenStream"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.query.QueryProviderOutbound.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.query.QueryProviderInbound.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.query.QueryRequest,
      io.axoniq.axonserver.grpc.query.QueryResponse> METHOD_QUERY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.query.QueryService", "Query"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.query.QueryRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.query.QueryResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.query.SubscriptionQueryRequest,
      io.axoniq.axonserver.grpc.query.SubscriptionQueryResponse> METHOD_SUBSCRIPTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.query.QueryService", "Subscription"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.query.SubscriptionQueryRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.query.SubscriptionQueryResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static QueryServiceStub newStub(io.grpc.Channel channel) {
    return new QueryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QueryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new QueryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static QueryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new QueryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class QueryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryProviderOutbound> openStream(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryProviderInbound> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_OPEN_STREAM, responseObserver);
    }

    /**
     */
    public void query(io.axoniq.axonserver.grpc.query.QueryRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_QUERY, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.SubscriptionQueryRequest> subscription(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.SubscriptionQueryResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SUBSCRIPTION, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_OPEN_STREAM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.query.QueryProviderOutbound,
                io.axoniq.axonserver.grpc.query.QueryProviderInbound>(
                  this, METHODID_OPEN_STREAM)))
          .addMethod(
            METHOD_QUERY,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.query.QueryRequest,
                io.axoniq.axonserver.grpc.query.QueryResponse>(
                  this, METHODID_QUERY)))
          .addMethod(
            METHOD_SUBSCRIPTION,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.query.SubscriptionQueryRequest,
                io.axoniq.axonserver.grpc.query.SubscriptionQueryResponse>(
                  this, METHODID_SUBSCRIPTION)))
          .build();
    }
  }

  /**
   */
  public static final class QueryServiceStub extends io.grpc.stub.AbstractStub<QueryServiceStub> {
    private QueryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private QueryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new QueryServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryProviderOutbound> openStream(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryProviderInbound> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_OPEN_STREAM, getCallOptions()), responseObserver);
    }

    /**
     */
    public void query(io.axoniq.axonserver.grpc.query.QueryRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_QUERY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.SubscriptionQueryRequest> subscription(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.SubscriptionQueryResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_SUBSCRIPTION, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class QueryServiceBlockingStub extends io.grpc.stub.AbstractStub<QueryServiceBlockingStub> {
    private QueryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private QueryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new QueryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<io.axoniq.axonserver.grpc.query.QueryResponse> query(
        io.axoniq.axonserver.grpc.query.QueryRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_QUERY, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class QueryServiceFutureStub extends io.grpc.stub.AbstractStub<QueryServiceFutureStub> {
    private QueryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private QueryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new QueryServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_QUERY = 0;
  private static final int METHODID_OPEN_STREAM = 1;
  private static final int METHODID_SUBSCRIPTION = 2;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final QueryServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(QueryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY:
          serviceImpl.query((io.axoniq.axonserver.grpc.query.QueryRequest) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryResponse>) responseObserver);
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
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.QueryProviderInbound>) responseObserver);
        case METHODID_SUBSCRIPTION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.subscription(
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.query.SubscriptionQueryResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class QueryServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.axoniq.axonserver.grpc.query.Query.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (QueryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new QueryServiceDescriptorSupplier())
              .addMethod(METHOD_OPEN_STREAM)
              .addMethod(METHOD_QUERY)
              .addMethod(METHOD_SUBSCRIPTION)
              .build();
        }
      }
    }
    return result;
  }
}
