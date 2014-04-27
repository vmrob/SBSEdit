package com.vmrob.SBSEdit;

abstract class SBSEdit {

	protected Params params;

	public SBSEdit(Params params) {
		this.params = params;
	}

	abstract public int run();
}