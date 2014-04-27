package com.vmrob.SBSEdit;

import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SBSEditGui extends SBSEdit {

	private String getSavefile() {
		FileDialog savefileSelect = new FileDialog(frame, "SANDBOX_0_0_0_.sbc", FileDialog.LOAD);
		String savefileRoot = System.getProperty("user.home") + File.separator + "AppData"; // TODO: fix this path: + File.separator
		savefileSelect.setDirectory(savefileRoot);
		savefileSelect.setMultipleMode(false);

		savefileSelect.setVisible(true);

		return savefileSelect.getFile();
	}

	JFrame frame;

	public SBSEditGui(Params params) {
		super(params);

		frame = new JFrame("SBSEdit");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel contentPanel = new JPanel(new GridBagLayout());

		frame.add(contentPanel);

		frame.pack();
	}

	public int run() {
		String savefile = params.savefile;
		
		if (savefile == null) {
			savefile = getSavefile();
		}
		
		if (savefile == null) {
			JOptionPane.showMessageDialog(frame
				, "A valid SANDBOX_0_0_0_.sbc file must be selected for editting."
				, "Invalid Selection"
				, JOptionPane.ERROR_MESSAGE);
			return 1;
		}

		frame.setVisible(true);

		return 0;
	}
}