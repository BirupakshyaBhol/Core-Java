package module5.xml.sax;

/**
 * Each menu item for the menu.xml
 * @author pbose
 *
 */
public class MenuItem 
{
	protected String name = null;
	protected String price = null;
	protected String description = null;
	protected String calories = null;
	
	@Override
	public String toString() 
	{ return name + "/" + price + "/" + calories + " (" + description + ")"; }
}