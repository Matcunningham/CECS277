/* Mathew Cunningham
   September 15, 2017
   Purpose: This program is used to simulate the card game War.
   Inputs: None
   Output: A simulation of the card game War.
*/
package warproject;
/**
 * Utilizes the Card and Deck classes to simulate a game of War.
 */
public class War {
    
    public static void main(String[] args)
    {
        System.out.println("Let's play WAR!!!");
        Deck myDeck = new Deck();
        Deck player1 = new Deck(); // player1 hand   
        Deck player2 = new Deck(); // player2 hand
        Deck warDeck = new Deck(); // Stores cards played during war.
        warDeck.makeEmpty();
        myDeck.shuffle();
        myDeck.deal(player1, player2);
        Card p1;
        Card p2;
        
        while(!(player1.isEmpty() || player2.isEmpty()))
        {
            p1 = player1.play();
            p2 = player2.play();
            System.out.println("Player 1 plays " + p1); 
            System.out.println("Player 2 plays " + p2); 
            if (p1.getValue() > p2.getValue())
            {
                player2.add(p2);
                player2.add(p1);
                System.out.println("Player 1 wins round");
            }
            else if(p1.getValue() < p2.getValue())
            {
                player1.add(p1);
                player1.add(p2);
                System.out.println("Player 2 wins round");
            }
            else
            {
                while(p1.getValue() == p2.getValue()) // War case
                {
                    System.out.println("WAR!!!");                    
                    if (player1.numbOfCards() < 4 || player2.numbOfCards() < 4)
                    {
                        if(player1.numbOfCards() < 4) 
                        {
                            while(!player1.isEmpty())
                            {
                                warDeck.add(player1.play());
                                warDeck.add(player2.play());
                                System.out.println("War card for player 1 is xx");
                                System.out.println("War card for player 2 is xx");                                
                            }
                            System.out.println("Player 1 ran out of cards");                            
                            break; // ends game if player 1 runs out of cards.
                        }
                        else
                        {
                            while(!player2.isEmpty())
                            {
                                warDeck.add(player1.play());
                                warDeck.add(player2.play());
                                System.out.println("War card for player 1 is xx");
                                System.out.println("War card for player 2 is xx");                                
                            }
                            System.out.println("Player 2 ran out of cards");
                            break; // ends game if player 2 runs out of cards.
                        }
                    }

                    else
                    {
                        warDeck.add(p1);
                        warDeck.add(p2); // Adds initial war cards to war deck.
                        for (int i = 0; i < 3; i++)
                        {
                            p1 = player1.play();
                            p2 = player2.play();
                            warDeck.add(p2);
                            warDeck.add(p1);
                            System.out.println("War card for player 1 is xx");
                            System.out.println("War card for player 2 is xx");
                        }
                        p1 = player1.play();
                        p2 = player2.play();
                        System.out.println("War card for player 1 is " + p1);
                        System.out.println("War card for player 2 is " + p2);
                        if (p1.getValue() > p2.getValue())
                        {
                            player2.add(p1);
                            player2.add(p2);
                            while(!warDeck.isEmpty())
                            {
                                player2.add(warDeck.play());
                            }
                            System.out.println("Player 1 wins war round");
                        }
                        else if (p1.getValue() < p2.getValue())
                        {
                            player1.add(p2);
                            player1.add(p1);
                            while(!warDeck.isEmpty())
                            {
                                player1.add(warDeck.play());
                            }
                            System.out.println("Player 2 wins war round");
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println("GAME OVER!!!");
        if (player1.isEmpty())
        {
            System.out.println("Player 1 wins the game");
        }
        else
        {
             System.out.println("Player 2 wins the game");       
        }
    }
}
