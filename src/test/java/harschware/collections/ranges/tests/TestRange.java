/**
 * Copyright (C) 2010 Tim Harsch harschware@yahoo.com
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

package harschware.collections.ranges.tests;


import harschware.collections.ranges.Range;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class TestRange {
	private final static Logger logger = Logger.getLogger(TestRange.class);

	@Test
	public void testCreate() {
		Range<Integer> r1 = Range.create(0,5);
		logger.debug(r1.toString());
	} // end test

	@Test
	public void testEmpty() {
		Range<Integer> r1 = Range.create(1,-5);
		Range<Integer> r2 = Range.create(1,-7);
		Assert.assertFalse(r1.equals(r2));
	} // end test

	@Test
	public void testOverlap() {
		Range<Integer> r1 = Range.create(0,5);
		Range<Integer> r2 = Range.create(3,5);
		Range<Integer> r3 = Range.create(6,9);
		Assert.assertTrue(r1.overlaps(r2));
		Assert.assertTrue(r2.overlaps(r1));
		Assert.assertFalse(r2.overlaps(r3));
		Assert.assertFalse(r3.overlaps(r2));

		Range<Integer> empty = Range.create(0,-1);
		Assert.assertFalse(empty.overlaps(r1));
		Assert.assertFalse(r1.overlaps(empty));

	} // end test

	@Test
	public void testContainsRange() {
		Range<Integer> r1 = Range.create(0,5);
		Range<Integer> r2 = Range.create(1,4);
		Range<Integer> r3 = Range.create(4,6);
		Assert.assertTrue(r1.contains(r1));
		Assert.assertTrue(r1.contains(r2));
		Assert.assertFalse(r1.contains(r3));

		Range<Integer> empty = Range.create(0,-1);
		Assert.assertFalse(r1.contains(empty));
		Assert.assertFalse(empty.contains(r1));
	} // end test


	@Test
	public void testEquals() {
		Range<Integer> r1 = Range.create(0,5);
		Range<Integer> r2 = Range.create(0,5);
		Range<Integer> r3 = Range.create(6,9);
		Assert.assertTrue(r1.equals(r1));
		Assert.assertTrue(r1.equals(r2));
		Assert.assertFalse(r1.equals(r3));
	} // end test

	@Test
	public void testContains() {
		Range<Integer> r1 = Range.create(0,5);
		Assert.assertTrue(r1.contains(1));
		Assert.assertTrue(r1.contains(0));
		Assert.assertTrue(r1.contains(5));
		Assert.assertFalse(r1.contains(9));
	} // end test

	@Test
	public void testBefore() {
		Range<Integer> r1 = Range.create(1,5);
		Assert.assertTrue(r1.before(6));
		Assert.assertFalse(r1.before(5));
		Assert.assertFalse(r1.before(4));
	} // end test

	@Test
	public void testAfter() {
		Range<Integer> r1 = Range.create(1,5);
		Assert.assertTrue(r1.after(-1));
		Assert.assertTrue(r1.after(0));
		Assert.assertFalse(r1.after(1));
		Assert.assertFalse(r1.after(6));
	} // end test

	@SuppressWarnings("unchecked")
	@Test
	public void testSort() {
		Set<Range<Integer>> s = Sets.newTreeSet();
		Range<Integer> r1 = Range.create(0,5);
		Range<Integer> r2 = Range.create(0,5);
		Range<Integer> r3 = Range.create(6,9);
		Range<Integer> r4 = Range.create(0,4);
		Range<Integer> r5 = Range.create(1,5);
		s.add(r1);
		s.add(r3);
		s.add(r2);
		s.add(r4);
		s.add(r5);
		ImmutableList.of();
		List<Range<Integer>> expected = Lists.newArrayList(r4,r2,r5,r3);
		List<Range<Integer>> actual = Lists.newArrayList(s);
		Assert.assertEquals(expected, actual);
	} // end test

	@Test
	public void testGap() {
		Range<Integer> r1 = Range.create(0,10);
		Range<Integer> expected = Range.create(11,19);
		Range<Integer> r2 = Range.create(20,30);
		Range<Integer> actual = r1.gap(r2);
		Assert.assertEquals(expected, actual);
		actual = r2.gap(r1);
		Assert.assertEquals(expected, actual);
		
		Range<Integer> r3 = Range.create(11,15);
		// there is no gap between 0,10 and 11,15
		actual = r3.gap(r1);
		logger.debug(actual);
	} // end test

	@Test
	public void testAbuts() {
		Range<Integer> r1 = Range.create(0,10);
		Range<Integer> r2 = Range.create(11,19);
		Range<Integer> r3 = Range.create(15,17);
		Assert.assertTrue(r1.abuts(r2));
		Assert.assertTrue(r2.abuts(r1));
		Assert.assertFalse(r1.abuts(r3));
		Assert.assertFalse(r3.abuts(r1));

		Assert.assertFalse(true);
	} // end test

	@SuppressWarnings("unchecked")
	@Test
	public void testIsContiguous() {
		Range<Integer> p1 = Range.create(0,3);
		Range<Integer> p2 = Range.create(4,7);
		Range<Integer> p3 = Range.create(8,10);
		Range<Integer> np2 = Range.create(5,7);
		
		List<Range<Integer>> validContig = Lists.newArrayList( p1, p3, p2 );
		List<Range<Integer>> invalidContig = Lists.newArrayList( p1, p3, np2 );
		
		Assert.assertTrue(Range.isContiguous(validContig));
		Assert.assertFalse(Range.isContiguous(invalidContig));
	} // end test

	
	@SuppressWarnings("unchecked")
	@Test
	public void testCollapse() {
		Range<Integer> r1 = Range.create(0,10);
		Range<Integer> p1 = Range.create(0,3);
		Range<Integer> p2 = Range.create(4,7);
		Range<Integer> p3 = Range.create(8,10);
		Range<Integer> np2 = Range.create(5,7);
		
		Set<Range<Integer>> validCombo = Sets.newHashSet( p1, p3, p2 );
		Set<Range<Integer>> invalidCombo = Sets.newHashSet( p1, p3, np2 );
		
		Assert.assertTrue(Range.collapse(validCombo).equals(r1));
		Assert.assertTrue(Range.collapse(invalidCombo).isEmpty());
	} // end test
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPartitionedBy() {
		Range<Integer> r1 = Range.create(0,10);
		Range<Integer> p1 = Range.create(0,3);
		Range<Integer> p2 = Range.create(4,7);
		Range<Integer> p3 = Range.create(8,10);
		Range<Integer> np2 = Range.create(5,7);
		
		List<Range<Integer>> validPartition = Lists.newArrayList( p1, p3, p2 );
		List<Range<Integer>> invalidPartition = Lists.newArrayList( p1, p3, np2 );
		
		Assert.assertTrue(r1.partitionedBy(validPartition));
		Assert.assertFalse(r1.partitionedBy(invalidPartition));
	} // end test

} // end test class
