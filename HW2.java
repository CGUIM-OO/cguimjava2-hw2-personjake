import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author B0544233 陳冠蓁 ，首先先是輸入總共有N副牌，之後把N變成INTEGER後， 利用class
 *         Deck裡的Deck方法，實體化deck, 然後利用deck去用Class Deck 裡的printdeck方法，把所有牌印出來。
 * 
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards
	 *            所有的牌
	 * @param nDeck
	 *            總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank,
						checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description:(一)Deck方法中建立一個ArrayList-cards，之後作3個迴圈分別為 1.有幾副牌deck，讓他巢狀副牌
 * 2.suit是花色 3.rank是數字 迴圈功能為 利用Class Card 實體化card，進入Class Card 裡的Card 方法，
 * 之後將實體化後的card放入Arraylist-cards
 * 
 * (二)printDeck方法是將 Arraylist-cards 利用 Enhanced for Loop 印出值來 (Class
 * Card裡面的printCard)
 * 
 * (三)getAllCards方法回傳 Arraylist-cards
 */
class Deck {
	private ArrayList<Card> cards;

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();

		for (int deck = 1; deck <= nDeck; deck++) {
			for (int suit = 1; suit <= 4; suit++) {
				for (int rank = 1; rank <= 13; rank++) {
					Card card = new Card(suit, rank);
					cards.add(card);

				}
			}

		}
	}

	public void printDeck() {

		for (Card allcards : cards) {
			allcards.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: 先設不可變的suit 和 rank (suit為花色、rank為數字1-13) (一)printCard方法中是將
 * 原本suit的1234轉換為真正的花色，還有將rank中的1改為Ace (二)Card 方法是個constructor
 * (三)getSuit()為傳回suit值 (四)getRank()為傳回rank值
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace

		if (suit == 1) {
			if (suit == 1 && rank == 1) {
				System.out.println("clubs" + "," + "Ace");
			} else {
				System.out.println("clubs" + "," + rank);
			}

		} else if (suit == 2)

		{
			if (suit == 2 && rank == 1) {
				System.out.println("Diamonds" + "," + "Ace");
			} else {
				System.out.println("Diamonds" + "," + rank);
			}
		} else if (suit == 3) {
			if (suit == 3 && rank == 1) {
				System.out.println("Hearts" + "," + "Ace");
			} else {
				System.out.println("Hearts" + "," + rank);
			}
		}

		else if (suit == 4) {
			if (suit == 4 && rank == 1) {
				System.out.println("Spades" + "," + "Ace");
			} else {
				System.out.println("Spades" + "," + rank);
			}
		}
	}

	/**
	 * @param s
	 *            suit
	 * @param r
	 *            rank
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit,
	// 10 for rank)
	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}