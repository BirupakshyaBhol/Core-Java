package module5.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator
{
	public static void main(String[] args)
	{
		if (args.length != 2) 
		{
			System.out.println("Usage: java module6.XMLValidator xsd_file xml_file");
			System.exit(-1);
		}

		try 
		{
			validateXMLSchema(args[0], args[1]);
			System.out.println(">>> " + args[1] + " validated against " + args[0]);
		}
		catch (IOException | SAXException e) 
		{
			System.out.println(">>> Invalid XML. " + e.getMessage());
		}
	}

	public static void validateXMLSchema(String xsdFile, String xmlFile) throws IOException, SAXException
	{
		try 
		{
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdFile));
			
			Validator validator = schema.newValidator();
			
			validator.validate(new StreamSource(new File(xmlFile)));
		}
		catch (IOException | SAXException e) 
		{
			throw e;
		}
	}
}