package com.vmrob.SBSEdit;

class SBSEditHeadless extends SBSEdit {

	public SBSEditHeadless(Params params) {
		super(params);
	}

	public int run() {
		if (params.savefile == null || params.savefile == "") {
			System.out.println("a savefile must be provided in headless mode");
			return 1;
		}

		if (params.tasks() == 0) {
			System.out.println("no tasks to perform");
			return 0;
		}

		SectorProvider provider = new SectorProvider(params.savefile);;
		provider.read();

		SectorEditor editor = new SectorEditor(provider.getSectorRoot());

		if (params.stats) {
			// TODO: provide statistics

			System.out.println("statistics features is currently unimplemented");

			if (params.tasks() == 1) {
				return 0;
			}
		}

		int removed = 0;
		int modified = 0;

		// TODO: get list of stuff to be modified, output nicely

		if (params.minComponents > 0) {
			removed += editor.removeDebris(params.minComponents);
		}
		if (params.outlierDistance > 0) {
			removed += editor.removeOutliers(params.outlierDistance);
		}
		if (params.scalar > 0) {
			modified += editor.scaleSector(params.scalar);
		}

		if (removed == 0 && modified == 0) {
			System.out.println("nothing to change");
			return 0;
		}

		System.out.format("remove %d objects and modify %d others? [y/n]: ", removed, modified);
		do {
			String response = System.console().readLine();

			if (response.toUpperCase().equals("Y")) {
				provider.write();
				break;
			} else if (response.toUpperCase().equals("N")) {
				break;
			}
			System.out.format("please respond with y or n: ");
		} while (true);

		return 0;
	}
}