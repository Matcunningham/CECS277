
package warproject;
/**
   A card has a rank and a suit.
*/
public class Card 
{
    private String rank;
    private String suit;
    public static  final String RANKS[] = {"2", "3", "4", "5", "6", "7", "8", "9",
                                          "10", "Jack", "Queen", "King", "Ace" };
    /**
        Constructs a default card with no rank or suit.
    */
    public Card()
    {
        rank = "none";
        suit = "none";
    }
    /**
     * Constructs a card with given rank and suit.
     * @param r the rank of the card.
     * @param s the suit of the card.
     */
    public Card(String r, String s)
    {
        rank = r;
        suit = s;
    }
    /**
     * Gets the rank of the card.
     * @return the rank of the card.
     */
    public String getRank()
    {
        return rank;
    }
    /**
     * Gets the suit of the card.
     * @return the suit of the card.
     */
    public String getSuit()
    {
        return suit;
    }
    /**
     * Gets the value of the card as an integer.
     * @return the value of the card.
     */
    public int getValue()
    {       
	for (int i = 0; i < 13; i++)
	{
		if (rank.equals(RANKS[i]))
		{
			return i + 2; // returns index number plus two to get card value
		}
	}
        // Should never reach this point.
        return 1;
    }
    /**
     * Overrides toString method
     * @return rank and suit as a string.
     */
    public String toString()
    {
        return rank + " of " + suit;
    }
}
