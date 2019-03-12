import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	//Array code
	
	//private Card[] cards;
	
	//ArrayList code
	private ArrayList <Card> cards = new ArrayList<Card>();

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		
		//Array Code
		/*
		cards = new Card[ranks.length * suits.length];
		size = ranks.length + suits.length;
		int index = 0;
		for (int rank = 0; rank < ranks.length; rank++)
		{
			for (int suit = 0; suit < suits.length; suit++)
			{
				cards[index] = new Card(ranks[rank], suits[suit], values[rank]);
				index += 1;
			}
		}
		*/
		
		//ArrayList Code
		size = ranks.length * suits.length;
		for (int rank = 0; rank < ranks.length; rank++)
		{
			for (String suit: suits)
			{
				cards.add(new Card(ranks[rank], suit, values[rank]));
			}
		}
		
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		
		if (size == 0) return true;
		else return false;
		
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		
		Card copyValues;
		int shuffleIndex;
		
		//Array Code
		/*
		for (int i = cards.length - 1; i >= 0; i--)
		{
			int howMany = i + 1;
			shuffleIndex = (int)(Math.random() * howMany);
			copyValues = cards[shuffleIndex];
			cards[shuffleIndex] = cards[i];
			cards[i] = copyValues;
			size = cards.length;
			
		}
		*/
		
		//ArrayList Code
		for (int i = cards.size() - 1; i >= 0; i--)
		{
			shuffleIndex = (int)(Math.random() * (i +1));
			copyValues = cards.get(shuffleIndex);
			cards.add(shuffleIndex, cards.get(i));
			cards.add(i, copyValues);
			
		}
		
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {

		//Array code
		/*
		if (size == 0) return null;
		
		size -= 1;
		return cards[size];
		*/
		
		//ArrayList code
		if (size <= 0) return null;
		size -= 1;
		return cards.get(size);
		
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		
		//Array code
		/*
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards[k];
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.length - 1; k >= size; k--) {
			rtn = rtn + cards[k];
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.length) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
		*/
		
		//ArrayList code
		String rtn = "size = " + size + "\nUndealt cards: \n";
		
		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
		
	}
}
