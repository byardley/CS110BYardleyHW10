import java.util.Random;
import java.util.ArrayList;
//this class is in large re used from jackies example in week 7
public class Deck1 
{
   //declare variables
   final int CARDS_IN_DECK = 52;
   ArrayList<Card> deck;
   //default constructor
   public Deck1()
   {
   //create an empty deck
            deck = new ArrayList<Card>();

   }
   //fresh deck that fills the newly created deck with 52 unique cards
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
      
      
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            //add the cards to the array list
           deck.add(new Card(r,s));
         }
      }
     
   
   }
   
   //add Card object method
   public void add(Card aCard)
   {
      deck.add(aCard);
   }
   //get the top card card object
   public Card getTopCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   //get the size of the cards
   public int cardsRemaining()
   {  
      return deck.size();
   }
   //shuffly the deck method
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   // by rank only
}
