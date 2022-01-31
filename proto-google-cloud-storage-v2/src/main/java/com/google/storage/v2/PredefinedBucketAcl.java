/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/storage/v2/storage.proto

package com.google.storage.v2;

/**
 *
 *
 * <pre>
 * A set of predefined, or "canned," ACLs that can be set on a
 * bucket instead of manually specifying a complete ACL.
 * </pre>
 *
 * Protobuf enum {@code google.storage.v2.PredefinedBucketAcl}
 */
public enum PredefinedBucketAcl implements com.google.protobuf.ProtocolMessageEnum {
  /**
   *
   *
   * <pre>
   * No predefined ACL.
   * </pre>
   *
   * <code>PREDEFINED_BUCKET_ACL_UNSPECIFIED = 0;</code>
   */
  PREDEFINED_BUCKET_ACL_UNSPECIFIED(0),
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access, and
   * `allAuthenticatedUsers` get `READER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_AUTHENTICATED_READ = 1;</code>
   */
  BUCKET_ACL_AUTHENTICATED_READ(1),
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_PRIVATE = 2;</code>
   */
  BUCKET_ACL_PRIVATE(2),
  /**
   *
   *
   * <pre>
   * Project team members get access according to their roles.
   * </pre>
   *
   * <code>BUCKET_ACL_PROJECT_PRIVATE = 3;</code>
   */
  BUCKET_ACL_PROJECT_PRIVATE(3),
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access, and
   * `allUsers` get `READER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_PUBLIC_READ = 4;</code>
   */
  BUCKET_ACL_PUBLIC_READ(4),
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access, and
   * `allUsers` get `WRITER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_PUBLIC_READ_WRITE = 5;</code>
   */
  BUCKET_ACL_PUBLIC_READ_WRITE(5),
  UNRECOGNIZED(-1),
  ;

  /**
   *
   *
   * <pre>
   * No predefined ACL.
   * </pre>
   *
   * <code>PREDEFINED_BUCKET_ACL_UNSPECIFIED = 0;</code>
   */
  public static final int PREDEFINED_BUCKET_ACL_UNSPECIFIED_VALUE = 0;
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access, and
   * `allAuthenticatedUsers` get `READER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_AUTHENTICATED_READ = 1;</code>
   */
  public static final int BUCKET_ACL_AUTHENTICATED_READ_VALUE = 1;
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_PRIVATE = 2;</code>
   */
  public static final int BUCKET_ACL_PRIVATE_VALUE = 2;
  /**
   *
   *
   * <pre>
   * Project team members get access according to their roles.
   * </pre>
   *
   * <code>BUCKET_ACL_PROJECT_PRIVATE = 3;</code>
   */
  public static final int BUCKET_ACL_PROJECT_PRIVATE_VALUE = 3;
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access, and
   * `allUsers` get `READER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_PUBLIC_READ = 4;</code>
   */
  public static final int BUCKET_ACL_PUBLIC_READ_VALUE = 4;
  /**
   *
   *
   * <pre>
   * Project team owners get `OWNER` access, and
   * `allUsers` get `WRITER` access.
   * </pre>
   *
   * <code>BUCKET_ACL_PUBLIC_READ_WRITE = 5;</code>
   */
  public static final int BUCKET_ACL_PUBLIC_READ_WRITE_VALUE = 5;

  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static PredefinedBucketAcl valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static PredefinedBucketAcl forNumber(int value) {
    switch (value) {
      case 0:
        return PREDEFINED_BUCKET_ACL_UNSPECIFIED;
      case 1:
        return BUCKET_ACL_AUTHENTICATED_READ;
      case 2:
        return BUCKET_ACL_PRIVATE;
      case 3:
        return BUCKET_ACL_PROJECT_PRIVATE;
      case 4:
        return BUCKET_ACL_PUBLIC_READ;
      case 5:
        return BUCKET_ACL_PUBLIC_READ_WRITE;
      default:
        return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<PredefinedBucketAcl>
      internalGetValueMap() {
    return internalValueMap;
  }

  private static final com.google.protobuf.Internal.EnumLiteMap<PredefinedBucketAcl>
      internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<PredefinedBucketAcl>() {
            public PredefinedBucketAcl findValueByNumber(int number) {
              return PredefinedBucketAcl.forNumber(number);
            }
          };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }

  public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
    return getDescriptor();
  }

  public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
    return com.google.storage.v2.StorageProto.getDescriptor().getEnumTypes().get(1);
  }

  private static final PredefinedBucketAcl[] VALUES = values();

  public static PredefinedBucketAcl valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private PredefinedBucketAcl(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:google.storage.v2.PredefinedBucketAcl)
}