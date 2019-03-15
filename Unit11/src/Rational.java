//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	int numer, denom;

	public Rational()
	{
		setRational(1,1);
	}
	
	public Rational(int numerator, int denominator)
	{
		setRational(numerator, denominator);
	}

	public void setRational(int numerator, int denominator)
	{
		setNumerator(numerator);
		setDenominator(denominator);
	}
	
	public void setNumerator(int numerator)
	{
		numer = numerator;
	}

	public void setDenominator(int denominator)
	{
		denom = denominator;
	}
	
	public void add(Rational  other)
	{
		setNumerator(numer * other.getDenominator() + other.getNumerator() * denom);
		setDenominator(denom * other.getDenominator());

		reduce();
	}

	private void reduce()
	{

		int gcd = gcd(numer, denom);
		setNumerator(numer/gcd);
		setDenominator(denom/gcd);

	}

	private int gcd(int numOne, int numTwo)
	{

		int gcd = 1;
		for (int i = 1; i <= numOne && i <= numTwo; i++)
		{
			if (numOne % i == 0 && numTwo % i == 0) gcd = i;
		}
		
		return gcd;
		
	}

	public Object clone ()
	{
		Rational Object = new Rational(numer, denom);
		return Object;
	}


	//ACCESSORS

	public int getNumerator()
	{
		return numer;
	}
	
	public int getDenominator()
	{
		return denom;
	}
	
	public boolean equals(Rational obj)
	{
		obj.reduce();
		reduce();
		if (numer * obj.getDenominator() - obj.getNumerator() * denom == 0)
		{
			return true;
		}

		return false;
	}

	public int compareTo(Rational other)
	{
		other.reduce();
		reduce();
		if (numer * other.getDenominator() - other.getNumerator() * denom > 0) return 1;
		
		else if (numer * other.getDenominator() - other.getNumerator() * denom < 0) return -1;

		else return 0;
	}

	public String toString()
	{
		return numer + "/" + denom;
	}
	
}