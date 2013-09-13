package de.cinovo.timeseries.impl.ringskip;

import java.util.ArrayList;
import java.util.Arrays;

import de.cinovo.timeseries.ITimeSeriesPair;
import de.cinovo.timeseries.impl.TimeSeriesPair;

/**
 * @author mfesser
 * 
 */
public class TimeBaseBucket {
	
	private static final int SIZE = 1000;
	
	private ArrayList<TimeSeriesPair> values = new ArrayList<>(TimeBaseBucket.SIZE);
	
	private int first = 0;
	private int last = 0;
	
	private CalculatedValue<Float> min;
	private CalculatedValue<Float> max;
	private CalculatedValue<Double> avg;
	private CalculatedValue<Double> variance;
	private CalculatedValue<Float> median;
	
	
	public TimeBaseBucket() {
		
	}
	
	private void calculatevalues() {
		if ((this.last - this.first) > 0) {
			this.min.value = Float.POSITIVE_INFINITY;
			this.max.value = Float.NEGATIVE_INFINITY;
			double sum = 0;
			
			for (int ct = this.first; ct < this.last; ct++) {
				final TimeSeriesPair pair = this.values.get(ct);
				if (pair.value() < this.min.value) {
					this.min.value = pair.value();
				}
				if (pair.value() > this.max.value) {
					this.max.value = pair.value();
				}
				sum = sum + pair.value();
			}
			this.avg.value = sum / (this.last - this.first);
		} else {
			this.max.calculated = false;
			this.min.calculated = false;
			this.avg.calculated = false;
		}
		// this.refreshCacheVarDev();
	}
	
	private void refreshCacheVarDev() {
		if (this.avg.calculated == false) {
			this.calculatevalues();
		}
		if ((this.last - this.first) > 0) {
			double sumAbweichungImQuadrat = 0.0d;
			for (int ct = this.first; ct < this.last; ct++) {
				final TimeSeriesPair pair = this.values.get(ct);
				final double abweichung = (pair.value() - this.avg.value);
				sumAbweichungImQuadrat += abweichung * abweichung;
			}
			this.variance.value = (sumAbweichungImQuadrat / (this.last - this.first));
		} else {
			this.variance.calculated = false;
		}
		
	}
	
	// http://ndevilla.free.fr/median/median/
	private void refreshCacheMed() {
		if (this.values.size() > 0) {
			final float[] v = new float[this.last - this.first];
			int i = 0;
			for (int ct = this.first; ct < this.last; ct++) {
				final TimeSeriesPair pair = this.values.get(ct);
				v[i] = pair.value();
				i++;
			}
			
			Arrays.sort(v);
			final float med;
			if ((v.length % 2) == 0) {
				med = (v[(v.length / 2) - 1] + v[v.length / 2]) / 2.0f;
			} else {
				med = v[v.length / 2];
			}
			this.median.value = med;
		} else {
			this.median.calculated = false;
		}
	}
	
	private ITimeSeriesPair first() {
		return this.values.get(this.first);
	}
	
	public boolean addValue(TimeSeriesPair pair) {
		if (this.last < TimeBaseBucket.SIZE) {
			this.values.set(this.last, pair);
			// if()
		}
		return true;
	}
	
	public Float min() {
		if (!this.min.calculated) {
			
		}
		return this.min.value;
	}
}
