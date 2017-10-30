import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author B0544233 ���a� �A�������O��J�`�@��N�ƵP�A�����N�ܦ�INTEGER��A �Q��class
 *         Deck�̪�Deck��k�A�����deck, �M��Q��deck�h��Class Deck �̪�printdeck��k�A��Ҧ��P�L�X�ӡC
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
	 *            �Ҧ����P
	 * @param nDeck
	 *            �`�@���X�ƵP
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
 * Description:(�@)Deck��k���إߤ@��ArrayList-cards�A����@3�Ӱj����O�� 1.���X�ƵPdeck�A���L�_���ƵP
 * 2.suit�O��� 3.rank�O�Ʀr �j��\�ର �Q��Class Card �����card�A�i�JClass Card �̪�Card ��k�A
 * ����N����ƫ᪺card��JArraylist-cards
 * 
 * (�G)printDeck��k�O�N Arraylist-cards �Q�� Enhanced for Loop �L�X�Ȩ� (Class
 * Card�̭���printCard)
 * 
 * (�T)getAllCards��k�^�� Arraylist-cards
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
 * Description: TODO: ���]���i�ܪ�suit �M rank (suit�����Brank���Ʀr1-13) (�@)printCard��k���O�N
 * �쥻suit��1234�ഫ���u�������A�٦��Nrank����1�אּAce (�G)Card ��k�O��constructor
 * (�T)getSuit()���Ǧ^suit�� (�|)getRank()���Ǧ^rank��
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