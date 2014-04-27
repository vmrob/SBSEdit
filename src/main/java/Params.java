package com.vmrob.SBSEdit;

import com.beust.jcommander.Parameter;

class Params {
	@Parameter(names = "--headless", description = "Headless mode")
	public boolean headless = false;

	@Parameter(names = "--savefile", description = "Path to SANDBOX_0_0_0_.sbc")
	public String savefile;

	@Parameter(names = "--remove-debris", description = "Remove ships below a threshold")
	public int minComponents;

	@Parameter(names = "--remove-outliers", description = "Remove ships outside a radius from spawn")
	public int outlierDistance;

	@Parameter(names = "--scale-sector", description = "Scales the sector")
	public double scalar;

	@Parameter(names = "--stats", description = "Provide statistics")
	public boolean stats = false;

	public int tasks() {
		return minComponents > 0 ? 1 : 0
			+ outlierDistance > 0 ? 1 : 0
			+ scalar > 0 ? 1 : 0
			+ (stats ? 1 : 0);
	}
}