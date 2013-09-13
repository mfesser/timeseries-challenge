package de.cinovo.timeseries.impl.ringskip;

import com.google.common.base.Preconditions;

import de.cinovo.timeseries.IFixedTimeWindow;
import de.cinovo.timeseries.ITimeSeries;
import de.cinovo.timeseries.impl.TimeSeriesPair;

/**
 * 
 * Test implementation of a fixed time window.
 * 
 * @author mfesser
 * 
 */
public final class FixedTimeWindow implements IFixedTimeWindow {
	
	private long lastTime = Long.MIN_VALUE;
	
	private final ITimeBasedQueue values;
	
	private final TimeSeriesImplementation seriesImplementation;
	
	
	/**
	 * @param window Window size (e. g. if you use milliseconds as time than window size is in milliseconds)
	 * @param expectedMaxSize Expected maximum number of values
	 */
	public FixedTimeWindow(final long window, final int expectedMaxSize) {
		Preconditions.checkArgument(window > 0, "window must be > 0");
		Preconditions.checkArgument(expectedMaxSize > 0, "expectedMaxSize must be > 0");
		
		this.values = new TimeBasedQueue(window, expectedMaxSize);
		this.seriesImplementation = new TimeSeriesImplementation(this.values);
	}
	
	/**
	 * @param window Window size (e. g. if you use milliseconds as time than window size is in milliseconds)
	 */
	public FixedTimeWindow(final long window) {
		this(window, 100000);
	}
	
	@Override
	public ITimeSeries get(final long now) {
		this.checkTime(now);
		if (this.values.cleanUp(now) == true) {
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
		return this.values.window();
	}
	
	private void checkTime(final long now) {
		if (now < this.lastTime) {
			throw new IllegalArgumentException("now is in the past");
		}
		this.lastTime = now;
	}
	
}
