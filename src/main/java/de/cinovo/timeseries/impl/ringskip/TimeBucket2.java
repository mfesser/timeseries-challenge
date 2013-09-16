package de.cinovo.timeseries.impl.ringskip;

import java.util.ArrayDeque;

import de.cinovo.timeseries.ITimeSeries;
import de.cinovo.timeseries.ITimeSeriesPair;
import de.cinovo.timeseries.impl.TimeSeriesPair;

/**
 * @author mfesser
 * 
 */
public class TimeBucket2 implements ITimeSeries {

	private static final int INITIAL_SIZE = 10000;

	private final ArrayDeque<TimeSeriesPair> values;

	private TimeSeriesPair min = null;
	private TimeSeriesPair max = null;
	private double sum = 0d;
	private double squared = 0d;

	private long window;

	public TimeBucket2(long window) {
		this.window = window;
		this.values = new ArrayDeque<>(INITIAL_SIZE);
	}

	private void calculateMinMax() {
		this.sum = 0d;
		this.squared = 0d;

		if (this.values.size() > 0) {
			this.min = this.values.getFirst();
			this.max = this.min;
			for (TimeSeriesPair pair : this.values) {
				this.updateMinMaxAddOnly(pair);
				this.sum = this.sum + pair.value();
				this.squared = this.squared + pair.value() * pair.value();
			}
		}
	}

	private void updateMinMaxAddOnly(TimeSeriesPair pair) {
		if (this.min != null && this.max != null) {
			if (pair.value() < this.min.value()) {
				this.min = pair;
			}
			if (pair.value() > this.max.value()) {
				this.max = pair;
			}
		} else if (this.size() == 1) {
			this.min = pair;
			this.max = pair;
		}
	}

	// private void calculateVariance() {
	// if (this.values.size() > 0) {
	// double sumAbweichungImQuadrat = 0.0d;
	// float average = this.avergage();
	// for (TimeSeriesPair pair : this.values) {
	// final double abweichung = (pair.value() - average);
	// sumAbweichungImQuadrat += abweichung * abweichung;
	// }
	// this.variance.value = (sumAbweichungImQuadrat / (this.size()));
	// } else {
	// this.variance.calculated = false;
	// }
	// }

	public void addValue(TimeSeriesPair pair) {
		this.removeTail(pair.time());
		this.values.add(pair);
		this.sum = this.sum + pair.value();
		this.squared = this.squared + pair.value() * pair.value();
		this.updateMinMaxAddOnly(pair);
	}

	public void removeTail(long time) {
		long newStartTime = time - this.window;
		while (true) {
			final TimeSeriesPair pair = this.values.peekFirst();
			if (pair == null) {
				break;
			}

			if (pair.time() < newStartTime) {
				this.values.pollFirst();
				this.sum = this.sum - pair.value();
				this.squared = this.squared - pair.value() * pair.value();
			} else {
				break;
			}
		}
		if (this.min != null && this.min.time() < newStartTime) {
			this.min = null;
		}
		if (this.max != null && this.max.time() < newStartTime) {
			this.max = null;
		}

	}

	@Override
	public ITimeSeriesPair first() {
		ITimeSeriesPair result = null;
		if (this.values.size() > 0) {
			result = this.values.getFirst();
		}
		return result;
	}

	@Override
	public ITimeSeriesPair last() {
		ITimeSeriesPair result = null;
		if (this.values.size() > 0) {
			result = this.values.getLast();
		}
		return result;
	}

	@Override
	public ITimeSeriesPair minimum() {
		if (this.min == null) {
			this.calculateMinMax();
		}
		return this.min;
	}

	@Override
	public ITimeSeriesPair maximum() {
		if (this.max == null) {
			this.calculateMinMax();
		}
		return this.max;
	}

	@Override
	public float avergage() {
		return new Float(this.sum / this.size());
	}

	public double varianceDouble() {
		if (this.size() == 0) {
			return Double.NaN;
		}
		int size = this.size();
		double average = this.sum / size;

		double result = this.squared / size - average * average;
		// System.out.println("size " + size + " sum " + this.sum + " squared "
		// + this.squared + " res " + result);
		return result;
	}

	@Override
	public float variance() {
		return (float) this.varianceDouble();
	}

	@Override
	public float deviation() {
		return (float) Math.sqrt(this.varianceDouble());
	}

	@Override
	public float median() {
		return this.avergage();
	}

	@Override
	public int size() {
		return this.values.size();
	}

	public long window() {
		return this.window;
	}

}
