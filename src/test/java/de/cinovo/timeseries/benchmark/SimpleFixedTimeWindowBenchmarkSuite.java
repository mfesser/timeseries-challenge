package de.cinovo.timeseries.benchmark;

import de.cinovo.timeseries.IFixedTimeWindow;
import de.cinovo.timeseries.impl.SimpleFixedTimeWindow;

/**
 * 
 * @author mwittig
 * 
 */
public final class SimpleFixedTimeWindowBenchmarkSuite extends ABenchmarkSuite {

	/**
	 * @param args
	 *            Arguments
	 * @throws Exception
	 *             If something went wrong...
	 */
	public static void main(final String[] args) throws Exception {
		new SimpleFixedTimeWindowBenchmarkSuite().run();
	}

	@Override
	protected IFixedTimeWindow create(final long windowSize) {
		return new SimpleFixedTimeWindow(windowSize);
	}

}
// FirstBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1568928,00 1568,93 1,57
// Min 1404778,00 1404,78 1,40
// Max 4242170,00 4242,17 4,24
//
// LastBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1890309,00 1890,31 1,89
// Min 1678187,00 1678,19 1,68
// Max 4787751,00 4787,75 4,79
//
// AverageBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 64784369,00 64784,37 64,78
// Min 62571078,00 62571,08 62,57
// Max 78629528,00 78629,53 78,63
//
// MinimumBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 64378814,00 64378,81 64,38
// Min 62166222,00 62166,22 62,17
// Max 77591254,00 77591,25 77,59
//
// MaximumBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 64485205,00 64485,21 64,49
// Min 62008486,00 62008,49 62,01
// Max 80060286,00 80060,29 80,06
//
// VarianceBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 65324369,00 65324,37 65,32
// Min 63056966,00 63056,97 63,06
// Max 78642828,00 78642,83 78,64
//
// DeviationBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 65510053,00 65510,05 65,51
// Min 62954902,00 62954,90 62,95
// Max 80912988,00 80912,99 80,91
//
// MedianBenchmark (window: 1000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 3845070,00 3845,07 3,85
// Min 3573184,00 3573,18 3,57
// Max 15273482,00 15273,48 15,27
//
// FirstBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1962293,00 1962,29 1,96
// Min 1745921,00 1745,92 1,75
// Max 14350263,00 14350,26 14,35
//
// LastBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1996281,00 1996,28 2,00
// Min 1794787,00 1794,79 1,79
// Max 3177916,00 3177,92 3,18
//
// AverageBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 168655500,00 168655,50 168,66
// Min 164253873,00 164253,87 164,25
// Max 193363274,00 193363,27 193,36
//
// MinimumBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 163730520,00 163730,52 163,73
// Min 160107582,00 160107,58 160,11
// Max 210507010,00 210507,01 210,51
//
// MaximumBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 166669931,00 166669,93 166,67
// Min 160596873,00 160596,87 160,60
// Max 181838651,00 181838,65 181,84
//
// VarianceBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 168467043,00 168467,04 168,47
// Min 163381996,00 163382,00 163,38
// Max 201647196,00 201647,20 201,65
//
// DeviationBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 168260350,00 168260,35 168,26
// Min 163399625,00 163399,63 163,40
// Max 191391266,00 191391,27 191,39
//
// MedianBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 6850650,00 6850,65 6,85
// Min 6472742,00 6472,74 6,47
// Max 8391863,00 8391,86 8,39
//
// FirstBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1935609,00 1935,61 1,94
// Min 1772829,00 1772,83 1,77
// Max 3150699,00 3150,70 3,15
//
// LastBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 1979718,00 1979,72 1,98
// Min 1821077,00 1821,08 1,82
// Max 3167401,00 3167,40 3,17
//
