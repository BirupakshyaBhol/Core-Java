package module5.xml.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class MenuPriceFinder 
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		if (args.length != 2)
		{
			System.out.println("Usage: java module6.BkMenuPriceFinder xml_filename menu_item_name");
			System.exit(-1);
		}

		// Get the SAX parser factory instance
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		// Get the SAX parser from the factory instance
		SAXParser parser = parserFactor.newSAXParser();
		BreakfastMenuPriceHandler handler = new BreakfastMenuPriceHandler();
		
		handler.setQueryItem(args[1]);
		
		parser.parse(args[0], handler);
		
		if (handler.getQueryPrice() != null)
			System.out.println(args[1] + " costs " + handler.getQueryPrice() + ".");
		else System.out.println("We will shortly add this to our menu...");
	}
}

/**
 * This class methods are called as the SAX parses the events.
 * @author pbose
 *
 */
class BreakfastMenuPriceHandler extends DefaultHandler 
{
	protected String content = null;
	protected String query_item = null;
	protected String price = null;
	protected boolean name_found = false;
	
	public String getQueryPrice()
	{ return price; }
	
	public void setQueryItem(String query_item)
	{ this.query_item = query_item; }

	@Override
	public void endElement(String uri, String localName, 
			String qName) throws SAXException 
	{
		switch(qName)
		{
			case "name":
				if (content.compareTo(query_item) == 0)
					name_found = true;
				break;
			case "price":
				if (name_found) 
				{
					price = content;
					name_found = false;
				}
				break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException 
	{ content = String.copyValueOf(ch, start, length).trim(); }
}
