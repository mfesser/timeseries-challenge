package de.cinovo.timeseries.impl.ringskip;


/**
 * @author mfesser
 * @param <NUM>
 *            calculated number
 * 
 */
public class CalculatedValue<NUM extends Number> {

	/**
	 * true if the value is calculated
	 */
	public boolean calculated;
	/**
	 * the actual value
	 */
	public NUM value = null;

	public CalculatedValue() {
		calculated = false;
	}

	public CalculatedValue(NUM initial) {
		value = initial;
		calculated = true;
	}
}
