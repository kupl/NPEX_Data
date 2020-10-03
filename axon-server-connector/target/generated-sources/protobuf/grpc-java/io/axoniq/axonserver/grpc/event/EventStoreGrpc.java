package io.axoniq.axonserver.grpc.event;

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
    comments = "Source: event.proto")
public class EventStoreGrpc {

  private EventStoreGrpc() {}

  public static final String SERVICE_NAME = "io.axoniq.axonserver.grpc.event.EventStore";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.Event,
      io.axoniq.axonserver.grpc.event.Confirmation> METHOD_APPEND_EVENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "AppendEvent"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.Event.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.Confirmation.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.Event,
      io.axoniq.axonserver.grpc.event.Confirmation> METHOD_APPEND_SNAPSHOT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "AppendSnapshot"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.Event.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.Confirmation.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.GetAggregateEventsRequest,
      io.axoniq.axonserver.grpc.event.Event> METHOD_LIST_AGGREGATE_EVENTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "ListAggregateEvents"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.GetAggregateEventsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.Event.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.GetAggregateSnapshotsRequest,
      io.axoniq.axonserver.grpc.event.Event> METHOD_LIST_AGGREGATE_SNAPSHOTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "ListAggregateSnapshots"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.GetAggregateSnapshotsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.Event.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.GetEventsRequest,
      io.axoniq.axonserver.grpc.event.EventWithToken> METHOD_LIST_EVENTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "ListEvents"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.GetEventsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.EventWithToken.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest,
      io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse> METHOD_READ_HIGHEST_SEQUENCE_NR =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "ReadHighestSequenceNr"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.QueryEventsRequest,
      io.axoniq.axonserver.grpc.event.QueryEventsResponse> METHOD_QUERY_EVENTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "QueryEvents"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.QueryEventsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.QueryEventsResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.GetFirstTokenRequest,
      io.axoniq.axonserver.grpc.event.TrackingToken> METHOD_GET_FIRST_TOKEN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "GetFirstToken"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.GetFirstTokenRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.TrackingToken.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.GetLastTokenRequest,
      io.axoniq.axonserver.grpc.event.TrackingToken> METHOD_GET_LAST_TOKEN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "GetLastToken"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.GetLastTokenRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.TrackingToken.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.axoniq.axonserver.grpc.event.GetTokenAtRequest,
      io.axoniq.axonserver.grpc.event.TrackingToken> METHOD_GET_TOKEN_AT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "io.axoniq.axonserver.grpc.event.EventStore", "GetTokenAt"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.GetTokenAtRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.axoniq.axonserver.grpc.event.TrackingToken.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventStoreStub newStub(io.grpc.Channel channel) {
    return new EventStoreStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventStoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EventStoreBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static EventStoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EventStoreFutureStub(channel);
  }

