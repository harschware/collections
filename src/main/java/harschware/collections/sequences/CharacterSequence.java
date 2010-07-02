package harschware.collections.sequences;


/**
 * 
 * @author gleichmann
 * @author harschware
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 * 
 * @param <T>
 */
public class CharacterSequence implements Sequence<Character> {

	Character value = null;

	public CharacterSequence(Character value) {
		this.value = value;
	}

	public Character value() {
		return value;
	}

	public Sequence<Character> next() {
		return new CharacterSequence((char) (((int) value) + 1));
	}

	public Sequence<Character> previous() {
		return new CharacterSequence((char) (((int) value) - 1));
	} // end method
} // end class