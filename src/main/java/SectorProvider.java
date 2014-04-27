package com.vmrob.SBSEdit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

class SectorProvider {

	private File sbcFile;
	private Document sbcDoc;
	private NodeList sectorObjects;

	public SectorProvider(String file) throws NullPointerException {
		sbcFile = new File(file);
	}

	public void read() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			sbcDoc = dBuilder.parse(sbcFile);

			sbcDoc.getDocumentElement().normalize();

			sectorObjects = sbcDoc.getElementsByTagName("SectorObjects");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void write() {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();

			if (sbcDoc.getDoctype() != null) {
				String systemValue = (new File (sbcDoc.getDoctype().getSystemId())).getName();
				transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, systemValue);
			}

			DOMSource source = new DOMSource(sbcDoc);
			StreamResult result = new StreamResult(sbcFile);
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NodeList getSectorRoot() {
		return sectorObjects;
	}
}