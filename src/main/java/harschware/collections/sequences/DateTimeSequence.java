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