/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		
		Card Card1 = new Card("Queen", "Hearts", 12);
		System.out.println(Card1);
		
		Card Card2 = new Card("Ace", "Diamonds", 1);
		System.out.println(Card2);
		
		Card Card3 = new Card("Five", "Spades", 5);
		System.out.println(Card3);
		
	}
}
