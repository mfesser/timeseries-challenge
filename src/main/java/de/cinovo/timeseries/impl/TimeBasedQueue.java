package de.cinovo.timeseries.impl;

import java.util.ArrayDeque;
import java.util.Iterator;

import de.cinovo.timeseries.ITimeSeriesPair;

/**
 * @author mfesser
 * 
 */
public class TimeBasedQueue implements Iterable<TimeSeriesPair> {
	
	private ArrayDeque<TimeSeriesPair> values = null;
	
	
	/**
	 * @param expectedSize expeced size(initial)
	 */
	public TimeBasedQueue(int expectedSize) {
		this.values = new ArrayDeque<>(expectedSize);
	}
	
	@Override
	public Iterator<TimeSeriesPair> iterator() {
		return this.values.iterator();
	}
	
	/**
	 * @param timeSeriesPair to be added
	 */
	public void add(TimeSeriesPair timeSeriesPair) {
		this.values.add(timeSeriesPair);
	}
	
	/**
	 * @return current size
	 */
	public int size() {
		return this.values.size();
	}
	
	/**
	 * @return peek first
	 */
	public ITimeSeriesPair peekFirst() {
		return this.values.peekFirst();
	}
	
	/**
	 * @return poll first(removed)
	 */
	public TimeSeriesPair pollFirst() {
		return this.values.pollFirst();
	}
	
	/**
	 * @param pair to be added as first
	 */
	public void addFirst(TimeSeriesPair pair) {
		this.values.addFirst(pair);
	}
	
	/**
	 * @return peek last
	 */
	public ITimeSeriesPair peekLast() {
		return this.values.peekLast();
	}
	
}
