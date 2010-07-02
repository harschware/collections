package harschware.collections.containers.tests;

import static junit.framework.Assert.assertEquals;

import harschware.collections.containers.Triplet;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestTriplet {
	private final static Logger logger = Logger.getLogger(TestTriplet.class);

	@Test
	public void testCreate() {
		Triplet<String,String,String> t1 = Triplet.create("k1", "k2", "k3");
		logger.debug(t1.toString());

		Triplet<String,String,String> t2 = Triplet.create("k1", null, "k3");
		logger.debug(t2.toString());
	} // end test

	@Test
	public void testEq() {
		Triplet<String,String,String> t1 = Triplet.create("k1", "k2", "k3");
		Triplet<String,String,String> t2 = Triplet.create("k1", "k2", "k3");
		assertEquals(t1, t2);

		Triplet<String,String,String> t3 = Triplet.create(null, null, null);
		Triplet<String,String,String> t4 = Triplet.create(null, null, null);
		assertEquals(t3, t4);

		Assert.assertTrue(! t1.equals(t3));
	} // end test
	
	@SuppressWarnings("unchecked")
	@Test
	public void testNullEqCombos() {
		Triplet<Integer,Integer,Integer> t1 = Triplet.create(null, null, null);
		Triplet<Integer,Integer,Integer> t2 = Triplet.create(null, null, 0);
		Triplet<Integer,Integer,Integer> t3 = Triplet.create(null, 0, null);
		Triplet<Integer,Integer,Integer> t4 = Triplet.create(null, 0, 0);
		Triplet<Integer,Integer,Integer> t5 = Triplet.create(0, null, null);
		Triplet<Integer,Integer,Integer> t6 = Triplet.create(0, null, 0);
		Triplet<Integer,Integer,Integer> t7 = Triplet.create(0, 0, null);
		Triplet<Integer,Integer,Integer> t8 = Triplet.create(0, 0, 0);

		List<Triplet<Integer,Integer,Integer>> outerInts = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8);
		List<Triplet<Integer,Integer,Integer>> innerInts = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8);
		
		for( int outer =0; outer < outerInts.size(); outer++ ) {
			for( int inner =0; inner < innerInts.size(); inner++ ) {
				if( outer == inner ) {
					Assert.assertTrue(outerInts.get(outer).equals(innerInts.get(inner)));
				} else {
					Assert.assertTrue(! outerInts.get(outer).equals(innerInts.get(inner)));
				} // end if
			} // end for
		} // end for
		
	} // end test
} // end test class
