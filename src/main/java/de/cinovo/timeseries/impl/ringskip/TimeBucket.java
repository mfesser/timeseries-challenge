package de.cinovo.timeseries.impl.ringskip;

import java.util.ArrayDeque;

import de.cinovo.timeseries.ITimeSeries;
import de.cinovo.timeseries.ITimeSeriesPair;
import de.cinovo.timeseries.impl.TimeSeriesPair;

// reference, but not used here
// http://ndevilla.free.fr/median/median/
/**
 * @author mfesser
 * 
 */
public class TimeBucket implements ITimeSeries {

	private static final int SIZE = 10000;

	private final ArrayDeque<TimeSeriesPair> values;

	private TimeSeriesPair min = null;
	private TimeSeriesPair max = null;
	private CalculatedValue<Double> sum = new CalculatedValue<>(0d);
	private CalculatedValue<Double> variance = new CalculatedValue<>();

	private long window;

	public TimeBucket(long window) {
		this.window = window;
		this.values = new ArrayDeque<>(SIZE);
	}

	private void calculateMinMax() {
		this.sum.value = 0d;

		if (this.values.size() > 0) {
			this.min = this.values.getFirst();
			this.max = this.min;
			for (TimeSeriesPair pair : this.values) {
				this.updateMinMaxAddOnly(pair);
				this.sum.value = this.sum.value + pair.value();
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

	private void calculateVariance() {
		if (this.values.size() > 0) {
			double sumAbweichungImQuadrat = 0.0d;
			float average = this.avergage();
			for (TimeSeriesPair pair : this.values) {
				final double abweichung = (pair.value() - average);
				sumAbweichungImQuadrat += abweichung * abweichung;
			}
			this.variance.value = (sumAbweichungImQuadrat / (this.size()));
		} else {
			this.variance.calculated = false;
		}

	}

	public void addValue(TimeSeriesPair pair) {
		this.removeTail(pair.time());
		this.values.add(pair);
		this.sum.value = this.sum.value + pair.value();
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
				this.sum.value = this.sum.value - pair.value();
				this.variance.calculated = false;
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
		return new Float(this.sum.value / this.size());
	}

	public double varianceDouble() {
		if (this.size() == 0) {
			return Double.NaN;
		}
		if (!this.variance.calculated) {
			this.calculateVariance();
		}
		return this.variance.value;
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
