package harschware.collections;

import harschware.collections.ranges.Range;

/**
 * 
 * @author gleichmann
 * @author harschware
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 * 
 */
public class ConvenienceMethods {
	@SuppressWarnings("unchecked")
	public static <S extends Comparable> Range<S> Range( S from, S to ){
		return Range.create( from, to );
	} // end method
} // end class
