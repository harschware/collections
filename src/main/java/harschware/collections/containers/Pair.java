/**
 * Copyright (C) 2010 Tim Harsch harschware@yahoo.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package harschware.collections.containers;

import org.apache.commons.lang.builder.CompareToBuilder;

/**
 * Adapted from http://forums.sun.com/thread.jspa?threadID=5132045
 * 
 * 
 * @author harschware
 * 
 * @param <L>
 * @param <R>
 */
public class Pair<L, R> implements Comparable<Object> {

	private final L left;
	private final R right;

	public R getRight() {
		return right;
	} // end getter

	public L getLeft() {
		return left;
	} // end getter

	public Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	} // end constructor

	public static <A, B> Pair<A, B> create(A left, B right) {
		return new Pair<A, B>(left, right);
	} // end factory method

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof Pair<?, ?>))
			return false;

		final Pair<?, ?> other = (Pair<?, ?>) o;
		return equal(getLeft(), other.getLeft())
				&& equal(getRight(), other.getRight());
	} // end method

	public static final boolean equal(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null;
		}
		return o1.equals(o2);
	} // end method

	@Override
	public int hashCode() {
		int hLeft = getLeft() == null ? 0 : getLeft().hashCode();
		int hRight = getRight() == null ? 0 : getRight().hashCode();

		return hLeft + (37 * hRight);
	} // end method

	public int compareTo(Object o) {
		Pair<?, ?> other = (Pair<?, ?>) o;
		return new CompareToBuilder().append(this.left, other.left).append(
				this.right, other.right).toComparison();
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
		if (right == null) {
			sb.append("null");
		} else {
			sb.append(right.toString());
		} // end if
		sb.append('>');
		return sb.toString();
	} // end method
} // end class
