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
		return new FixedTimeWindow(1000l);
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
// FirstBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2199390,00 2199,39 2,20
// Min 1990257,00 1990,26 1,99
// Max 13386836,00 13386,84 13,39
//
// LastBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2236161,00 2236,16 2,24
// Min 2028300,00 2028,30 2,03
// Max 3647721,00 3647,72 3,65
//
// AverageBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2083636,00 2083,64 2,08
// Min 1878295,00 1878,30 1,88
// Max 3429056,00 3429,06 3,43
//
// MinimumBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2144633,00 2144,63 2,14
// Min 1963040,00 1963,04 1,96
// Max 3519986,00 3519,99 3,52
//
// MaximumBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2136368,00 2136,37 2,14
// Min 1947885,00 1947,89 1,95
// Max 3935668,00 3935,67 3,94
//
// VarianceBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5123443,00 5123,44 5,12
// Min 4690326,00 4690,33 4,69
// Max 8150001,00 8150,00 8,15
//
// DeviationBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5120042,00 5120,04 5,12
// Min 4701151,00 4701,15 4,70
// Max 7747001,00 7747,00 7,75
//
// MedianBenchmark (window: 10000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2084359,00 2084,36 2,08
// Min 1899945,00 1899,95 1,90
// Max 9051880,00 9051,88 9,05
//
// FirstBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2201490,00 2201,49 2,20
// Min 2003247,00 2003,25 2,00
// Max 3702775,00 3702,78 3,70
//
// LastBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2271256,00 2271,26 2,27
// Min 2065104,00 2065,10 2,07
// Max 14137783,00 14137,78 14,14
//
// AverageBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2082248,00 2082,25 2,08
// Min 1875202,00 1875,20 1,88
// Max 8142888,00 8142,89 8,14
//
// MinimumBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2123864,00 2123,86 2,12
// Min 1923451,00 1923,45 1,92
// Max 4109486,00 4109,49 4,11
//
// MaximumBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2121610,00 2121,61 2,12
// Min 1921595,00 1921,60 1,92
// Max 7200184,00 7200,18 7,20
//
// VarianceBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5137369,00 5137,37 5,14
// Min 4695584,00 4695,58 4,70
// Max 16664342,00 16664,34 16,66
//
// DeviationBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5101581,00 5101,58 5,10
// Min 4687233,00 4687,23 4,69
// Max 8405781,00 8405,78 8,41
//
// MedianBenchmark (window: 30000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2074498,00 2074,50 2,07
// Min 1877986,00 1877,99 1,88
// Max 3765560,00 3765,56 3,77
//
// FirstBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2201878,00 2201,88 2,20
// Min 1977577,00 1977,58 1,98
// Max 4343925,00 4343,93 4,34
//
// LastBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2246294,00 2246,29 2,25
// Min 2054589,00 2054,59 2,05
// Max 3588648,00 3588,65 3,59
//
// AverageBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2088425,00 2088,43 2,09
// Min 1860975,00 1860,98 1,86
// Max 4022267,00 4022,27 4,02
//
// MinimumBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2150710,00 2150,71 2,15
// Min 1918193,00 1918,19 1,92
// Max 9754578,00 9754,58 9,75
//
// MaximumBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2105873,00 2105,87 2,11
// Min 1934895,00 1934,90 1,93
// Max 7747929,00 7747,93 7,75
//
// VarianceBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5101162,00 5101,16 5,10
// Min 4673005,00 4673,01 4,67
// Max 19307193,00 19307,19 19,31
//
// DeviationBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5100407,00 5100,41 5,10
// Min 4744759,00 4744,76 4,74
// Max 7283072,00 7283,07 7,28
//
// MedianBenchmark (window: 60000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2088547,00 2088,55 2,09
// Min 1887574,00 1887,57 1,89
// Max 3946183,00 3946,18 3,95
//
// FirstBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2209458,00 2209,46 2,21
// Min 1951905,00 1951,91 1,95
// Max 8565064,00 8565,06 8,57
//
// LastBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2236403,00 2236,40 2,24
// Min 2008195,00 2008,20 2,01
// Max 3494315,00 3494,32 3,49
//
// AverageBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2076928,00 2076,93 2,08
// Min 1885099,00 1885,10 1,89
// Max 3576276,00 3576,28 3,58
//
// MinimumBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2131638,00 2131,64 2,13
// Min 1913244,00 1913,24 1,91
// Max 4280521,00 4280,52 4,28
//
// MaximumBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2118064,00 2118,06 2,12
// Min 1898709,00 1898,71 1,90
// Max 3444830,00 3444,83 3,44
//
// VarianceBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5143825,00 5143,83 5,14
// Min 4751565,00 4751,57 4,75
// Max 8125568,00 8125,57 8,13
//
// DeviationBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 5138199,00 5138,20 5,14
// Min 4719089,00 4719,09 4,72
// Max 11425961,00 11425,96 11,43
//
// MedianBenchmark (window: 600000, runs: 1000; calls per run: 27088)
// nanos micros millis
// Avg 2074456,00 2074,46 2,07
// Min 1884481,00 1884,48 1,88
// Max 15274101,00 15274,10 15,27

