package de.cinovo.timeseries.impl;

import de.cinovo.timeseries.IFixedTimeWindow;
import de.cinovo.timeseries.impl.ringskip.FixedTimeWindow;
import de.cinovo.timeseries.test.AFixedTimeWindowTest;

/**
 * 
 * @author mfesser
 * 
 */
public final class FixedTimeWindowTest extends AFixedTimeWindowTest {
	
	@Override
	protected IFixedTimeWindow create() {
		return new FixedTimeWindow(1000l);
	}
	
}
