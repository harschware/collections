package harschware.collections.sequences.tests;

import static harschware.collections.ConvenienceMethods.*;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Test;

import com.google.common.collect.Lists;

public class TestSequence {
	private final static Logger logger = Logger.getLogger(TestSequence.class);


	@Test
	public void testEmptyRange() {
		List<Integer> expected = Lists.newArrayList();
		List<Integer> actual = Lists.newArrayList();
		for( int number : Range( 1, -1 ) ){
			actual.add(number);
			logger.debug( number );
		} // end for
		Assert.assertEquals(expected, actual);
	} // end test

	@Test
	public void testIntegerRange() {
		List<Integer> expected = Lists.newArrayList(11,12,13,14,15,16,17);
		List<Integer> actual = Lists.newArrayList();
		for( int number : Range( 11, 17 ) ){
			actual.add(number);
			logger.debug( number );
		} // end for
		Assert.assertEquals(expected, actual);
	} // end test

	@Test
	public void testDateRange() {
		DateTime daylightSavings = new DateTime(2005, 3, 26, 12, 0, 0, 0);
		List<DateTime> expected = Lists.newArrayList( daylightSavings.minusDays(1),
				daylightSavings,
				daylightSavings.plusDays(1)
				);
		List<DateTime> actual = Lists.newArrayList();
		for( DateTime dt : Range( daylightSavings.minusDays(1), daylightSavings.plusDays(1)) ){
			actual.add(dt);
			logger.debug( dt );
		} // end for
		Assert.assertEquals(expected, actual);
	} // end test

	@Test
	public void testCharacterRange() {
		List<Character> expected = Lists.newArrayList( 'e', 'f', 'g' );
		List<Character> actual = Lists.newArrayList();
		for( Character ch : Range( 'e', 'g' ) ) {
			actual.add(ch);
			logger.debug( ch );
		} // end for
		Assert.assertEquals(expected, actual);
	} // end test

	@Test
	public void testLongRange() {
		Long start = new Long(Integer.MAX_VALUE);
		List<Long> expected = Lists.newArrayList( start, start + 1L, start + 2L );
		List<Long> actual = Lists.newArrayList();
		for( Long longNum : Range( start, start + 2L ) ) {
			actual.add(longNum);
			logger.debug( longNum );
		} // end for
		Assert.assertEquals(expected, actual);
	} // end test

	@Test(expected=UnsupportedOperationException.class)
	public void testDoubleRange() {
		Double start = new Double(1.0);
		Range( start, start + 1.0).iterator();
	} // end test
} // end test class
