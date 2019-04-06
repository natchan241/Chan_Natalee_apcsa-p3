//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;
    private int length;

    public WordSearch( int size, String str )
    {
    	m = new String[size][size];
    	length = size;
    	for (int i = 0; i < size * size; i++)
    	{
    		m[i / size][i % size] = str.substring(i, i + 1);
    	}
    }

    public boolean isFound( String word )
    {
    	boolean rightLeft = (checkRight(word, 0, 0) || checkLeft(word, length - 1, length - 1));
    	boolean upDown = (checkUp(word, length - 1, length - 1) || checkDown(word, 0, 0));
    	boolean diagUp = (checkDiagUpRight(word, length - 1, 0) || checkDiagUpLeft(word, length - 1, length - 1));
    	boolean diagDown = (checkDiagDownRight(word, 0, 0) || checkDiagDownLeft(word, 0, length - 1));
    	return rightLeft || upDown || diagUp || diagDown;
    }

	public boolean checkRight(String w, int r, int c)
   {
		if (length <= r || length - c < w.length()) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r][c + i]))) 
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkRight(w, r + 1, c) || checkRight(w, r, c + 1);
	}

	public boolean checkLeft(String w, int r, int c)
	{
		if (r < 0 || c + 1 < w.length()) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r][c - i]))) 
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkLeft(w, r - 1, c) || checkLeft(w, r, c - 1);
	}

	public boolean checkUp(String w, int r, int c)
	{
		if (r + 1 < w.length() || c < 0) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r - i][c])))
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkUp(w, r - 1, c) || checkUp(w, r, c - 1);
	}

	public boolean checkDown(String w, int r, int c)
   {
		if (length - r < w.length() || length <= c) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r + i][c]))) 
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkDown(w, r + 1, c) || checkDown(w, r, c + 1);
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		if (r + 1 < w.length() || length - c < w.length()) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r - i][c + i]))) 
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkDiagUpRight(w, r - 1, c) || checkDiagUpRight(w, r, c + 1);
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		if (r + 1 < w.length() || c + 1 < w.length()) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r - i][c - i]))) 
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkDiagUpLeft(w, r - 1, c) || checkDiagUpLeft(w, r, c - 1);
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
		if (length - r < w.length() || c + 1 < w.length()) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r + i][c - i])))
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkDiagDownLeft(w, r + 1, c) || checkDiagDownLeft(w, r, c - 1);
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		if (length - r < w.length() || length - c < w.length()) return false;
		
		boolean isEqual = true;
		
		for (int i = 0; i < w.length(); i++)
		{
			if (!(w.substring(i, i + 1).contentEquals(m[r + i][c + i])))
			{
				isEqual = false;
				break;
			}
		}
		if (isEqual) return true;
		return checkDiagDownRight(w, r + 1, c) || checkDiagDownRight(w, r, c + 1);
	}

    public String toString()
    {
    	String output="";
    	for (int i = 0; i < m.length; i++)
    	{
    		for (int j = 0; j < m.length; j++)
    		{
    			output = output + m[i][j] + " ";
    		}
    		output += "\n";
    	}
 		return output;
    }
}
