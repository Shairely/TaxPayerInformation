package com.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = Logger.getLogger(FormServlet.class);

	public FormServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOGGER.info("values setting started.....");

		String name = request.getParameter("name").toString();
		String address = request.getParameter("address").toString();
		String pan = request.getParameter("pan").toString();
		String dob = request.getParameter("dob").toString();
		String year = request.getParameter("year").toString();
		String income = request.getParameter("income").toString();
		String tds = request.getParameter("tds").toString();
		String tax = request.getParameter("tax").toString();

		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			createXmlTree(name, address, pan, dob, year, income, tds, tax);

			LOGGER.info("Xml File Created Successfully");

		} catch (Exception e) {
			LOGGER.error(" Exception has occured");
		}
	}

	public void createXmlTree(String name, String address, String pan, String dob, String year, String income,
			String tds, String tax) throws Exception {
		
		LOGGER.info(" Inside createXmlTree method");
		
		Element root;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		File file = new File("C:/Test/file.xml");
		if (file.exists()) {
			DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = fact.newDocumentBuilder();
			doc = docBuilder.parse(file);
			root = doc.getDocumentElement();
			String sr = root.getNodeName();

			// root = node.getNodeName();
		} else {

			root = doc.createElement("TaxPayers");
			doc.appendChild(root);
		}

		Element child = doc.createElement("tax payer");
		root.appendChild(child);

		Element child1 = doc.createElement("name");
		child.appendChild(child1);

		Text text1 = doc.createTextNode(name);
		child1.appendChild(text1);

		Element child2 = doc.createElement("address");
		child.appendChild(child2);

		Text text2 = doc.createTextNode(address);
		child2.appendChild(text2);

		Element child3 = doc.createElement("pan");
		child.appendChild(child3);

		Text text3 = doc.createTextNode(pan);
		child3.appendChild(text3);

		Element child4 = doc.createElement("dob");
		child.appendChild(child4);

		Text text4 = doc.createTextNode(dob);
		child4.appendChild(text4);

		Element child5 = doc.createElement("year");
		child.appendChild(child4);

		Text text5 = doc.createTextNode(year);
		child5.appendChild(text5);

		Element child6 = doc.createElement("income");
		child.appendChild(child5);

		Text text6 = doc.createTextNode(income);
		child6.appendChild(text6);

		Element child7 = doc.createElement("tds");
		child.appendChild(child7);

		Text text7 = doc.createTextNode(tds);
		child7.appendChild(text7);

		Element child8 = doc.createElement("tax");
		child.appendChild(child8);

		Text text8 = doc.createTextNode(tax);
		child8.appendChild(text8);

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		String xmlString = sw.toString();
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(xmlString);
		bw.flush();
		bw.close();

	}

}
