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

package harschware.collections.sequences;


/**
 * 
 * @author gleichmann
 * 
 * @see http://gleichmann.wordpress.com/2008/01/21/declarative-programming-a-range-type-for-java/
 * 
 * @param <T>
 */
public class IntegerSequence implements Sequence<Integer> {

	Integer value = null;

	public IntegerSequence(Integer value) {
		this.value = value;
	}

	public Integer value() {
		return value;
	}

	public Sequence<Integer> next() {
		return new IntegerSequence(value + 1);
	}

	public Sequence<Integer> previous() {
		return new IntegerSequence(value - 1);
	}
} // end class
