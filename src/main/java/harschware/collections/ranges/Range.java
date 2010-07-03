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

package harschware.collections.ranges;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * 
 * @author harschware
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 * @see http://martinfowler.com/eaaDev/Range.html
 * @see http://commons.apache.org/lang/api-2.3/org/apache/commons/lang/math/Range.html
 * 
 * 
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class Range<T extends Comparable> implements
		Comparable<Range<T>>, Iterable<T> {
	protected final static Logger logger = Logger.getLogger(Range.class);

	protected final T start;
	protected final T end;

	protected Range() {
		start = null;
		end = null;
	} // end constructor

	protected Range(final T start, final T end) {
		this.start = start;
		this.end = end;
	} // end constructor

	public static <S extends Comparable> Range<S> create(S start, S end) {
		if (start.compareTo(end) > 0)
			return (Range<S>) EmptyRange.INSTANCE;
		Range<S> newRange = ValidRange.newInstance(start, end);
		return newRange;
	} // end method

	public abstract boolean before(T value);

	public abstract boolean after(T value);

	public abstract boolean contains(T value);

	public abstract boolean overlaps(Range<T> arg);

	/**
	 * @return the start
	 */
	public T getStart() {
		return start;
	} // end getter

	/**
	 * @return the end
	 */
	public T getEnd() {
		return end;
	} // end getter

	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract int hashCode();

	public abstract int compareTo(Range<T> other);

	public abstract boolean isEmpty();

	public abstract Iterator<T> iterator();

	public abstract Range<T> gap(Range<T> arg);

	public abstract boolean contains(Range<T> other);

	public abstract boolean abuts(Range<T> arg);

	public abstract boolean partitionedBy(Collection<Range<T>> ranges);

	public static <S extends Comparable> boolean isContiguous(
			Collection<Range<S>> ranges) {
		// need a copy so as not to disturb the order of the input collection
		logger.debug("isContiguous making list copy of input collection");
		List<Range<S>> listCopy = new ArrayList<Range<S>>(ranges);
		return isContiguousIfSorted(listCopy);
	} // end method

	/**
	 * Has side effect of sorting the input list.
	 * 
	 * @param <S>
	 * @param ranges
	 * @return
	 */
	protected static <S extends Comparable> boolean isContiguousIfSorted(
			List<Range<S>> ranges) {
		logger.debug("isContiguousIfSorted sorting list");
		Collections.sort(ranges);
		for (int i = 0; i < ranges.size() - 1; i++) {
			if (!ranges.get(i).abuts(ranges.get(i + 1)))
				return false;
		} // end for
		return true;
	} // end method

	/**
	 * analogous to Fowler's combination
	 * 
	 * @param <S>
	 * @param ranges
	 * @return
	 */
	public static <S extends Comparable> Range<S> collapse(
			Collection<Range<S>> ranges) {
		// need a copy so as not to disturb the order of the input collection
		logger.debug("collapse making list copy of input collection");
		List<Range<S>> listCopy = new ArrayList<Range<S>>(ranges);
		return sortAndCollapse(listCopy);
	} // end method

	/**
	 * Has side effect of sorting the input list.
	 * 
	 * @param <S>
	 * @param ranges
	 * @return
	 */
	protected static <S extends Comparable> Range<S> sortAndCollapse(
			List<Range<S>> ranges) {
		logger.debug("sortAndCollapse called");
		if (!isContiguousIfSorted(ranges))
			return (Range<S>) EmptyRange.INSTANCE;
		else
			return Range.create(ranges.get(0).getStart(), ranges.get(
					ranges.size() - 1).getEnd());
	} // end method

} // end class