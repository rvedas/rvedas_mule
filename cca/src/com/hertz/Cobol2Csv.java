package com.hertz;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

class Cobol2Csv {

	public static void main(String args[]) throws Exception {

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}

		String inputFileName = args[0];
		String outputputFileName = args[1];

		File stylesheet = new File("Cobol2CsvStylesheet.xsl");
		// File xmlSource = new File("src/CobolInput.xml");
		// File xmlSource = new
		// File("/Users/shiva/Desktop/Hertz/Cobol_Copybook_Analysis/input/scrdcevd_sivaji_test.cbl.xml");
		File xmlSource = new File(inputFileName);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(xmlSource);

		StreamSource stylesource = new StreamSource(stylesheet);
		Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
		Source source = new DOMSource(document);
		// Result outputTarget = new StreamResult(new
		// File("/Users/shiva/Desktop/Hertz/Cobol_Copybook_Analysis/output/scrdcevd_sivaji_test.cbl.csv"));
		Result outputTarget = new StreamResult(new File(outputputFileName));
		transformer.transform(source, outputTarget);
		System.out.println("Successfully generated report");
	}
}