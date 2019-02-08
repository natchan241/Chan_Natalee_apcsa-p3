//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*; 

public class CountPairsRunner
{
	public static void main( String[] args )
	{
		System.out.println( CountPairs.pairCounter("test_cases") );
		System.out.println( CountPairs.pairCounter("ddogccatppig") );
		System.out.println( CountPairs.pairCounter("dogcatapig") );
		System.out.println( CountPairs.pairCounter("xxyyzz") );
		System.out.println( CountPairs.pairCounter("a") );
		System.out.println( CountPairs.pairCounter("abc") );
		System.out.println( CountPairs.pairCounter("aabb") );
		System.out.println( CountPairs.pairCounter("dogctpigaabbcc") );
		System.out.println( CountPairs.pairCounter("aabbccdogcatpig") );
		System.out.println( CountPairs.pairCounter("dogabbccctpig") );
		System.out.println( CountPairs.pairCounter("aaaa") );
		System.out.println( CountPairs.pairCounter("AAAAAAAAA") );
		
	}
}