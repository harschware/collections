package harschware.collections.ranges;

import java.util.Iterator;

/**
 * 
 * An iterator that provides no next element and guarantees to not support next
 * or remove method.
 * 
 * @author tharsch
 * 
 * @param <T>
 */
public class EmptyIterator<T> implements Iterator<T> {

	public boolean hasNext() {
		return false;
	} // end method

	public T next() {
		throw new UnsupportedOperationException();
	} // end method

	public void remove() {
		throw new UnsupportedOperationException();
	} // end method

} // end class
