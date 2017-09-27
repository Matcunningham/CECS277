package warproject;
import java.util.*;
/**
 *  A Deck is a collection of cards.
 */
public class Deck 
{
    ArrayList<Card> cardStore = new ArrayList<Card>();
    String suits[] = {"Spades", "Clubs", "Hearts", "Diamonds"};
    /**
     * Constructs a full deck of 52 cards.
     */
    public Deck()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 13; j++)
            {
                Card tempCard = new Card(Card.RANKS[j], suits[i]);
                cardStore.add(tempCard);
            }
        }
    }
    /**
     * Clears cards to make an empty deck.
     */
    public void makeEmpty()
    {
        cardStore.clear();
    }
    /**
     * Returns the number of cards in the deck.
     * @return the number of cards in the deck.
     */
    public int numbOfCards()
    {
        return cardStore.size();
    }
    /**
     * Shuffles the deck twice.
     */
    public void shuffle()
    {
        Collections.shuffle(cardStore);
        Collections.shuffle(cardStore);
    }
    /**
     * Removes the card on top of the deck and returns it.
     * @return the card on top of the deck.
     */
    public Card play()
    {
        return cardStore.remove(0);
    }
    /**
     * Adds a card to the bottom of the deck.
     * @param a any card
     */
    public void add(Card a)
    {
        cardStore.add(a);
    }
    /**
     * Returns true if the deck is empty.
     * @return true if the deck is empty.
     */
    public boolean isEmpty()
    {
        return cardStore.isEmpty();
    }
    /**
     * Deals all of the cards to two players.
     * @param p1 a deck, first players hand.
     * @param p2 a deck, second players hand.
     */
    public void deal(Deck p1, Deck p2)
    {
        p1.makeEmpty();
        p2.makeEmpty(); // Clears decks
        Card copyCard;
        while(this.cardStore.size() >= 2)
        {
            copyCard = cardStore.remove(0); // Deals from main deck
            p1.add(copyCard); // Adds dealt card to first players hand
            copyCard = cardStore.remove(0);
            p2.add(copyCard);
        }
    }
}
