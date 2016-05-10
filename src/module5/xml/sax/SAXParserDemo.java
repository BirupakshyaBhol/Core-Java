package module5.xml.sax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Demostrates the SAX parser, loads a breakfast menu to a list.
 * @author pbose
 *
 */
public final class SAXParserDemo 
{
	public static void main(String[] args) throws Exception 
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java module6.SAXParserDemo xml_filename");
			System.exit(-1);
		}

		// Get the SAX parser factory instance
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		// Get the SAX parser from the factory instance
		SAXParser parser = parserFactory.newSAXParser();
		MenuXMLHandler handler = new MenuXMLHandler();
		// Call the SAX parser 
		parser.parse(args[0], handler);
		// Print the menu
		for (MenuItem item : handler.menuItems)
			System.out.println(item);
	}
}

/**
 * This class methods are called as the SAX parses the events.
 * @author pbose
 *
 */
class MenuXMLHandler extends DefaultHandler 
{
	protected List<MenuItem> menuItems = new ArrayList<>();
	protected MenuItem item = null;
	protected String content = null;

	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException 
	{
		switch(qName)
		{
			case "food":
			item = new MenuItem();
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, 
			String qName) throws SAXException 
	{
		switch(qName)
		{
			case "food":
				menuItems.add(item);
				break;
			case "name":
				item.name = content;
				break;
			case "price":
				item.price = content;
				break;
			case "description":
				item.description = content;
				break;
			case "calories":
				item.calories = content;
				break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException 
	{ content = String.copyValueOf(ch, start, length).trim(); }
}
