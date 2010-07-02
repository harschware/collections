package harschware.collections.containers;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Tim Harsch
 * 
 * @param <L>
 * @param <M>
 * @param <R>
 */
public class Triplet<L, M, R> implements Comparable<Object> {
	private final L left;
	private final M mid;
	private final R right;

	public R getRight() {
		return right;
	} // end getter

	public M getMid() {
		return mid;
	} // end getter

	public L getLeft() {
		return left;
	} // end getter

	public Triplet(final L left, final M mid, final R right) {
		this.left = left;
		this.mid = mid;
		this.right = right;
	} // end constructor

	public static <A, B, C> Triplet<A, B, C> create(A left, B mid, C right) {
		return new Triplet<A, B, C>(left, mid, right);
	} // end factory method

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof Triplet<?, ?, ?>))
			return false;

		final Triplet<?, ?, ?> other = (Triplet<?, ?, ?>) o;
		return equal(getLeft(), other.getLeft())
				&& equal(getMid(), other.getMid())
				&& equal(getRight(), other.getRight());
	} // end method

	private static final boolean equal(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null;
		}
		return o1.equals(o2);
	} // end method

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 13).append(this.left).append(this.mid)
				.append(this.right).toHashCode();
	} // end method

	public int compareTo(Object o) {
		Triplet<?, ?, ?> other = (Triplet<?, ?, ?>) o;
		return new CompareToBuilder().append(this.left, other.left).append(
				this.mid, other.mid).append(this.right, other.right)
				.toComparison();
	} // end method

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		if (left == null) {
			sb.append("null");
		} else {
			sb.append(left.toString());
		} // end if
		sb.append(',');
		if (mid == null) {
			sb.append("null");
		} else {
			sb.append(mid.toString());
		} // end if
		sb.append(',');
		if (right == null) {
			sb.append("null");
		} else {
			sb.append(right.toString());
		} // end if
		sb.append('>');
		return sb.toString();
	} // end method
} // end class