  /**
   */
  public static abstract class EventStoreImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Accepts a stream of Events returning a Confirmation when completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event> appendEvent(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Confirmation> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_APPEND_EVENT, responseObserver);
    }

    /**
     * <pre>
     * Accepts a Snapshot event returning a Confirmation when completed.
     * </pre>
     */
    public void appendSnapshot(io.axoniq.axonserver.grpc.event.Event request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_APPEND_SNAPSHOT, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the Events for a given aggregate. Results are streamed rather than returned at once.
     * </pre>
     */
    public void listAggregateEvents(io.axoniq.axonserver.grpc.event.GetAggregateEventsRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_AGGREGATE_EVENTS, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the Snapshots for a given aggregate. Results are streamed rather than returned at once.
     * </pre>
     */
    public void listAggregateSnapshots(io.axoniq.axonserver.grpc.event.GetAggregateSnapshotsRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_AGGREGATE_SNAPSHOTS, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the Events from a given tracking token. Results are streamed rather than returned at once.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.GetEventsRequest> listEvents(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.EventWithToken> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_LIST_EVENTS, responseObserver);
    }

    /**
     * <pre>
     * Gets the highest sequence number for a specific aggregate.
     * </pre>
     */
    public void readHighestSequenceNr(io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_HIGHEST_SEQUENCE_NR, responseObserver);
    }

    /**
     * <pre>
     * Performs a query on the event store, returns a stream of results. Input is a stream to allow flow control from the
     * client
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.QueryEventsRequest> queryEvents(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.QueryEventsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_QUERY_EVENTS, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the first token available in event store (typically 0). Returns 0 when no events in store.
     * </pre>
     */
    public void getFirstToken(io.axoniq.axonserver.grpc.event.GetFirstTokenRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FIRST_TOKEN, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the last committed token in event store. Returns -1 when no events in store.
     * </pre>
     */
    public void getLastToken(io.axoniq.axonserver.grpc.event.GetLastTokenRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_LAST_TOKEN, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the token of the first token of an event from specified time in event store. Returns -1 when no events in store.
     * </pre>
     */
    public void getTokenAt(io.axoniq.axonserver.grpc.event.GetTokenAtRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TOKEN_AT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_APPEND_EVENT,
            asyncClientStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.Event,
                io.axoniq.axonserver.grpc.event.Confirmation>(
                  this, METHODID_APPEND_EVENT)))
          .addMethod(
            METHOD_APPEND_SNAPSHOT,
            asyncUnaryCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.Event,
                io.axoniq.axonserver.grpc.event.Confirmation>(
                  this, METHODID_APPEND_SNAPSHOT)))
          .addMethod(
            METHOD_LIST_AGGREGATE_EVENTS,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.GetAggregateEventsRequest,
                io.axoniq.axonserver.grpc.event.Event>(
                  this, METHODID_LIST_AGGREGATE_EVENTS)))
          .addMethod(
            METHOD_LIST_AGGREGATE_SNAPSHOTS,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.GetAggregateSnapshotsRequest,
                io.axoniq.axonserver.grpc.event.Event>(
                  this, METHODID_LIST_AGGREGATE_SNAPSHOTS)))
          .addMethod(
            METHOD_LIST_EVENTS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.GetEventsRequest,
                io.axoniq.axonserver.grpc.event.EventWithToken>(
                  this, METHODID_LIST_EVENTS)))
          .addMethod(
            METHOD_READ_HIGHEST_SEQUENCE_NR,
            asyncUnaryCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest,
                io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse>(
                  this, METHODID_READ_HIGHEST_SEQUENCE_NR)))
          .addMethod(
            METHOD_QUERY_EVENTS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.QueryEventsRequest,
                io.axoniq.axonserver.grpc.event.QueryEventsResponse>(
                  this, METHODID_QUERY_EVENTS)))
          .addMethod(
            METHOD_GET_FIRST_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.GetFirstTokenRequest,
                io.axoniq.axonserver.grpc.event.TrackingToken>(
                  this, METHODID_GET_FIRST_TOKEN)))
          .addMethod(
            METHOD_GET_LAST_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.GetLastTokenRequest,
                io.axoniq.axonserver.grpc.event.TrackingToken>(
                  this, METHODID_GET_LAST_TOKEN)))
          .addMethod(
            METHOD_GET_TOKEN_AT,
            asyncUnaryCall(
              new MethodHandlers<
                io.axoniq.axonserver.grpc.event.GetTokenAtRequest,
                io.axoniq.axonserver.grpc.event.TrackingToken>(
                  this, METHODID_GET_TOKEN_AT)))
          .build();
    }
  }

  /**
   */
  public static final class EventStoreStub extends io.grpc.stub.AbstractStub<EventStoreStub> {
    private EventStoreStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventStoreStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventStoreStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventStoreStub(channel, callOptions);
    }

    /**
     * <pre>
     * Accepts a stream of Events returning a Confirmation when completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event> appendEvent(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Confirmation> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_APPEND_EVENT, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Accepts a Snapshot event returning a Confirmation when completed.
     * </pre>
     */
    public void appendSnapshot(io.axoniq.axonserver.grpc.event.Event request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_APPEND_SNAPSHOT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the Events for a given aggregate. Results are streamed rather than returned at once.
     * </pre>
     */
    public void listAggregateEvents(io.axoniq.axonserver.grpc.event.GetAggregateEventsRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_AGGREGATE_EVENTS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the Snapshots for a given aggregate. Results are streamed rather than returned at once.
     * </pre>
     */
    public void listAggregateSnapshots(io.axoniq.axonserver.grpc.event.GetAggregateSnapshotsRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_AGGREGATE_SNAPSHOTS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the Events from a given tracking token. Results are streamed rather than returned at once.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.GetEventsRequest> listEvents(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.EventWithToken> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_LIST_EVENTS, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Gets the highest sequence number for a specific aggregate.
     * </pre>
     */
    public void readHighestSequenceNr(io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_HIGHEST_SEQUENCE_NR, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Performs a query on the event store, returns a stream of results. Input is a stream to allow flow control from the
     * client
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.QueryEventsRequest> queryEvents(
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.QueryEventsResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_QUERY_EVENTS, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the first token available in event store (typically 0). Returns 0 when no events in store.
     * </pre>
     */
    public void getFirstToken(io.axoniq.axonserver.grpc.event.GetFirstTokenRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FIRST_TOKEN, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the last committed token in event store. Returns -1 when no events in store.
     * </pre>
     */
    public void getLastToken(io.axoniq.axonserver.grpc.event.GetLastTokenRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_TOKEN, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the token of the first token of an event from specified time in event store. Returns -1 when no events in store.
     * </pre>
     */
    public void getTokenAt(io.axoniq.axonserver.grpc.event.GetTokenAtRequest request,
        io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TOKEN_AT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventStoreBlockingStub extends io.grpc.stub.AbstractStub<EventStoreBlockingStub> {
    private EventStoreBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventStoreBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventStoreBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventStoreBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Accepts a Snapshot event returning a Confirmation when completed.
     * </pre>
     */
    public io.axoniq.axonserver.grpc.event.Confirmation appendSnapshot(io.axoniq.axonserver.grpc.event.Event request) {
      return blockingUnaryCall(
          getChannel(), METHOD_APPEND_SNAPSHOT, getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the Events for a given aggregate. Results are streamed rather than returned at once.
     * </pre>
     */
    public java.util.Iterator<io.axoniq.axonserver.grpc.event.Event> listAggregateEvents(
        io.axoniq.axonserver.grpc.event.GetAggregateEventsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_AGGREGATE_EVENTS, getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the Snapshots for a given aggregate. Results are streamed rather than returned at once.
     * </pre>
     */
    public java.util.Iterator<io.axoniq.axonserver.grpc.event.Event> listAggregateSnapshots(
        io.axoniq.axonserver.grpc.event.GetAggregateSnapshotsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_AGGREGATE_SNAPSHOTS, getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the highest sequence number for a specific aggregate.
     * </pre>
     */
    public io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse readHighestSequenceNr(io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_HIGHEST_SEQUENCE_NR, getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the first token available in event store (typically 0). Returns 0 when no events in store.
     * </pre>
     */
    public io.axoniq.axonserver.grpc.event.TrackingToken getFirstToken(io.axoniq.axonserver.grpc.event.GetFirstTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FIRST_TOKEN, getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the last committed token in event store. Returns -1 when no events in store.
     * </pre>
     */
    public io.axoniq.axonserver.grpc.event.TrackingToken getLastToken(io.axoniq.axonserver.grpc.event.GetLastTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_LAST_TOKEN, getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the token of the first token of an event from specified time in event store. Returns -1 when no events in store.
     * </pre>
     */
    public io.axoniq.axonserver.grpc.event.TrackingToken getTokenAt(io.axoniq.axonserver.grpc.event.GetTokenAtRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TOKEN_AT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventStoreFutureStub extends io.grpc.stub.AbstractStub<EventStoreFutureStub> {
    private EventStoreFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventStoreFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventStoreFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventStoreFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Accepts a Snapshot event returning a Confirmation when completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.axoniq.axonserver.grpc.event.Confirmation> appendSnapshot(
        io.axoniq.axonserver.grpc.event.Event request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_APPEND_SNAPSHOT, getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the highest sequence number for a specific aggregate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse> readHighestSequenceNr(
        io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_HIGHEST_SEQUENCE_NR, getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the first token available in event store (typically 0). Returns 0 when no events in store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.axoniq.axonserver.grpc.event.TrackingToken> getFirstToken(
        io.axoniq.axonserver.grpc.event.GetFirstTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FIRST_TOKEN, getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the last committed token in event store. Returns -1 when no events in store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.axoniq.axonserver.grpc.event.TrackingToken> getLastToken(
        io.axoniq.axonserver.grpc.event.GetLastTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_TOKEN, getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the token of the first token of an event from specified time in event store. Returns -1 when no events in store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.axoniq.axonserver.grpc.event.TrackingToken> getTokenAt(
        io.axoniq.axonserver.grpc.event.GetTokenAtRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TOKEN_AT, getCallOptions()), request);
    }
  }

  private static final int METHODID_APPEND_SNAPSHOT = 0;
  private static final int METHODID_LIST_AGGREGATE_EVENTS = 1;
  private static final int METHODID_LIST_AGGREGATE_SNAPSHOTS = 2;
  private static final int METHODID_READ_HIGHEST_SEQUENCE_NR = 3;
  private static final int METHODID_GET_FIRST_TOKEN = 4;
  private static final int METHODID_GET_LAST_TOKEN = 5;
  private static final int METHODID_GET_TOKEN_AT = 6;
  private static final int METHODID_APPEND_EVENT = 7;
  private static final int METHODID_LIST_EVENTS = 8;
  private static final int METHODID_QUERY_EVENTS = 9;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventStoreImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(EventStoreImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_APPEND_SNAPSHOT:
          serviceImpl.appendSnapshot((io.axoniq.axonserver.grpc.event.Event) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Confirmation>) responseObserver);
          break;
        case METHODID_LIST_AGGREGATE_EVENTS:
          serviceImpl.listAggregateEvents((io.axoniq.axonserver.grpc.event.GetAggregateEventsRequest) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event>) responseObserver);
          break;
        case METHODID_LIST_AGGREGATE_SNAPSHOTS:
          serviceImpl.listAggregateSnapshots((io.axoniq.axonserver.grpc.event.GetAggregateSnapshotsRequest) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Event>) responseObserver);
          break;
        case METHODID_READ_HIGHEST_SEQUENCE_NR:
          serviceImpl.readHighestSequenceNr((io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrResponse>) responseObserver);
          break;
        case METHODID_GET_FIRST_TOKEN:
          serviceImpl.getFirstToken((io.axoniq.axonserver.grpc.event.GetFirstTokenRequest) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken>) responseObserver);
          break;
        case METHODID_GET_LAST_TOKEN:
          serviceImpl.getLastToken((io.axoniq.axonserver.grpc.event.GetLastTokenRequest) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken>) responseObserver);
          break;
        case METHODID_GET_TOKEN_AT:
          serviceImpl.getTokenAt((io.axoniq.axonserver.grpc.event.GetTokenAtRequest) request,
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.TrackingToken>) responseObserver);
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
        case METHODID_APPEND_EVENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.appendEvent(
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.Confirmation>) responseObserver);
        case METHODID_LIST_EVENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.listEvents(
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.EventWithToken>) responseObserver);
        case METHODID_QUERY_EVENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.queryEvents(
              (io.grpc.stub.StreamObserver<io.axoniq.axonserver.grpc.event.QueryEventsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class EventStoreDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.axoniq.axonserver.grpc.event.EventOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventStoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventStoreDescriptorSupplier())
              .addMethod(METHOD_APPEND_EVENT)
              .addMethod(METHOD_APPEND_SNAPSHOT)
              .addMethod(METHOD_LIST_AGGREGATE_EVENTS)
              .addMethod(METHOD_LIST_AGGREGATE_SNAPSHOTS)
              .addMethod(METHOD_LIST_EVENTS)
              .addMethod(METHOD_READ_HIGHEST_SEQUENCE_NR)
              .addMethod(METHOD_QUERY_EVENTS)
              .addMethod(METHOD_GET_FIRST_TOKEN)
              .addMethod(METHOD_GET_LAST_TOKEN)
              .addMethod(METHOD_GET_TOKEN_AT)
              .build();
        }
      }
    }
    return result;
  }
}
