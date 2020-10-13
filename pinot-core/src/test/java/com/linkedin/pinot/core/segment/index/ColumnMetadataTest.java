/**
 * Copyright (C) 2014-2016 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.core.segment.index;

import com.linkedin.pinot.common.data.FieldSpec;
import com.linkedin.pinot.common.data.MetricFieldSpec;
import com.linkedin.pinot.common.segment.ReadMode;
import com.linkedin.pinot.common.segment.StarTreeMetadata;
import com.linkedin.pinot.core.indexsegment.IndexSegment;
import com.linkedin.pinot.core.indexsegment.generator.SegmentGeneratorConfig;
import com.linkedin.pinot.core.segment.creator.SegmentIndexCreationDriver;
import com.linkedin.pinot.core.segment.creator.impl.SegmentCreationDriverFactory;
import com.linkedin.pinot.core.segment.index.loader.Loaders;
import com.linkedin.pinot.core.startree.hll.SegmentWithHllIndexCreateHelper;
import com.linkedin.pinot.segments.v1.creator.SegmentTestUtils;
import com.linkedin.pinot.startree.hll.HllConfig;
import com.linkedin.pinot.util.TestUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ColumnMetadataTest {
  private static final String AVRO_DATA = "data/test_data-mv.avro";
  private static final File INDEX_DIR = new File(ColumnMetadataTest.class.toString());
  private static final String CREATOR_VERSION = "TestHadoopJar.1.1.1";

  @BeforeMethod
  public void setUp() throws Exception {
    FileUtils.deleteQuietly(INDEX_DIR);
  }

  @AfterMethod
  public void tearDown() {
    FileUtils.deleteQuietly(INDEX_DIR);
  }

  public SegmentGeneratorConfig CreateSegmentConfigWithoutCreator()
      throws Exception {
    final String filePath =
        TestUtils.getFileFromResourceUrl(ColumnMetadataTest.class.getClassLoader().getResource(AVRO_DATA));
    // Intentionally changed this to TimeUnit.Hours to make it non-default for testing.
    SegmentGeneratorConfig config =
        SegmentTestUtils.getSegmentGenSpecWithSchemAndProjectedColumns(new File(filePath), INDEX_DIR, "daysSinceEpoch",
            TimeUnit.HOURS, "testTable");
    config.setSegmentNamePostfix("1");
    config.setTimeColumnName("daysSinceEpoch");
    return config;
  }

  public SegmentGeneratorConfig createSegmentConfigWithCreator() throws Exception {
    SegmentGeneratorConfig config = CreateSegmentConfigWithoutCreator();
    config.setCreatorVersion(CREATOR_VERSION);
    return config;
  }

  public void verifySegmentAfterLoading(SegmentMetadataImpl metadata) {
    // Multi-value numeric dimension column.
    ColumnMetadata col7Meta = metadata.getColumnMetadataFor("column7");
    Assert.assertEquals(col7Meta.getColumnName(), "column7");
    Assert.assertEquals(col7Meta.getCardinality(), 359);
    Assert.assertEquals(col7Meta.getTotalDocs(), 100000);
    Assert.assertEquals(col7Meta.getTotalRawDocs(), 100000);
    Assert.assertEquals(col7Meta.getTotalAggDocs(), 0);
    Assert.assertEquals(col7Meta.getDataType(), FieldSpec.DataType.INT);
    Assert.assertEquals(col7Meta.getBitsPerElement(), 9);
    Assert.assertEquals(col7Meta.getStringColumnMaxLength(), 0);
    Assert.assertEquals(col7Meta.getFieldType(), FieldSpec.FieldType.DIMENSION);
    Assert.assertFalse(col7Meta.isSorted());
    Assert.assertFalse(col7Meta.hasNulls());
    Assert.assertTrue(col7Meta.hasDictionary());
    Assert.assertTrue(col7Meta.hasInvertedIndex());
    Assert.assertFalse(col7Meta.isSingleValue());
    Assert.assertEquals(col7Meta.getMaxNumberOfMultiValues(), 24);
    Assert.assertEquals(col7Meta.getTotalNumberOfEntries(), 134090);
    Assert.assertFalse(col7Meta.isAutoGenerated());
    Assert.assertEquals(col7Meta.getDefaultNullValueString(), String.valueOf(Integer.MIN_VALUE));

    // Single-value string dimension column.
    ColumnMetadata col3Meta = metadata.getColumnMetadataFor("column3");
    Assert.assertEquals(col3Meta.getColumnName(), "column3");
    Assert.assertEquals(col3Meta.getCardinality(), 5);
    Assert.assertEquals(col3Meta.getTotalDocs(), 100000);
    Assert.assertEquals(col3Meta.getTotalRawDocs(), 100000);
    Assert.assertEquals(col3Meta.getTotalAggDocs(), 0);
    Assert.assertEquals(col3Meta.getDataType(), FieldSpec.DataType.STRING);
    Assert.assertEquals(col3Meta.getBitsPerElement(), 3);
    Assert.assertEquals(col3Meta.getStringColumnMaxLength(), 4);
    Assert.assertEquals(col3Meta.getFieldType(), FieldSpec.FieldType.DIMENSION);
    Assert.assertFalse(col3Meta.isSorted());
    Assert.assertFalse(col3Meta.hasNulls());
    Assert.assertTrue(col3Meta.hasDictionary());
    Assert.assertTrue(col3Meta.hasInvertedIndex());
    Assert.assertTrue(col3Meta.isSingleValue());
    Assert.assertEquals(col3Meta.getMaxNumberOfMultiValues(), 0);
    Assert.assertEquals(col3Meta.getTotalNumberOfEntries(), 100000);
    Assert.assertFalse(col3Meta.isAutoGenerated());
    Assert.assertEquals(col3Meta.getDefaultNullValueString(), "null");

    // Time column.
    ColumnMetadata timeColumn = metadata.getColumnMetadataFor("daysSinceEpoch");
    Assert.assertEquals(timeColumn.getColumnName(), "daysSinceEpoch");
    Assert.assertEquals(timeColumn.getCardinality(), 1);
    Assert.assertEquals(timeColumn.getTotalDocs(), 100000);
    Assert.assertEquals(timeColumn.getTotalRawDocs(), 100000);
    Assert.assertEquals(timeColumn.getTotalAggDocs(), 0);
    Assert.assertEquals(timeColumn.getDataType(), FieldSpec.DataType.INT);
    Assert.assertEquals(timeColumn.getBitsPerElement(), 1);
    Assert.assertEquals(timeColumn.getStringColumnMaxLength(), 0);
    Assert.assertEquals(timeColumn.getFieldType(), FieldSpec.FieldType.DIMENSION);
    Assert.assertTrue(timeColumn.isSorted());
    Assert.assertFalse(timeColumn.hasNulls());
    Assert.assertTrue(timeColumn.hasDictionary());
    Assert.assertTrue(timeColumn.hasInvertedIndex());
    Assert.assertTrue(timeColumn.isSingleValue());
    Assert.assertEquals(timeColumn.getMaxNumberOfMultiValues(), 0);
    Assert.assertEquals(timeColumn.getTotalNumberOfEntries(), 100000);
    Assert.assertFalse(timeColumn.isAutoGenerated());
    Assert.assertEquals(timeColumn.getDefaultNullValueString(), String.valueOf(Integer.MIN_VALUE));
  }

  @Test
  public void testAllFieldsInitialized() throws Exception {
    // Build the Segment metadata.
    SegmentGeneratorConfig config = createSegmentConfigWithCreator();
    SegmentIndexCreationDriver driver = SegmentCreationDriverFactory.get(null);
    driver.init(config);
    driver.build();

    // Load segment metadata.
    IndexSegment segment = Loaders.IndexSegment.load(INDEX_DIR.listFiles()[0], ReadMode.mmap);
    SegmentMetadataImpl metadata = (SegmentMetadataImpl) segment.getSegmentMetadata();
    verifySegmentAfterLoading(metadata);

    // Make sure we got the creator name as well.
    String creatorName = metadata.getCreatorName();
    Assert.assertEquals(creatorName, CREATOR_VERSION);
  }

  @Test
  public void testAllFieldsExceptCreatorName() throws Exception {
    // Build the Segment metadata.
    SegmentGeneratorConfig config = CreateSegmentConfigWithoutCreator();
    SegmentIndexCreationDriver driver = SegmentCreationDriverFactory.get(null);
    driver.init(config);
    driver.build();

    // Load segment metadata.
    IndexSegment segment = Loaders.IndexSegment.load(INDEX_DIR.listFiles()[0], ReadMode.mmap);
    SegmentMetadataImpl metadata = (SegmentMetadataImpl) segment.getSegmentMetadata();
    verifySegmentAfterLoading(metadata);

    // Make sure we get null for creator name.
    String creatorName = metadata.getCreatorName();
    Assert.assertEquals(creatorName, null);
  }

  @Test
  public void testPaddingCharacter() throws Exception {
    // Build the Segment metadata.
    SegmentGeneratorConfig config = CreateSegmentConfigWithoutCreator();
    SegmentIndexCreationDriver driver = SegmentCreationDriverFactory.get(null);
    driver.init(config);
    driver.build();

    // Load segment metadata.
    IndexSegment segment = Loaders.IndexSegment.load(INDEX_DIR.listFiles()[0], ReadMode.mmap);
    SegmentMetadataImpl metadata = (SegmentMetadataImpl) segment.getSegmentMetadata();
    verifySegmentAfterLoading(metadata);

    // Make sure we get null for creator name.
    char paddingCharacter = metadata.getPaddingCharacter();
    Assert.assertEquals(paddingCharacter, '\0');
  }

  @Test
  public void testHllIndexRelatedMetadata() throws Exception {
    SegmentWithHllIndexCreateHelper helper = null;
    try {
      // Build the Segment metadata.
      helper = new SegmentWithHllIndexCreateHelper(
          "testHllIndexRelatedMetadata", getClass().getClassLoader().getResource("data/test_data-sv.avro"), "daysSinceEpoch", TimeUnit.DAYS, "starTreeSegment");
      helper.build(true, new HllConfig(9, new HashSet<String>(Arrays.asList("column7")), "_hllSuffix"));

      // Load segment metadata.
      IndexSegment segment = Loaders.IndexSegment.load(helper.getSegmentDirectory(), ReadMode.mmap);
      SegmentMetadataImpl metadata = (SegmentMetadataImpl) segment.getSegmentMetadata();
      Assert.assertEquals(metadata.getHllLog2m(), 9);

      // Verify Hll Related Info
      StarTreeMetadata starTreeMetadata = metadata.getStarTreeMetadata();
      Assert.assertNotNull(starTreeMetadata);
      ColumnMetadata column = metadata.getColumnMetadataFor("column7_hllSuffix");
      Assert.assertEquals(column.getDerivedMetricType(), MetricFieldSpec.DerivedMetricType.HLL);
      Assert.assertEquals(column.getOriginColumnName(), "column7");
    } finally {
      if (helper != null) {
        helper.cleanTempDir();
      }
    }
  }
}
