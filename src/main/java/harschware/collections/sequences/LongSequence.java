package harschware.collections.sequences;


/**
 * 
 * @author harschware
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 * 
 * @param <T>
 */
public class LongSequence implements Sequence<Long> {

	Long value = null;

	public LongSequence(Long value) {
		this.value = value;
	}

	public Long value() {
		return value;
	}

	public Sequence<Long> next() {
		return new LongSequence(value + 1L);
	}

	public Sequence<Long> previous() {
		return new LongSequence(value - 1L);
	}
} // end class
