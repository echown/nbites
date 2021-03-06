// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PMotion.proto

package messages;

/**
 * Protobuf type {@code messages.ScriptedHeadCommand}
 */
public final class ScriptedHeadCommand extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.ScriptedHeadCommand)
    ScriptedHeadCommandOrBuilder {
  // Use ScriptedHeadCommand.newBuilder() to construct.
  private ScriptedHeadCommand(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private ScriptedHeadCommand(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final ScriptedHeadCommand defaultInstance;
  public static ScriptedHeadCommand getDefaultInstance() {
    return defaultInstance;
  }

  public ScriptedHeadCommand getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private ScriptedHeadCommand(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              command_ = new java.util.ArrayList<messages.HeadJointCommand>();
              mutable_bitField0_ |= 0x00000001;
            }
            command_.add(input.readMessage(messages.HeadJointCommand.PARSER, extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        command_ = java.util.Collections.unmodifiableList(command_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages._File_PMotion.internal_static_messages_ScriptedHeadCommand_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_PMotion.internal_static_messages_ScriptedHeadCommand_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.ScriptedHeadCommand.class, messages.ScriptedHeadCommand.Builder.class);
  }

  public static com.google.protobuf.Parser<ScriptedHeadCommand> PARSER =
      new com.google.protobuf.AbstractParser<ScriptedHeadCommand>() {
    public ScriptedHeadCommand parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ScriptedHeadCommand(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<ScriptedHeadCommand> getParserForType() {
    return PARSER;
  }

  public static final int COMMAND_FIELD_NUMBER = 1;
  private java.util.List<messages.HeadJointCommand> command_;
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  public java.util.List<messages.HeadJointCommand> getCommandList() {
    return command_;
  }
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  public java.util.List<? extends messages.HeadJointCommandOrBuilder> 
      getCommandOrBuilderList() {
    return command_;
  }
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  public int getCommandCount() {
    return command_.size();
  }
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  public messages.HeadJointCommand getCommand(int index) {
    return command_.get(index);
  }
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  public messages.HeadJointCommandOrBuilder getCommandOrBuilder(
      int index) {
    return command_.get(index);
  }

  private void initFields() {
    command_ = java.util.Collections.emptyList();
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
    for (int i = 0; i < command_.size(); i++) {
      output.writeMessage(1, command_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < command_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, command_.get(i));
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

  public static messages.ScriptedHeadCommand parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.ScriptedHeadCommand parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.ScriptedHeadCommand parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.ScriptedHeadCommand parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.ScriptedHeadCommand parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.ScriptedHeadCommand parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.ScriptedHeadCommand parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.ScriptedHeadCommand parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.ScriptedHeadCommand parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.ScriptedHeadCommand parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.ScriptedHeadCommand prototype) {
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
   * Protobuf type {@code messages.ScriptedHeadCommand}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.ScriptedHeadCommand)
      messages.ScriptedHeadCommandOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_PMotion.internal_static_messages_ScriptedHeadCommand_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_PMotion.internal_static_messages_ScriptedHeadCommand_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.ScriptedHeadCommand.class, messages.ScriptedHeadCommand.Builder.class);
    }

    // Construct using messages.ScriptedHeadCommand.newBuilder()
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
        getCommandFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      if (commandBuilder_ == null) {
        command_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        commandBuilder_.clear();
      }
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_PMotion.internal_static_messages_ScriptedHeadCommand_descriptor;
    }

    public messages.ScriptedHeadCommand getDefaultInstanceForType() {
      return messages.ScriptedHeadCommand.getDefaultInstance();
    }

    public messages.ScriptedHeadCommand build() {
      messages.ScriptedHeadCommand result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.ScriptedHeadCommand buildPartial() {
      messages.ScriptedHeadCommand result = new messages.ScriptedHeadCommand(this);
      int from_bitField0_ = bitField0_;
      if (commandBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          command_ = java.util.Collections.unmodifiableList(command_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.command_ = command_;
      } else {
        result.command_ = commandBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.ScriptedHeadCommand) {
        return mergeFrom((messages.ScriptedHeadCommand)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.ScriptedHeadCommand other) {
      if (other == messages.ScriptedHeadCommand.getDefaultInstance()) return this;
      if (commandBuilder_ == null) {
        if (!other.command_.isEmpty()) {
          if (command_.isEmpty()) {
            command_ = other.command_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCommandIsMutable();
            command_.addAll(other.command_);
          }
          onChanged();
        }
      } else {
        if (!other.command_.isEmpty()) {
          if (commandBuilder_.isEmpty()) {
            commandBuilder_.dispose();
            commandBuilder_ = null;
            command_ = other.command_;
            bitField0_ = (bitField0_ & ~0x00000001);
            commandBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getCommandFieldBuilder() : null;
          } else {
            commandBuilder_.addAllMessages(other.command_);
          }
        }
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
      messages.ScriptedHeadCommand parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.ScriptedHeadCommand) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<messages.HeadJointCommand> command_ =
      java.util.Collections.emptyList();
    private void ensureCommandIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        command_ = new java.util.ArrayList<messages.HeadJointCommand>(command_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        messages.HeadJointCommand, messages.HeadJointCommand.Builder, messages.HeadJointCommandOrBuilder> commandBuilder_;

    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public java.util.List<messages.HeadJointCommand> getCommandList() {
      if (commandBuilder_ == null) {
        return java.util.Collections.unmodifiableList(command_);
      } else {
        return commandBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public int getCommandCount() {
      if (commandBuilder_ == null) {
        return command_.size();
      } else {
        return commandBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public messages.HeadJointCommand getCommand(int index) {
      if (commandBuilder_ == null) {
        return command_.get(index);
      } else {
        return commandBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder setCommand(
        int index, messages.HeadJointCommand value) {
      if (commandBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCommandIsMutable();
        command_.set(index, value);
        onChanged();
      } else {
        commandBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder setCommand(
        int index, messages.HeadJointCommand.Builder builderForValue) {
      if (commandBuilder_ == null) {
        ensureCommandIsMutable();
        command_.set(index, builderForValue.build());
        onChanged();
      } else {
        commandBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder addCommand(messages.HeadJointCommand value) {
      if (commandBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCommandIsMutable();
        command_.add(value);
        onChanged();
      } else {
        commandBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder addCommand(
        int index, messages.HeadJointCommand value) {
      if (commandBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCommandIsMutable();
        command_.add(index, value);
        onChanged();
      } else {
        commandBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder addCommand(
        messages.HeadJointCommand.Builder builderForValue) {
      if (commandBuilder_ == null) {
        ensureCommandIsMutable();
        command_.add(builderForValue.build());
        onChanged();
      } else {
        commandBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder addCommand(
        int index, messages.HeadJointCommand.Builder builderForValue) {
      if (commandBuilder_ == null) {
        ensureCommandIsMutable();
        command_.add(index, builderForValue.build());
        onChanged();
      } else {
        commandBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder addAllCommand(
        java.lang.Iterable<? extends messages.HeadJointCommand> values) {
      if (commandBuilder_ == null) {
        ensureCommandIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, command_);
        onChanged();
      } else {
        commandBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder clearCommand() {
      if (commandBuilder_ == null) {
        command_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        commandBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public Builder removeCommand(int index) {
      if (commandBuilder_ == null) {
        ensureCommandIsMutable();
        command_.remove(index);
        onChanged();
      } else {
        commandBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public messages.HeadJointCommand.Builder getCommandBuilder(
        int index) {
      return getCommandFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public messages.HeadJointCommandOrBuilder getCommandOrBuilder(
        int index) {
      if (commandBuilder_ == null) {
        return command_.get(index);  } else {
        return commandBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public java.util.List<? extends messages.HeadJointCommandOrBuilder> 
         getCommandOrBuilderList() {
      if (commandBuilder_ != null) {
        return commandBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(command_);
      }
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public messages.HeadJointCommand.Builder addCommandBuilder() {
      return getCommandFieldBuilder().addBuilder(
          messages.HeadJointCommand.getDefaultInstance());
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public messages.HeadJointCommand.Builder addCommandBuilder(
        int index) {
      return getCommandFieldBuilder().addBuilder(
          index, messages.HeadJointCommand.getDefaultInstance());
    }
    /**
     * <code>repeated .messages.HeadJointCommand command = 1;</code>
     */
    public java.util.List<messages.HeadJointCommand.Builder> 
         getCommandBuilderList() {
      return getCommandFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        messages.HeadJointCommand, messages.HeadJointCommand.Builder, messages.HeadJointCommandOrBuilder> 
        getCommandFieldBuilder() {
      if (commandBuilder_ == null) {
        commandBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            messages.HeadJointCommand, messages.HeadJointCommand.Builder, messages.HeadJointCommandOrBuilder>(
                command_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        command_ = null;
      }
      return commandBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:messages.ScriptedHeadCommand)
  }

  static {
    defaultInstance = new ScriptedHeadCommand(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.ScriptedHeadCommand)
}

