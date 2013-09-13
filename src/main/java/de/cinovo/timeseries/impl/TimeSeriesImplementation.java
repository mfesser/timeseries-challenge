package de.cinovo.timeseries.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import de.cinovo.timeseries.ITimeSeries;
import de.cinovo.timeseries.ITimeSeriesPair;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 * 
 * @author mfesser
 * 
 */
public class TimeSeriesImplementation implements ITimeSeries {
	
	private final TimeBasedQueue values;
	
	private static final TimeSeriesPair CLEARED = new TimeSeriesPair(Long.MIN_VALUE, Float.NaN);
	
	private TimeSeriesPair cachedMaximum = TimeSeriesImplementation.CLEARED;
	
	private TimeSeriesPair cachedMinimum = TimeSeriesImplementation.CLEARED;
	
	private float cachedAvergage = Float.POSITIVE_INFINITY;
	
	private float cachedVariance = Float.POSITIVE_INFINITY;
	
	private float cachedDeviation = Float.POSITIVE_INFINITY;
	
	private float cachedMedian = Float.POSITIVE_INFINITY;
	
	
	/**
	 * @param values base for this series
	 */
	public TimeSeriesImplementation(final TimeBasedQueue values) {
		super();
		this.values = values;
	}
	
	/**
	 * 
	 */
	public void clearCache() {
		this.cachedMaximum = TimeSeriesImplementation.CLEARED;
		this.cachedMinimum = TimeSeriesImplementation.CLEARED;
		this.cachedAvergage = Float.POSITIVE_INFINITY;
		this.cachedVariance = Float.POSITIVE_INFINITY;
		this.cachedDeviation = Float.POSITIVE_INFINITY;
		this.cachedMedian = Float.POSITIVE_INFINITY;
	}
	
	private void refreshCacheMinMaxAvg() {
		final ITimeSeriesPair first = this.first();
		if (first != null) {
			long minTime = first.time();
			float min = first.value();
			long maxTime = first.time();
			float max = first.value();
			BigDecimal sum = BigDecimal.ZERO;
			for (final TimeSeriesPair pair : this.values) {
				if (pair.value() < min) {
					minTime = pair.time();
					min = pair.value();
				}
				if (pair.value() > max) {
					maxTime = pair.time();
					max = pair.value();
				}
				sum = sum.add(new BigDecimal(pair.value()));
			}
			this.cachedMinimum = new TimeSeriesPair(minTime, min);
			this.cachedMaximum = new TimeSeriesPair(maxTime, max);
			this.cachedAvergage = sum.divide(new BigDecimal(this.values.size()), 4, RoundingMode.HALF_UP).floatValue();
		} else {
			this.cachedMinimum = null;
			this.cachedMaximum = null;
			this.cachedAvergage = Float.NaN;
		}
	}
	
	private void refreshCacheVarDev() {
		if (Float.isInfinite(this.cachedAvergage)) {
			this.refreshCacheMinMaxAvg();
		}
		if (this.values.size() > 0) {
			double sumAbweichungImQuadrat = 0.0d;
			for (final TimeSeriesPair pair : this.values) {
				final float abweichung = pair.value() - this.cachedAvergage;
				sumAbweichungImQuadrat += abweichung * abweichung;
			}
			this.cachedVariance = (float) (sumAbweichungImQuadrat / this.values.size());
			this.cachedDeviation = (float) Math.sqrt(this.cachedVariance);
		} else {
			this.cachedVariance = Float.NaN;
			this.cachedDeviation = Float.NaN;
		}
	}
	
	private void refreshCacheMed() {
		if (this.values.size() > 0) {
			final float[] v = new float[this.values.size()];
			int i = 0;
			for (final TimeSeriesPair pair : this.values) {
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
			this.cachedMedian = med;
		} else {
			this.cachedMedian = Float.NaN;
		}
	}
	
	@Override
	public ITimeSeriesPair first() {
		return this.values.peekFirst();
	}
	
	@Override
	public ITimeSeriesPair last() {
		return this.values.peekLast();
	}
	
	@Override
	public ITimeSeriesPair minimum() {
		if (this.cachedMinimum == TimeSeriesImplementation.CLEARED) {
			this.refreshCacheMinMaxAvg();
		}
		return this.cachedMinimum;
	}
	
	@Override
	public ITimeSeriesPair maximum() {
		if (this.cachedMaximum == TimeSeriesImplementation.CLEARED) {
			this.refreshCacheMinMaxAvg();
		}
		return this.cachedMaximum;
	}
	
	@Override
	public float avergage() {
		if (Float.isInfinite(this.cachedAvergage)) {
			this.refreshCacheMinMaxAvg();
		}
		return this.cachedAvergage;
	}
	
	@Override
	public float variance() {
		if (Float.isInfinite(this.cachedVariance)) {
			this.refreshCacheVarDev();
		}
		return this.cachedVariance;
	}
	
	@Override
	public float deviation() {
		if (Float.isInfinite(this.cachedDeviation)) {
			this.refreshCacheVarDev();
		}
		return this.cachedDeviation;
	}
	
	@Override
	public float median() {
		if (Float.isInfinite(this.cachedMedian)) {
			this.refreshCacheMed();
		}
		return this.cachedMedian;
	}
	
	@Override
	public int size() {
		return this.values.size();
	}
	
}
