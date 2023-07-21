/*
 * Copyright 2023 Google LLC
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

public interface GetHmacKeyRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.storage.v2.GetHmacKeyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The identifying key for the HMAC to delete.
   * </pre>
   *
   * <code>string access_id = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The accessId.
   */
  java.lang.String getAccessId();
  /**
   *
   *
   * <pre>
   * Required. The identifying key for the HMAC to delete.
   * </pre>
   *
   * <code>string access_id = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for accessId.
   */
  com.google.protobuf.ByteString getAccessIdBytes();

  /**
   *
   *
   * <pre>
   * Required. The project the HMAC key lies in, in the format of
   * "projects/{projectIdentifier}".
   * {projectIdentifier} can be the project ID or project number.
   * </pre>
   *
   * <code>
   * string project = 2 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The project.
   */
  java.lang.String getProject();
  /**
   *
   *
   * <pre>
   * Required. The project the HMAC key lies in, in the format of
   * "projects/{projectIdentifier}".
   * {projectIdentifier} can be the project ID or project number.
   * </pre>
   *
   * <code>
   * string project = 2 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for project.
   */
  com.google.protobuf.ByteString getProjectBytes();
}
