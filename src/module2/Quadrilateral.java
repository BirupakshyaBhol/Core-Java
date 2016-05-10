package module2;

public abstract class Quadrilateral 
{
	protected Integer base = null;
	protected Integer height = null;
	
	public abstract Integer area();
	
	public void setBase(Integer base)
	{ this.base = base; }
	
	public void setHeight(Integer height)
	{ this.height = height; }

	public Integer getBase()
	{ return this.base; }
	
	public Integer getHeight()
	{ return this.height; }
	
	public Quadrilateral(Integer base, Integer height)
	{
		this.base = new Integer(base);
		this.height = new Integer(height);
	}
}

class Rectangle extends Quadrilateral
{
	@Override
	public Integer area()
	{ return base.intValue() * height.intValue(); }
	
	public Rectangle(Integer base, Integer height)
	{ super(base, height); }
}
