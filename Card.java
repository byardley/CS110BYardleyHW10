
//this class is recylced from class which is created by Jackie Horton
//I only changed so that I could reference the images with each card
public class Card 
{     
    // Constants     
    // suits
    public final static int SPADES = 0,      
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
    // ranks
    // Cards 2 through 9 have face value
    public final static int ACE = 1,          
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    // instance variables
    private int suit;   // The suit of this card, one of the constants
                              // SPADES, HEARTS, DIAMONDS, CLUBS.
                              
    private int rank;  // The rank of this card, from 1 to 13.
                             
   /**
   * Creates a new playing card.
   * @param suit the suit value of this card.
   * @param rank the rank rank of this card.
   */
    public Card(int rank, int suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }
    
   /**
   * Creates a new playing card as exact copy of otherCard
   * @param otherCar the card to be copied
   */
    public Card(Card otherCard) 
    {
         this.rank = otherCard.rank;
         this.suit = otherCard.suit;
    }
    
   /**
   * Returns the suit of the card.
   * @return a Suit constant representing the suit value of the card.
   */
  
    public int getSuit() 
    {
      return suit;
    }
   /**
   * Returns the rank of the card.
   * @return a Rank constant representing the rank value of the card.
   */

    public int getRank() 
    {
            // Return the int that codes for this card's rank.
        return rank;
    }
    
   /**
   * Returns a description of the suit of this card.
   * @return the suit value of the card as a string.
   */
    public String getSuitAsString() 
    {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
        switch ( suit ) {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "Invalid";
        }
    }
   /**
   * Returns a description of the rank of this card.
   * @return the rank value of the card as a string.
   */
   public String getRankAsString() 
   {
        switch ( rank ) {
           case 1:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default:  return "??";
           
        }
    }
    //Method that will get an image file text given a specifc card object
    public String getImage()
    {
      if (suit == 0)
      {
         switch ( rank)
         {
           
           case 1:   return "aces.jpg";
           case 2:   return "2s.jpg";
           case 3:   return "3s.jpg";
           case 4:   return "4s.jpg";
           case 5:   return "5s.jpg";
           case 6:   return "6s.jpg";
           case 7:   return "7s.jpg";
           case 8:   return "8s.jpg";
           case 9:   return "9s.jpg";
           case 10:  return "10s.jpg";
           case 11:  return "jacks.jpg";
           case 12:  return "queens.jpg";
           case 13:  return "kings.jpg";
           default:  return "??";
         }
      }
      else if (suit == 1)
      {
         switch (rank)
         {
           case 1:   return "aceh.jpg";
           case 2:   return "2h.jpg";
           case 3:   return "3h.jpg";
           case 4:   return "4h.jpg";
           case 5:   return "5h.jpg";
           case 6:   return "6h.jpg";
           case 7:   return "7h.jpg";
           case 8:   return "8h.jpg";
           case 9:   return "9h.jpg";
           case 10:  return "10h.jpg";
           case 11:  return "jackh.jpg";
           case 12:  return "queenh.jpg";
           case 13:  return "kingh.jpg";
           default:  return "??";
         }
      } 
      else if (suit == 2)
      {
         switch (rank)
         {
           case 1:   return "aced.jpg";
           case 2:   return "2d.jpg";
           case 3:   return "3d.jpg";
           case 4:   return "4d.jpg";
           case 5:   return "5d.jpg";
           case 6:   return "6d.jpg";
           case 7:   return "7d.jpg";
           case 8:   return "8d.jpg";
           case 9:   return "9d.jpg";
           case 10:  return "10d.jpg";
           case 11:  return "jackd.jpg";
           case 12:  return "queend.jpg";
           case 13:  return "kingd.jpg";
           default:  return "??";
         }
      }
      else
      {
         switch (rank)
         {
           case 1:   return "acec.jpg";
           case 2:   return "2c.jpg";
           case 3:   return "3c.jpg";
           case 4:   return "4c.jpg";
           case 5:   return "5c.jpg";
           case 6:   return "6c.jpg";
           case 7:   return "7c.jpg";
           case 8:   return "8c.jpg";
           case 9:   return "9c.jpg";
           case 10:  return "10c.jpg";
           case 11:  return "jackc.jpg";
           case 12:  return "queenc.jpg";
           case 13:  return "kingc.jpg";
           default:  return "??";
         }
      } 
             
   }         
   /**
   * Returns a description of this card.
   * @return the name of the card.
   */

    public String toString() 
    {
        return getRankAsString() + " of " + getSuitAsString();
    }
    
   /**
   * Compares two cards to determine if they have the same value.
   * @param card the other card
   * @return true if the two cards have the same rank and suitvalues,
   * falseotherwise.
   */
   public boolean equals(Card otherCard ) 
   {
      if ( ( rank != otherCard.rank ) || ( suit != otherCard.suit ) )
         return false;
      else
         return true;
   }
   
   ///I created this method too. this method just compares two cards and returns 0,-1,1 if they are equal, less than, or greater than
   
   public int compareTo(Card otherCard)
   {
      if (rank > otherCard.rank)
      {
       return 1;
      }
      else if (rank < otherCard.rank)
      {
      return -1;
      }
      else
      
      {
      return 0;
      }   
   }
  
}



    

