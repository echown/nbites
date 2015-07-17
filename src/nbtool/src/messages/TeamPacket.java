// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TeamPacket.proto

package messages;

/**
 * Protobuf type {@code messages.TeamPacket}
 */
public final class TeamPacket extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.TeamPacket)
    TeamPacketOrBuilder {
  // Use TeamPacket.newBuilder() to construct.
  private TeamPacket(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private TeamPacket(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final TeamPacket defaultInstance;
  public static TeamPacket getDefaultInstance() {
    return defaultInstance;
  }

  public TeamPacket getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private TeamPacket(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000001;
            header_ = bs;
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            teamNumber_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            playerNumber_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            sequenceNumber_ = input.readInt32();
            break;
          }
          case 40: {
            bitField0_ |= 0x00000010;
            timestamp_ = input.readInt64();
            break;
          }
          case 50: {
            messages.WorldModel.Builder subBuilder = null;
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
              subBuilder = payload_.toBuilder();
            }
            payload_ = input.readMessage(messages.WorldModel.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(payload_);
              payload_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000020;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages._File_TeamPacket.internal_static_messages_TeamPacket_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_TeamPacket.internal_static_messages_TeamPacket_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.TeamPacket.class, messages.TeamPacket.Builder.class);
  }

  public static com.google.protobuf.Parser<TeamPacket> PARSER =
      new com.google.protobuf.AbstractParser<TeamPacket>() {
    public TeamPacket parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TeamPacket(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<TeamPacket> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  public static final int HEADER_FIELD_NUMBER = 1;
  private java.lang.Object header_;
  /**
   * <code>optional string header = 1;</code>
   */
  public boolean hasHeader() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional string header = 1;</code>
   */
  public java.lang.String getHeader() {
    java.lang.Object ref = header_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        header_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string header = 1;</code>
   */
  public com.google.protobuf.ByteString
      getHeaderBytes() {
    java.lang.Object ref = header_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      header_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TEAM_NUMBER_FIELD_NUMBER = 2;
  private int teamNumber_;
  /**
   * <code>optional int32 team_number = 2;</code>
   */
  public boolean hasTeamNumber() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 team_number = 2;</code>
   */
  public int getTeamNumber() {
    return teamNumber_;
  }

  public static final int PLAYER_NUMBER_FIELD_NUMBER = 3;
  private int playerNumber_;
  /**
   * <code>optional int32 player_number = 3;</code>
   */
  public boolean hasPlayerNumber() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 player_number = 3;</code>
   */
  public int getPlayerNumber() {
    return playerNumber_;
  }

  public static final int SEQUENCE_NUMBER_FIELD_NUMBER = 4;
  private int sequenceNumber_;
  /**
   * <code>optional int32 sequence_number = 4;</code>
   */
  public boolean hasSequenceNumber() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional int32 sequence_number = 4;</code>
   */
  public int getSequenceNumber() {
    return sequenceNumber_;
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 5;
  private long timestamp_;
  /**
   * <code>optional int64 timestamp = 5;</code>
   */
  public boolean hasTimestamp() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional int64 timestamp = 5;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  public static final int PAYLOAD_FIELD_NUMBER = 6;
  private messages.WorldModel payload_;
  /**
   * <code>optional .messages.WorldModel payload = 6;</code>
   */
  public boolean hasPayload() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <code>optional .messages.WorldModel payload = 6;</code>
   */
  public messages.WorldModel getPayload() {
    return payload_;
  }
  /**
   * <code>optional .messages.WorldModel payload = 6;</code>
   */
  public messages.WorldModelOrBuilder getPayloadOrBuilder() {
    return payload_;
  }

  private void initFields() {
    header_ = "";
    teamNumber_ = 0;
    playerNumber_ = 0;
    sequenceNumber_ = 0;
    timestamp_ = 0L;
    payload_ = messages.WorldModel.getDefaultInstance();
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
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeBytes(1, getHeaderBytes());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, teamNumber_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, playerNumber_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, sequenceNumber_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeInt64(5, timestamp_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeMessage(6, payload_);
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, getHeaderBytes());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, teamNumber_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, playerNumber_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, sequenceNumber_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, timestamp_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, payload_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static messages.TeamPacket parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.TeamPacket parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.TeamPacket parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.TeamPacket parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.TeamPacket parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.TeamPacket parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.TeamPacket parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.TeamPacket parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.TeamPacket parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.TeamPacket parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.TeamPacket prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code messages.TeamPacket}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.TeamPacket)
      messages.TeamPacketOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_TeamPacket.internal_static_messages_TeamPacket_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_TeamPacket.internal_static_messages_TeamPacket_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.TeamPacket.class, messages.TeamPacket.Builder.class);
    }

    // Construct using messages.TeamPacket.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        getPayloadFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      header_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      teamNumber_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      playerNumber_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      sequenceNumber_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      timestamp_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000010);
      if (payloadBuilder_ == null) {
        payload_ = messages.WorldModel.getDefaultInstance();
      } else {
        payloadBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_TeamPacket.internal_static_messages_TeamPacket_descriptor;
    }

    public messages.TeamPacket getDefaultInstanceForType() {
      return messages.TeamPacket.getDefaultInstance();
    }

    public messages.TeamPacket build() {
      messages.TeamPacket result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.TeamPacket buildPartial() {
      messages.TeamPacket result = new messages.TeamPacket(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.header_ = header_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.teamNumber_ = teamNumber_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.playerNumber_ = playerNumber_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.sequenceNumber_ = sequenceNumber_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.timestamp_ = timestamp_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      if (payloadBuilder_ == null) {
        result.payload_ = payload_;
      } else {
        result.payload_ = payloadBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.TeamPacket) {
        return mergeFrom((messages.TeamPacket)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.TeamPacket other) {
      if (other == messages.TeamPacket.getDefaultInstance()) return this;
      if (other.hasHeader()) {
        bitField0_ |= 0x00000001;
        header_ = other.header_;
        onChanged();
      }
      if (other.hasTeamNumber()) {
        setTeamNumber(other.getTeamNumber());
      }
      if (other.hasPlayerNumber()) {
        setPlayerNumber(other.getPlayerNumber());
      }
      if (other.hasSequenceNumber()) {
        setSequenceNumber(other.getSequenceNumber());
      }
      if (other.hasTimestamp()) {
        setTimestamp(other.getTimestamp());
      }
      if (other.hasPayload()) {
        mergePayload(other.getPayload());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      messages.TeamPacket parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.TeamPacket) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object header_ = "";
    /**
     * <code>optional string header = 1;</code>
     */
    public boolean hasHeader() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string header = 1;</code>
     */
    public java.lang.String getHeader() {
      java.lang.Object ref = header_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          header_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string header = 1;</code>
     */
    public com.google.protobuf.ByteString
        getHeaderBytes() {
      java.lang.Object ref = header_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        header_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string header = 1;</code>
     */
    public Builder setHeader(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      header_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string header = 1;</code>
     */
    public Builder clearHeader() {
      bitField0_ = (bitField0_ & ~0x00000001);
      header_ = getDefaultInstance().getHeader();
      onChanged();
      return this;
    }
    /**
     * <code>optional string header = 1;</code>
     */
    public Builder setHeaderBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      header_ = value;
      onChanged();
      return this;
    }

    private int teamNumber_ ;
    /**
     * <code>optional int32 team_number = 2;</code>
     */
    public boolean hasTeamNumber() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 team_number = 2;</code>
     */
    public int getTeamNumber() {
      return teamNumber_;
    }
    /**
     * <code>optional int32 team_number = 2;</code>
     */
    public Builder setTeamNumber(int value) {
      bitField0_ |= 0x00000002;
      teamNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 team_number = 2;</code>
     */
    public Builder clearTeamNumber() {
      bitField0_ = (bitField0_ & ~0x00000002);
      teamNumber_ = 0;
      onChanged();
      return this;
    }

    private int playerNumber_ ;
    /**
     * <code>optional int32 player_number = 3;</code>
     */
    public boolean hasPlayerNumber() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 player_number = 3;</code>
     */
    public int getPlayerNumber() {
      return playerNumber_;
    }
    /**
     * <code>optional int32 player_number = 3;</code>
     */
    public Builder setPlayerNumber(int value) {
      bitField0_ |= 0x00000004;
      playerNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 player_number = 3;</code>
     */
    public Builder clearPlayerNumber() {
      bitField0_ = (bitField0_ & ~0x00000004);
      playerNumber_ = 0;
      onChanged();
      return this;
    }

    private int sequenceNumber_ ;
    /**
     * <code>optional int32 sequence_number = 4;</code>
     */
    public boolean hasSequenceNumber() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 sequence_number = 4;</code>
     */
    public int getSequenceNumber() {
      return sequenceNumber_;
    }
    /**
     * <code>optional int32 sequence_number = 4;</code>
     */
    public Builder setSequenceNumber(int value) {
      bitField0_ |= 0x00000008;
      sequenceNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 sequence_number = 4;</code>
     */
    public Builder clearSequenceNumber() {
      bitField0_ = (bitField0_ & ~0x00000008);
      sequenceNumber_ = 0;
      onChanged();
      return this;
    }

    private long timestamp_ ;
    /**
     * <code>optional int64 timestamp = 5;</code>
     */
    public boolean hasTimestamp() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional int64 timestamp = 5;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }
    /**
     * <code>optional int64 timestamp = 5;</code>
     */
    public Builder setTimestamp(long value) {
      bitField0_ |= 0x00000010;
      timestamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 timestamp = 5;</code>
     */
    public Builder clearTimestamp() {
      bitField0_ = (bitField0_ & ~0x00000010);
      timestamp_ = 0L;
      onChanged();
      return this;
    }

    private messages.WorldModel payload_ = messages.WorldModel.getDefaultInstance();
    private com.google.protobuf.SingleFieldBuilder<
        messages.WorldModel, messages.WorldModel.Builder, messages.WorldModelOrBuilder> payloadBuilder_;
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public boolean hasPayload() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public messages.WorldModel getPayload() {
      if (payloadBuilder_ == null) {
        return payload_;
      } else {
        return payloadBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public Builder setPayload(messages.WorldModel value) {
      if (payloadBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        payload_ = value;
        onChanged();
      } else {
        payloadBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000020;
      return this;
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public Builder setPayload(
        messages.WorldModel.Builder builderForValue) {
      if (payloadBuilder_ == null) {
        payload_ = builderForValue.build();
        onChanged();
      } else {
        payloadBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000020;
      return this;
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public Builder mergePayload(messages.WorldModel value) {
      if (payloadBuilder_ == null) {
        if (((bitField0_ & 0x00000020) == 0x00000020) &&
            payload_ != messages.WorldModel.getDefaultInstance()) {
          payload_ =
            messages.WorldModel.newBuilder(payload_).mergeFrom(value).buildPartial();
        } else {
          payload_ = value;
        }
        onChanged();
      } else {
        payloadBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000020;
      return this;
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public Builder clearPayload() {
      if (payloadBuilder_ == null) {
        payload_ = messages.WorldModel.getDefaultInstance();
        onChanged();
      } else {
        payloadBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public messages.WorldModel.Builder getPayloadBuilder() {
      bitField0_ |= 0x00000020;
      onChanged();
      return getPayloadFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    public messages.WorldModelOrBuilder getPayloadOrBuilder() {
      if (payloadBuilder_ != null) {
        return payloadBuilder_.getMessageOrBuilder();
      } else {
        return payload_;
      }
    }
    /**
     * <code>optional .messages.WorldModel payload = 6;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        messages.WorldModel, messages.WorldModel.Builder, messages.WorldModelOrBuilder> 
        getPayloadFieldBuilder() {
      if (payloadBuilder_ == null) {
        payloadBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            messages.WorldModel, messages.WorldModel.Builder, messages.WorldModelOrBuilder>(
                getPayload(),
                getParentForChildren(),
                isClean());
        payload_ = null;
      }
      return payloadBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:messages.TeamPacket)
  }

  static {
    defaultInstance = new TeamPacket(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.TeamPacket)
}
