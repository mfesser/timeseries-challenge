package de.cinovo.timeseries.impl.ringskip;

import java.util.ArrayDeque;
import java.util.Iterator;

import de.cinovo.timeseries.ITimeSeriesPair;
import de.cinovo.timeseries.impl.TimeSeriesPair;

/**
 * @author mfesser
 * 
 */
public class TimeBasedQueue implements  ITimeBasedQueue {
	
	private final long window;
	private ArrayDeque<TimeSeriesPair> values = null;
	
	
	/**
	 * @param window window in the time base
	 * @param expectedSize expected size(initial)
	 */
	public TimeBasedQueue(long window, int expectedSize) {
		this.values = new ArrayDeque<>(expectedSize);
		this.window = window;
	}
	
	@Override
	public Iterator<TimeSeriesPair> iterator() {
		return this.values.iterator();
	}
	
	/**
	 * @param timeSeriesPair to be added
	 */
	@Override
	public void add(TimeSeriesPair timeSeriesPair) {
		this.values.add(timeSeriesPair);
	}
	
	/**
	 * @return current size
	 */
	@Override
	public int size() {
		return this.values.size();
	}
	
	/**
	 * @return peek first
	 */
	@Override
	public ITimeSeriesPair peekFirst() {
		return this.values.peekFirst();
	}
	
	/**
	 * @return peek last
	 */
	@Override
	public ITimeSeriesPair peekLast() {
		return this.values.peekLast();
	}
	
	/**
	 * @param now Time
	 * @return true if something was cleaned up
	 */
	@Override
	public boolean cleanUp(final long now) {
		boolean cleanedUp = false;
		while (true) {
			final TimeSeriesPair pair = this.values.peekFirst();
			if (pair == null) {
				break;
			}
			
			if (pair.time() < (now - this.window)) {
				this.values.pollFirst();
			} else {
				break;
			}
			
			cleanedUp = true;
		}
		return cleanedUp;
	}
	
	/**
	 * @return the window
	 */
	@Override
	public long window() {
		return this.window;
	}
}
