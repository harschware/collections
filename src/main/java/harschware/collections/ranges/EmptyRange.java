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


import java.util.Collection;
import java.util.Iterator;


@SuppressWarnings("unchecked")
public class EmptyRange extends Range<Comparable> {
	final static EmptyRange INSTANCE = new EmptyRange();
	
	private EmptyRange() {}; // private constructor

	@Override
	public boolean isEmpty() {
		return true;
	} // end method

	@Override
	public boolean after(Comparable value) {
		return false;
	} // end method

	@Override
	public boolean before(Comparable value) {
		return false;
	} // end method

	@Override
	public int compareTo(Range<Comparable> other) {
		throw new UnsupportedOperationException();
	} // end method

	@Override
	public boolean contains(Comparable value) {
		return false;
	} // end method

	@Override
	public boolean contains(Range<Comparable> other) {
		return false;
	} // end contains range
	
	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public Range<Comparable> gap(Range<Comparable> arg) {
		return INSTANCE;
	} // end method

	@Override
	public int hashCode() {
		return 0;
	} // end method

	@Override
	public Iterator<Comparable> iterator() {
		return new EmptyIterator<Comparable>();
	} // end method

	@Override
	public boolean overlaps(Range<Comparable> arg) {
		return false;
	} // end method

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Empty]";
	} // end method

	@Override
	public boolean abuts(Range<Comparable> arg) {
		return false;
	} // end method

	@Override
	public boolean partitionedBy(Collection<Range<Comparable>> ranges) {
		return false;
	} // end method

} // end class
