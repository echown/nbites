// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Vision.proto

package messages;

public final class _File_Vision {
  private _File_Vision() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_HoughLine_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_HoughLine_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_FieldLine_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_FieldLine_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_FieldLines_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_FieldLines_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Vision.proto\022\010messages\";\n\tHoughLine\022\t\n" +
      "\001r\030\001 \001(\002\022\t\n\001t\030\002 \001(\002\022\013\n\003ep0\030\003 \001(\002\022\013\n\003ep1\030" +
      "\004 \001(\002\"_\n\tFieldLine\022\"\n\005inner\030\001 \001(\0132\023.mess" +
      "ages.HoughLine\022\"\n\005outer\030\002 \001(\0132\023.messages" +
      ".HoughLine\022\n\n\002id\030\003 \001(\005\"/\n\nFieldLines\022!\n\004" +
      "line\030\001 \003(\0132\023.messages.FieldLineB\020B\014_File" +
      "_VisionP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_messages_HoughLine_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_HoughLine_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_HoughLine_descriptor,
        new java.lang.String[] { "R", "T", "Ep0", "Ep1", });
    internal_static_messages_FieldLine_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_messages_FieldLine_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_FieldLine_descriptor,
        new java.lang.String[] { "Inner", "Outer", "Id", });
    internal_static_messages_FieldLines_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_messages_FieldLines_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_FieldLines_descriptor,
        new java.lang.String[] { "Line", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
