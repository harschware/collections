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