/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketFixture;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage.CreateHmacKeyOption;
import com.google.cloud.storage.Storage.ListHmacKeysOption;
import com.google.cloud.storage.StorageFixture;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.conformance.retry.CleanupStrategy;
import com.google.cloud.storage.conformance.retry.TestBench;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ImmutableList;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;
import org.junit.ClassRule;
import org.junit.Test;

public final class ITGrpcTest {
  @ClassRule(order = 1)
  public static final TestBench TEST_BENCH =
      TestBench.newBuilder().setContainerName("it-grpc").build();

  @ClassRule(order = 2)
  public static final StorageFixture storageFixture =
      StorageFixture.from(
          () ->
              StorageOptions.grpc()
                  .setHost(TEST_BENCH.getGRPCBaseUri())
                  .setCredentials(NoCredentials.getInstance())
                  .setProjectId("test-project-id")
                  .build());

  @ClassRule(order = 3)
  public static final BucketFixture bucketFixture =
      BucketFixture.newBuilder()
          .setBucketNameFmtString("java-storage-grpc-%s")
          .setCleanupStrategy(CleanupStrategy.ALWAYS)
          .setHandle(storageFixture::getInstance)
          .build();

  @Test
  public void testCreateBucket() {
    final String bucketName = RemoteStorageHelper.generateBucketName();
    Bucket bucket = storageFixture.getInstance().create(BucketInfo.of(bucketName));
    assertThat(bucket.getName()).isEqualTo(bucketName);
  }

  @Test
  public void listBlobs() {
    BucketInfo bucketInfo = bucketFixture.getBucketInfo();
    Page<Blob> list = storageFixture.getInstance().list(bucketInfo.getName());
    ImmutableList<String> bucketNames =
        StreamSupport.stream(list.iterateAll().spliterator(), false)
            .map(Blob::getName)
            .collect(ImmutableList.toImmutableList());

    assertThat(bucketNames).isEmpty();
  }

  @Test
  public void listBuckets() {
    Page<Bucket> list = storageFixture.getInstance().list();
    ImmutableList<String> bucketNames =
        StreamSupport.stream(list.iterateAll().spliterator(), false)
            .map(Bucket::getName)
            .collect(ImmutableList.toImmutableList());

    assertThat(bucketNames).contains(bucketFixture.getBucketInfo().getName());
  }

  @Test
  public void createHmacKey() {
    ServiceAccount serviceAccount = ServiceAccount.of("x@y.z");
    HmacKey hmacKey = storageFixture.getInstance().createHmacKey(serviceAccount);
    assertThat(hmacKey).isNotNull();
    assertThat(hmacKey.getSecretKey()).isNotNull();
    assertThat(hmacKey.getMetadata().getServiceAccount()).isEqualTo(serviceAccount);
  }

  @Test
  public void getHmacKey() {
    ServiceAccount serviceAccount = ServiceAccount.of("x@y.z");
    HmacKey hmacKey = storageFixture.getInstance().createHmacKey(serviceAccount);
    HmacKeyMetadata actual =
        storageFixture.getInstance().getHmacKey(hmacKey.getMetadata().getAccessId());
    assertThat(actual).isEqualTo(hmacKey.getMetadata());
  }

  @Test
  public void listHmacKeys() {
    ImmutableList<HmacKey> keys =
        IntStream.rangeClosed(1, 4)
            .mapToObj(i -> ServiceAccount.of(String.format("x-%d@y.z", i)))
            .map(
                sa ->
                    storageFixture
                        .getInstance()
                        .createHmacKey(sa, CreateHmacKeyOption.projectId("proj")))
            .collect(ImmutableList.toImmutableList());

    ImmutableList<HmacKeyMetadata> expected =
        keys.stream().map(HmacKey::getMetadata).collect(ImmutableList.toImmutableList());

    Page<HmacKeyMetadata> page =
        storageFixture.getInstance().listHmacKeys(ListHmacKeysOption.projectId("proj"));

    ImmutableList<HmacKeyMetadata> actual =
        StreamSupport.stream(page.iterateAll().spliterator(), false)
            .collect(ImmutableList.toImmutableList());

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void updateHmacKey() {
    ServiceAccount serviceAccount = ServiceAccount.of("x@y.z");
    HmacKey hmacKey = storageFixture.getInstance().createHmacKey(serviceAccount);
    HmacKeyMetadata updated =
        storageFixture
            .getInstance()
            .updateHmacKeyState(hmacKey.getMetadata(), HmacKeyState.INACTIVE);
    assertThat(updated.getServiceAccount()).isEqualTo(serviceAccount);
    assertThat(updated.getState()).isEqualTo(HmacKeyState.INACTIVE);
  }

  @Test
  public void deleteHmacKey() {
    ServiceAccount serviceAccount = ServiceAccount.of("x@y.z");
    HmacKey hmacKey = storageFixture.getInstance().createHmacKey(serviceAccount);
    storageFixture.getInstance().updateHmacKeyState(hmacKey.getMetadata(), HmacKeyState.INACTIVE);
    storageFixture.getInstance().deleteHmacKey(hmacKey.getMetadata());
  }
}