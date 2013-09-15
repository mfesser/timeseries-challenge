package de.cinovo.timeseries.benchmark;

import de.cinovo.timeseries.IFixedTimeWindow;
import de.cinovo.timeseries.impl.ringskip.FixedTimeWindow;

/**
 * 
 * @author mwittig
 * 
 */
public final class FixedTimeWindowBenchmarkSuite extends ABenchmarkSuite {

	/**
	 * @param args
	 *            Arguments
	 * @throws Exception
	 *             If something went wrong...
	 */
	public static void main(final String[] args) throws Exception {
		new FixedTimeWindowBenchmarkSuite().run();
	}

	@Override
	protected IFixedTimeWindow create(final long windowSize) {
		return new FixedTimeWindow(windowSize);
	}

}
// FirstBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1923187,00 1923,19 1,92
// Min 1682517,00 1682,52 1,68
// Max 14696973,00 14696,97 14,70
//
// LastBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2013627,00 2013,63 2,01
// Min 1804066,00 1804,07 1,80
// Max 16492379,00 16492,38 16,49
//
// AverageBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2079369,00 2079,37 2,08
// Min 1841181,00 1841,18 1,84
// Max 4060000,00 4060,00 4,06
//
// MinimumBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2136431,00 2136,43 2,14
// Min 1945101,00 1945,10 1,95
// Max 3571328,00 3571,33 3,57
//
// MaximumBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2124483,00 2124,48 2,12
// Min 1918502,00 1918,50 1,92
// Max 4949817,00 4949,82 4,95
//
// VarianceBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5115006,00 5115,01 5,12
// Min 4676407,00 4676,41 4,68
// Max 11451941,00 11451,94 11,45
//
// DeviationBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5126018,00 5126,02 5,13
// Min 4696202,00 4696,20 4,70
// Max 7766487,00 7766,49 7,77
//
// MedianBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2092519,00 2092,52 2,09
// Min 1869944,00 1869,94 1,87
// Max 14027368,00 14027,37 14,03
//
// FirstBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1716477,00 1716,48 1,72
// Min 1595298,00 1595,30 1,60
// Max 4364338,00 4364,34 4,36
//
// LastBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1866731,00 1866,73 1,87
// Min 1685610,00 1685,61 1,69
// Max 13896848,00 13896,85 13,90
//
// AverageBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1833851,00 1833,85 1,83
// Min 1706951,00 1706,95 1,71
// Max 13429517,00 13429,52 13,43
//
// MinimumBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 4676018,00 4676,02 4,68
// Min 4324749,00 4324,75 4,32
// Max 7662876,00 7662,88 7,66
//
// MaximumBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 3952716,00 3952,72 3,95
// Min 3686382,00 3686,38 3,69
// Max 15573489,00 15573,49 15,57
//
// VarianceBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 164169628,00 164169,63 164,17
// Min 158570739,00 158570,74 158,57
// Max 216374169,00 216374,17 216,37
//
// DeviationBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 164176629,00 164176,63 164,18
// Min 159943351,00 159943,35 159,94
// Max 179671792,00 179671,79 179,67
//
// MedianBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1924260,00 1924,26 1,92
// Min 1732621,00 1732,62 1,73
// Max 13969841,00 13969,84 13,97
//
