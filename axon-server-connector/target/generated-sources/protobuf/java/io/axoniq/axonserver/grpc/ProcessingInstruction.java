// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package io.axoniq.axonserver.grpc;

/**
 * Protobuf type {@code io.axoniq.axonserver.grpc.ProcessingInstruction}
 */
public  final class ProcessingInstruction extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.axoniq.axonserver.grpc.ProcessingInstruction)
    ProcessingInstructionOrBuilder {
  // Use ProcessingInstruction.newBuilder() to construct.
  private ProcessingInstruction(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ProcessingInstruction() {
    key_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ProcessingInstruction(
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
          case 8: {
            int rawValue = input.readEnum();

            key_ = rawValue;
            break;
          }
          case 18: {
            io.axoniq.axonserver.grpc.MetaDataValue.Builder subBuilder = null;
            if (value_ != null) {
              subBuilder = value_.toBuilder();
            }
            value_ = input.readMessage(io.axoniq.axonserver.grpc.MetaDataValue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(value_);
              value_ = subBuilder.buildPartial();
            }

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
    return io.axoniq.axonserver.grpc.Common.internal_static_io_axoniq_axonserver_grpc_ProcessingInstruction_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.axoniq.axonserver.grpc.Common.internal_static_io_axoniq_axonserver_grpc_ProcessingInstruction_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.axoniq.axonserver.grpc.ProcessingInstruction.class, io.axoniq.axonserver.grpc.ProcessingInstruction.Builder.class);
  }

  public static final int KEY_FIELD_NUMBER = 1;
  private int key_;
  /**
   * <code>optional .io.axoniq.axonserver.grpc.ProcessingKey key = 1;</code>
   */
  public int getKeyValue() {
    return key_;
  }
  /**
   * <code>optional .io.axoniq.axonserver.grpc.ProcessingKey key = 1;</code>
   */
  public io.axoniq.axonserver.grpc.ProcessingKey getKey() {
    io.axoniq.axonserver.grpc.ProcessingKey result = io.axoniq.axonserver.grpc.ProcessingKey.valueOf(key_);
    return result == null ? io.axoniq.axonserver.grpc.ProcessingKey.UNRECOGNIZED : result;
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  private io.axoniq.axonserver.grpc.MetaDataValue value_;
  /**
   * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
   */
  public boolean hasValue() {
    return value_ != null;
  }
  /**
   * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
   */
  public io.axoniq.axonserver.grpc.MetaDataValue getValue() {
    return value_ == null ? io.axoniq.axonserver.grpc.MetaDataValue.getDefaultInstance() : value_;
  }
  /**
   * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
   */
  public io.axoniq.axonserver.grpc.MetaDataValueOrBuilder getValueOrBuilder() {
    return getValue();
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
    if (key_ != io.axoniq.axonserver.grpc.ProcessingKey.ROUTING_KEY.getNumber()) {
      output.writeEnum(1, key_);
    }
    if (value_ != null) {
      output.writeMessage(2, getValue());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (key_ != io.axoniq.axonserver.grpc.ProcessingKey.ROUTING_KEY.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, key_);
    }
    if (value_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getValue());
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
    if (!(obj instanceof io.axoniq.axonserver.grpc.ProcessingInstruction)) {
      return super.equals(obj);
    }
    io.axoniq.axonserver.grpc.ProcessingInstruction other = (io.axoniq.axonserver.grpc.ProcessingInstruction) obj;

    boolean result = true;
    result = result && key_ == other.key_;
    result = result && (hasValue() == other.hasValue());
    if (hasValue()) {
      result = result && getValue()
          .equals(other.getValue());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + key_;
    if (hasValue()) {
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.axoniq.axonserver.grpc.ProcessingInstruction parseFrom(
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
  public static Builder newBuilder(io.axoniq.axonserver.grpc.ProcessingInstruction prototype) {
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
   * Protobuf type {@code io.axoniq.axonserver.grpc.ProcessingInstruction}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.axoniq.axonserver.grpc.ProcessingInstruction)
      io.axoniq.axonserver.grpc.ProcessingInstructionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.axoniq.axonserver.grpc.Common.internal_static_io_axoniq_axonserver_grpc_ProcessingInstruction_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.axoniq.axonserver.grpc.Common.internal_static_io_axoniq_axonserver_grpc_ProcessingInstruction_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.axoniq.axonserver.grpc.ProcessingInstruction.class, io.axoniq.axonserver.grpc.ProcessingInstruction.Builder.class);
    }

    // Construct using io.axoniq.axonserver.grpc.ProcessingInstruction.newBuilder()
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
      key_ = 0;

      if (valueBuilder_ == null) {
        value_ = null;
      } else {
        value_ = null;
        valueBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.axoniq.axonserver.grpc.Common.internal_static_io_axoniq_axonserver_grpc_ProcessingInstruction_descriptor;
    }

    public io.axoniq.axonserver.grpc.ProcessingInstruction getDefaultInstanceForType() {
      return io.axoniq.axonserver.grpc.ProcessingInstruction.getDefaultInstance();
    }

    public io.axoniq.axonserver.grpc.ProcessingInstruction build() {
      io.axoniq.axonserver.grpc.ProcessingInstruction result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.axoniq.axonserver.grpc.ProcessingInstruction buildPartial() {
      io.axoniq.axonserver.grpc.ProcessingInstruction result = new io.axoniq.axonserver.grpc.ProcessingInstruction(this);
      result.key_ = key_;
      if (valueBuilder_ == null) {
        result.value_ = value_;
      } else {
        result.value_ = valueBuilder_.build();
      }
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
      if (other instanceof io.axoniq.axonserver.grpc.ProcessingInstruction) {
        return mergeFrom((io.axoniq.axonserver.grpc.ProcessingInstruction)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.axoniq.axonserver.grpc.ProcessingInstruction other) {
      if (other == io.axoniq.axonserver.grpc.ProcessingInstruction.getDefaultInstance()) return this;
      if (other.key_ != 0) {
        setKeyValue(other.getKeyValue());
      }
      if (other.hasValue()) {
        mergeValue(other.getValue());
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
      io.axoniq.axonserver.grpc.ProcessingInstruction parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.axoniq.axonserver.grpc.ProcessingInstruction) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int key_ = 0;
    /**
     * <code>optional .io.axoniq.axonserver.grpc.ProcessingKey key = 1;</code>
     */
    public int getKeyValue() {
      return key_;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.ProcessingKey key = 1;</code>
     */
    public Builder setKeyValue(int value) {
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.ProcessingKey key = 1;</code>
     */
    public io.axoniq.axonserver.grpc.ProcessingKey getKey() {
      io.axoniq.axonserver.grpc.ProcessingKey result = io.axoniq.axonserver.grpc.ProcessingKey.valueOf(key_);
      return result == null ? io.axoniq.axonserver.grpc.ProcessingKey.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.ProcessingKey key = 1;</code>
     */
    public Builder setKey(io.axoniq.axonserver.grpc.ProcessingKey value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      key_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.ProcessingKey key = 1;</code>
     */
    public Builder clearKey() {
      
      key_ = 0;
      onChanged();
      return this;
    }

    private io.axoniq.axonserver.grpc.MetaDataValue value_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.axoniq.axonserver.grpc.MetaDataValue, io.axoniq.axonserver.grpc.MetaDataValue.Builder, io.axoniq.axonserver.grpc.MetaDataValueOrBuilder> valueBuilder_;
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public boolean hasValue() {
      return valueBuilder_ != null || value_ != null;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public io.axoniq.axonserver.grpc.MetaDataValue getValue() {
      if (valueBuilder_ == null) {
        return value_ == null ? io.axoniq.axonserver.grpc.MetaDataValue.getDefaultInstance() : value_;
      } else {
        return valueBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public Builder setValue(io.axoniq.axonserver.grpc.MetaDataValue value) {
      if (valueBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        value_ = value;
        onChanged();
      } else {
        valueBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public Builder setValue(
        io.axoniq.axonserver.grpc.MetaDataValue.Builder builderForValue) {
      if (valueBuilder_ == null) {
        value_ = builderForValue.build();
        onChanged();
      } else {
        valueBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public Builder mergeValue(io.axoniq.axonserver.grpc.MetaDataValue value) {
      if (valueBuilder_ == null) {
        if (value_ != null) {
          value_ =
            io.axoniq.axonserver.grpc.MetaDataValue.newBuilder(value_).mergeFrom(value).buildPartial();
        } else {
          value_ = value;
        }
        onChanged();
      } else {
        valueBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public Builder clearValue() {
      if (valueBuilder_ == null) {
        value_ = null;
        onChanged();
      } else {
        value_ = null;
        valueBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public io.axoniq.axonserver.grpc.MetaDataValue.Builder getValueBuilder() {
      
      onChanged();
      return getValueFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    public io.axoniq.axonserver.grpc.MetaDataValueOrBuilder getValueOrBuilder() {
      if (valueBuilder_ != null) {
        return valueBuilder_.getMessageOrBuilder();
      } else {
        return value_ == null ?
            io.axoniq.axonserver.grpc.MetaDataValue.getDefaultInstance() : value_;
      }
    }
    /**
     * <code>optional .io.axoniq.axonserver.grpc.MetaDataValue value = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.axoniq.axonserver.grpc.MetaDataValue, io.axoniq.axonserver.grpc.MetaDataValue.Builder, io.axoniq.axonserver.grpc.MetaDataValueOrBuilder> 
        getValueFieldBuilder() {
      if (valueBuilder_ == null) {
        valueBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.axoniq.axonserver.grpc.MetaDataValue, io.axoniq.axonserver.grpc.MetaDataValue.Builder, io.axoniq.axonserver.grpc.MetaDataValueOrBuilder>(
                getValue(),
                getParentForChildren(),
                isClean());
        value_ = null;
      }
      return valueBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:io.axoniq.axonserver.grpc.ProcessingInstruction)
  }

  // @@protoc_insertion_point(class_scope:io.axoniq.axonserver.grpc.ProcessingInstruction)
  private static final io.axoniq.axonserver.grpc.ProcessingInstruction DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.axoniq.axonserver.grpc.ProcessingInstruction();
  }

  public static io.axoniq.axonserver.grpc.ProcessingInstruction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ProcessingInstruction>
      PARSER = new com.google.protobuf.AbstractParser<ProcessingInstruction>() {
    public ProcessingInstruction parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ProcessingInstruction(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ProcessingInstruction> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ProcessingInstruction> getParserForType() {
    return PARSER;
  }

  public io.axoniq.axonserver.grpc.ProcessingInstruction getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

