/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		
		Deck Deck1 = new Deck(new String[] {"Jack", "Queen", "King"}, new String[] {"Hearts", "Spades"}, new int [] {11, 12, 13});
		System.out.println(Deck1);
		Deck1.deal();
		System.out.println(Deck1);
		Deck1.shuffle();
		System.out.println(Deck1);
		
		Deck Deck2 = new Deck(new String[] {"Ace", "Three", "Four"}, new String[] {"Clubs", "Diamonds"}, new int[] {1, 3, 4});
		System.out.println(Deck2);
		Deck2.deal();
		System.out.println(Deck2);
		Deck2.shuffle();
		System.out.println(Deck2);
		
		Deck Deck3 = new Deck(new String[] {"Two", "Five", "Ten", "Nine"}, new String[] {"Hearts", "Clubs", "Spades"}, new int[] {2, 5, 10, 9});
		System.out.println(Deck3);
		Deck3.deal();
		System.out.println(Deck3);
		Deck3.shuffle();
		System.out.println(Deck3);
		
	}
}
