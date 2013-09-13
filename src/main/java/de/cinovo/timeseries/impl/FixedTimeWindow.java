package de.cinovo.timeseries.impl;

import com.google.common.base.Preconditions;

import de.cinovo.timeseries.IFixedTimeWindow;
import de.cinovo.timeseries.ITimeSeries;

/**
 * 
 * Test implementation of a fixed time window.
 * 
 * @author mfesser
 * 
 */
public final class FixedTimeWindow implements IFixedTimeWindow {
	
	private final long window;
	
	private long lastTime = Long.MIN_VALUE;
	
	private final TimeBasedQueue values;
	
	private final TimeSeriesImplementation seriesImplementation;
	
	
	/**
	 * @param window Window size (e. g. if you use milliseconds as time than window size is in milliseconds)
	 * @param expectedMaxSize Expected maximum number of values
	 */
	public FixedTimeWindow(final long window, final int expectedMaxSize) {
		Preconditions.checkArgument(window > 0, "window must be > 0");
		Preconditions.checkArgument(expectedMaxSize > 0, "expectedMaxSize must be > 0");
		this.window = window;
		this.values = new TimeBasedQueue(expectedMaxSize);
		this.seriesImplementation = new TimeSeriesImplementation(this.values);
	}
	
	/**
	 * @param window Window size (e. g. if you use milliseconds as time than window size is in milliseconds)
	 */
	public FixedTimeWindow(final long window) {
		this(window, 10000);
	}
	
	@Override
	public ITimeSeries get(final long now) {
		this.checkTime(now);
		if (this.cleanUp(now) == true) {
			this.seriesImplementation.clearCache();
		}
		return this.seriesImplementation;
	}
	
	@Override
	public void add(final long time, final float value) {
		this.checkTime(time);
		this.values.add(new TimeSeriesPair(time, value));
		this.seriesImplementation.clearCache();
	}
	
	@Override
	public long windowLength() {
		return this.window;
	}
	
	private void checkTime(final long now) {
		if (now < this.lastTime) {
			throw new IllegalArgumentException("now is in the past");
		}
		this.lastTime = now;
	}
	
	/**
	 * @param now Time
	 * @return true if something was cleaned up
	 */
	private boolean cleanUp(final long now) {
		boolean cleanedUp = false;
		while (true) {
			final TimeSeriesPair pair = this.values.pollFirst();
			if (pair == null) {
				break;
			}
			if (pair.time() >= (now - this.window)) { // check if the value is not too old
				this.values.addFirst(pair); // reinsert the value at the beginning
				break;
			}
			cleanedUp = true;
		}
		return cleanedUp;
	}
	
}
