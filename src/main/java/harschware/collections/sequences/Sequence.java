package harschware.collections.sequences;

/**
 * 
 * @author gleichmann
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 * 
 * @param <T>
 */
public interface Sequence<T> {

	public T value();

	public Sequence<T> next();

	public Sequence<T> previous();
} // end interface