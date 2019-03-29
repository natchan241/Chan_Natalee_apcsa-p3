//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		Grid run = new Grid(3, 3, new String[] {"a", "b", "c"});
		out.println(run);
		out.println(run.findMax(new String[] {"a", "b", "c"}));
		
		Grid run1 = new Grid(6, 6, new String[] {"a", "b", "c", "d", "e", "f"});
		out.println(run1);
		out.println(run1.findMax(new String[] {"a", "b", "c", "d", "e", "f"}));
	}
}