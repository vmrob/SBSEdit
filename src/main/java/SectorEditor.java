package com.vmrob.SBSEdit;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

class SectorEditor {
	private NodeList sectorRoot;

	SectorEditor(NodeList sectorRoot) {
		this.sectorRoot = sectorRoot;
	}

	// TODO: make these functions return arraylists of modifed nodes

	public int scaleSector(double scalar) {
		System.out.format("scaling sector by a factor of %.2f\n", scalar);

		if (sectorRoot.getLength() != 1) {
			// TODO: log error
			System.out.println("multiple or no SectorObjects node found in document root");
			return 0;
		}

		Node n = sectorRoot.item(0);

		//if (n.getNodeType() != Node.)


		int size = sectorRoot.getLength();

		for (int i = 0; i < size; ++i) {
			//Node  = sectorRoot.item(i);

			// if (n.getNodeType() == Node.ELEMENT_NODE) {
			// 	System.out.format("node: %s", n.getNodeName());
			// }
		}

		return 0;
	}

	public int removeOutliers(double distance) {
		System.out.format("removing ships %d meters away from the origin\n", distance);
		return 0;
	}

	public int removeDebris(int minComponents) {
		System.out.format("removing ships with less than %d components\n", minComponents);
		return 0;
	}
}