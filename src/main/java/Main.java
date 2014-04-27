package com.vmrob.SBSEdit;

import com.beust.jcommander.JCommander;

class Main {

	public static void main(String[] args) {

		Params params = new Params();

		try {
			new JCommander(params, args);	
		} catch (Exception e) {
			System.out.println("error parsing arguments");
			e.printStackTrace();
		}
		

		SBSEdit prog = params.headless ? new SBSEditHeadless(params) : new SBSEditGui(params);

		System.exit(prog.run());
	}

}