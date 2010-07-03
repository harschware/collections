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

import java.util.Iterator;

/**
 * 
 * An iterator that provides no next element and guarantees to not support next
 * or remove method.
 * 
 * @author harschware
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
