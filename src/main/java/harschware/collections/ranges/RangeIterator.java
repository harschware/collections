package harschware.collections.ranges;

import harschware.collections.sequences.Sequence;

import java.util.Iterator;

/**
 * 
 * @author gleichmann
 * @author harschware
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class RangeIterator<T extends Comparable> implements Iterator<T>{

	private Sequence<T> sequence = null;
	private T end = null;

	public RangeIterator( Sequence<T> sequence, T end ){
		this.sequence = sequence;
		this.end = end;
	}

	public boolean hasNext() {
		return sequence.value().compareTo( end ) <= 0;
	}

	public T next() {
		 T value = sequence.value();
		sequence = sequence.next();
		return value;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	} // end method
} // end class