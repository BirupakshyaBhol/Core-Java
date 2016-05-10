package module5.xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Demostrates the DOM parser.
 * @author pbose
 *
 */
public final class DOMParserDemo 
{
	public static void dumpXMLToConsole(Document model)
	{
		NodeList nodes = model.getElementsByTagName("book");
		 	 
		for (int i = 0; i < nodes.getLength(); i++) 
		{	 
			Node node = nodes.item(i);
			
			/**
			 * There are various types of XML node, check org.w3c.dom.Node and
			 * http://www.w3schools.com/Dom/dom_nodetype.asp for various types of nodes.
			 */
			if (node.getNodeType() == Node.ELEMENT_NODE) 
			{	 
				Element eElement = (Element)node;
	 
				System.out.print("[Book ID]: " + eElement.getAttribute("id"));
				System.out.print(" [Title]: " + eElement.getElementsByTagName("title").item(0).getTextContent());
				System.out.print(" [Price]: " + eElement.getElementsByTagName("price").item(0).getTextContent());
				System.out.print(" [Genre]: " + eElement.getElementsByTagName("genre").item(0).getTextContent());
				System.out.println(" [Publish Date]: " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
			}
		}
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java module6.DOMParserDemo xml_filename");
			System.exit(-1);
		}
		
		DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = parserFactory.newDocumentBuilder();
		
		Document model = builder.parse(args[0]);
		
		DOMParserDemo.dumpXMLToConsole(model);
		
		
	}
}
