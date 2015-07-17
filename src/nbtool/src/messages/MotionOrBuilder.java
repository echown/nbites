// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Motion.proto

package messages;

public interface MotionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:messages.Motion)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 timestamp = 1;</code>
   */
  boolean hasTimestamp();
  /**
   * <code>optional int64 timestamp = 1;</code>
   */
  long getTimestamp();

  /**
   * <code>optional string current_body_provider = 2;</code>
   */
  boolean hasCurrentBodyProvider();
  /**
   * <code>optional string current_body_provider = 2;</code>
   */
  java.lang.String getCurrentBodyProvider();
  /**
   * <code>optional string current_body_provider = 2;</code>
   */
  com.google.protobuf.ByteString
      getCurrentBodyProviderBytes();

  /**
   * <code>optional string next_body_provider = 3;</code>
   */
  boolean hasNextBodyProvider();
  /**
   * <code>optional string next_body_provider = 3;</code>
   */
  java.lang.String getNextBodyProvider();
  /**
   * <code>optional string next_body_provider = 3;</code>
   */
  com.google.protobuf.ByteString
      getNextBodyProviderBytes();

  /**
   * <code>optional .messages.RobotLocation odometry = 4;</code>
   */
  boolean hasOdometry();
  /**
   * <code>optional .messages.RobotLocation odometry = 4;</code>
   */
  messages.RobotLocation getOdometry();
  /**
   * <code>optional .messages.RobotLocation odometry = 4;</code>
   */
  messages.RobotLocationOrBuilder getOdometryOrBuilder();

  /**
   * <code>optional .messages.WalkProvider walk_provider = 5;</code>
   */
  boolean hasWalkProvider();
  /**
   * <code>optional .messages.WalkProvider walk_provider = 5;</code>
   */
  messages.WalkProvider getWalkProvider();
  /**
   * <code>optional .messages.WalkProvider walk_provider = 5;</code>
   */
  messages.WalkProviderOrBuilder getWalkProviderOrBuilder();

  /**
   * <code>optional .messages.ScriptedProvider scripted_provider = 6;</code>
   */
  boolean hasScriptedProvider();
  /**
   * <code>optional .messages.ScriptedProvider scripted_provider = 6;</code>
   */
  messages.ScriptedProvider getScriptedProvider();
  /**
   * <code>optional .messages.ScriptedProvider scripted_provider = 6;</code>
   */
  messages.ScriptedProviderOrBuilder getScriptedProviderOrBuilder();

  /**
   * <code>optional bool support_foot = 7;</code>
   */
  boolean hasSupportFoot();
  /**
   * <code>optional bool support_foot = 7;</code>
   */
  boolean getSupportFoot();
}