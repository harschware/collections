package harschware.collections.sequences;


import org.joda.time.DateTime;

/**
 * 
 * Sequence strategy implementation for jodatime dates.
 * 
 * @author harschware
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 * 
 * @param <T>
 */
public class DateTimeSequence implements Sequence<DateTime> {

	DateTime value = null;

	public DateTimeSequence(DateTime value) {
		this.value = value;
	} // end method

	public DateTime value() {
		return value;
	} // end method

	public Sequence<DateTime> next() {
		return new DateTimeSequence(value.plusDays(1));
	} // end method

	public Sequence<DateTime> previous() {
		return new DateTimeSequence(value.minusDays(1));
	} // end method
} // end class