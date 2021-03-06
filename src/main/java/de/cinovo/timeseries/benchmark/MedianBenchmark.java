package de.cinovo.timeseries.benchmark;

import de.cinovo.timeseries.ITimeSeries;

/**
 * 
 * @author mwittig
 * 
 */
public final class MedianBenchmark extends AFixedWindowBenchmark {
	
	/**
	 * @param aBenchmarkSuite Benchmark suite
	 * @param aWindowSize Window size
	 * @throws Exception If something went wrong...
	 */
	public MedianBenchmark(final ABenchmarkSuite aBenchmarkSuite, final long aWindowSize) throws Exception {
		super(aBenchmarkSuite, aWindowSize);
	}
	
	@Override
	protected void call(final ITimeSeries series) {
		series.median();
	}
	
}
