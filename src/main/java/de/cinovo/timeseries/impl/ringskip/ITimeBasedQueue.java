package de.cinovo.timeseries.impl.ringskip;

import java.util.Iterator;

import de.cinovo.timeseries.ITimeSeriesPair;
import de.cinovo.timeseries.impl.TimeSeriesPair;

/**
 * @author mfesser
 * 
 */
public interface ITimeBasedQueue extends Iterable<TimeSeriesPair> {
	
	@Override
	public abstract Iterator<TimeSeriesPair> iterator();
	
	/**
	 * @param timeSeriesPair to be added
	 */
	public abstract void add(TimeSeriesPair timeSeriesPair);
	
	/**
	 * @return current size
	 */
	public abstract int size();
	
	/**
	 * @return peek first
	 */
	public abstract ITimeSeriesPair peekFirst();
	
	/**
	 * @return peek last
	 */
	public abstract ITimeSeriesPair peekLast();
	
	/**
	 * @param now Time
	 * @return true if something was cleaned up
	 */
	public abstract boolean cleanUp(long now);
	
	/**
	 * @return the window
	 */
	public abstract long window();
	
}