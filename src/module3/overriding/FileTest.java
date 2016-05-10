package module3.overriding;

public class FileTest
{
	/**
	 * Method shows runtime polymorphism. Based on the File type the 
	 * corresponding save() method will be called.
	 * @param f
	 */
	public static void save(File f)
	{ f.save(); }
	
	public static void main(String[] args)
	{
		save(new File());
		
		save(new CompressedFile());
	}
}

class File
{
	public void save() 
	{ System.out.println("File.save()"); }
}

class CompressedFile extends File
{
	@Override
	public void save()
	{ 
		System.out.println("CompressedFile.save()");

		// compression algorithm goes here
		
		super.save();
	}
}
