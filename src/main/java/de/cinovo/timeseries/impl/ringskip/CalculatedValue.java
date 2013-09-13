package de.cinovo.timeseries.impl.ringskip;

/**
 * @author mfesser
 * @param <NUM> Number
 * 
 */
public class CalculatedValue<NUM extends Number> {
	
	/**
	 * true if the value is calculated
	 */
	public boolean calculated = false;
	/**
	 * the actual value
	 */
	public NUM value = null;
}
