// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Obstacle.proto

package messages;

public final class _File_Obstacle {
  private _File_Obstacle() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_FieldObstacles_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_FieldObstacles_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_FieldObstacles_Obstacle_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_FieldObstacles_Obstacle_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016Obstacle.proto\022\010messages\"\257\002\n\016FieldObst" +
      "acles\0223\n\010obstacle\030\001 \003(\0132!.messages.Field" +
      "Obstacles.Obstacle\032\347\001\n\010Obstacle\022D\n\010posit" +
      "ion\030\001 \001(\01622.messages.FieldObstacles.Obst" +
      "acle.ObstaclePosition\022\020\n\010distance\030\002 \001(\002\"" +
      "\202\001\n\020ObstaclePosition\022\010\n\004NONE\020\000\022\t\n\005NORTH\020" +
      "\001\022\r\n\tNORTHEAST\020\002\022\010\n\004EAST\020\003\022\r\n\tSOUTHEAST\020" +
      "\004\022\t\n\005SOUTH\020\005\022\r\n\tSOUTHWEST\020\006\022\010\n\004WEST\020\007\022\r\n" +
      "\tNORTHWEST\020\010B\022B\016_File_ObstacleP\001"
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
    internal_static_messages_FieldObstacles_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_FieldObstacles_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_FieldObstacles_descriptor,
        new java.lang.String[] { "Obstacle", });
    internal_static_messages_FieldObstacles_Obstacle_descriptor =
      internal_static_messages_FieldObstacles_descriptor.getNestedTypes().get(0);
    internal_static_messages_FieldObstacles_Obstacle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_FieldObstacles_Obstacle_descriptor,
        new java.lang.String[] { "Position", "Distance", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
