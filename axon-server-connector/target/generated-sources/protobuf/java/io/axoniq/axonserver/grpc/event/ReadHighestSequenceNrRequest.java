// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package io.axoniq.axonserver.grpc.event;

/**
 * Protobuf type {@code io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest}
 */
public  final class ReadHighestSequenceNrRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest)
    ReadHighestSequenceNrRequestOrBuilder {
  // Use ReadHighestSequenceNrRequest.newBuilder() to construct.
  private ReadHighestSequenceNrRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReadHighestSequenceNrRequest() {
    aggregateId_ = "";
    fromSequenceNr_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ReadHighestSequenceNrRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            aggregateId_ = s;
            break;
          }
          case 24: {

            fromSequenceNr_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.axoniq.axonserver.grpc.event.EventOuterClass.internal_static_io_axoniq_axonserver_grpc_event_ReadHighestSequenceNrRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.axoniq.axonserver.grpc.event.EventOuterClass.internal_static_io_axoniq_axonserver_grpc_event_ReadHighestSequenceNrRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.class, io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.Builder.class);
  }

  public static final int AGGREGATE_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object aggregateId_;
  /**
   * <code>optional string aggregate_id = 1;</code>
   */
  public java.lang.String getAggregateId() {
    java.lang.Object ref = aggregateId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      aggregateId_ = s;
      return s;
    }
  }
  /**
   * <code>optional string aggregate_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAggregateIdBytes() {
    java.lang.Object ref = aggregateId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      aggregateId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FROM_SEQUENCE_NR_FIELD_NUMBER = 3;
  private long fromSequenceNr_;
  /**
   * <code>optional int64 from_sequence_nr = 3;</code>
   */
  public long getFromSequenceNr() {
    return fromSequenceNr_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getAggregateIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, aggregateId_);
    }
    if (fromSequenceNr_ != 0L) {
      output.writeInt64(3, fromSequenceNr_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAggregateIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, aggregateId_);
    }
    if (fromSequenceNr_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, fromSequenceNr_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest)) {
      return super.equals(obj);
    }
    io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest other = (io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest) obj;

    boolean result = true;
    result = result && getAggregateId()
        .equals(other.getAggregateId());
    result = result && (getFromSequenceNr()
        == other.getFromSequenceNr());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + AGGREGATE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getAggregateId().hashCode();
    hash = (37 * hash) + FROM_SEQUENCE_NR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFromSequenceNr());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest)
      io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.axoniq.axonserver.grpc.event.EventOuterClass.internal_static_io_axoniq_axonserver_grpc_event_ReadHighestSequenceNrRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.axoniq.axonserver.grpc.event.EventOuterClass.internal_static_io_axoniq_axonserver_grpc_event_ReadHighestSequenceNrRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.class, io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.Builder.class);
    }

    // Construct using io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      aggregateId_ = "";

      fromSequenceNr_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.axoniq.axonserver.grpc.event.EventOuterClass.internal_static_io_axoniq_axonserver_grpc_event_ReadHighestSequenceNrRequest_descriptor;
    }

    public io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest getDefaultInstanceForType() {
      return io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.getDefaultInstance();
    }

    public io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest build() {
      io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest buildPartial() {
      io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest result = new io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest(this);
      result.aggregateId_ = aggregateId_;
      result.fromSequenceNr_ = fromSequenceNr_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest) {
        return mergeFrom((io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest other) {
      if (other == io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest.getDefaultInstance()) return this;
      if (!other.getAggregateId().isEmpty()) {
        aggregateId_ = other.aggregateId_;
        onChanged();
      }
      if (other.getFromSequenceNr() != 0L) {
        setFromSequenceNr(other.getFromSequenceNr());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object aggregateId_ = "";
    /**
     * <code>optional string aggregate_id = 1;</code>
     */
    public java.lang.String getAggregateId() {
      java.lang.Object ref = aggregateId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        aggregateId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string aggregate_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAggregateIdBytes() {
      java.lang.Object ref = aggregateId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        aggregateId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string aggregate_id = 1;</code>
     */
    public Builder setAggregateId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      aggregateId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string aggregate_id = 1;</code>
     */
    public Builder clearAggregateId() {
      
      aggregateId_ = getDefaultInstance().getAggregateId();
      onChanged();
      return this;
    }
    /**
     * <code>optional string aggregate_id = 1;</code>
     */
    public Builder setAggregateIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      aggregateId_ = value;
      onChanged();
      return this;
    }

    private long fromSequenceNr_ ;
    /**
     * <code>optional int64 from_sequence_nr = 3;</code>
     */
    public long getFromSequenceNr() {
      return fromSequenceNr_;
    }
    /**
     * <code>optional int64 from_sequence_nr = 3;</code>
     */
    public Builder setFromSequenceNr(long value) {
      
      fromSequenceNr_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 from_sequence_nr = 3;</code>
     */
    public Builder clearFromSequenceNr() {
      
      fromSequenceNr_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest)
  }

  // @@protoc_insertion_point(class_scope:io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest)
  private static final io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest();
  }

  public static io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReadHighestSequenceNrRequest>
      PARSER = new com.google.protobuf.AbstractParser<ReadHighestSequenceNrRequest>() {
    public ReadHighestSequenceNrRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ReadHighestSequenceNrRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReadHighestSequenceNrRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReadHighestSequenceNrRequest> getParserForType() {
    return PARSER;
  }

  public io.axoniq.axonserver.grpc.event.ReadHighestSequenceNrRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

