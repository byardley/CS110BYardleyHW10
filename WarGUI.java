import javax.swing.*; // Needed for swing classes
import java.awt.event.*; // needed for action listener interface
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Image; 
import javax.swing.JComponent;

/*
Ben Yardley
WAR game demonstrated with a GUI

*/

public class WarGUI extends JFrame 
{
   //declare variables   
   private final int WINDOW_WIDTH = 500; //window width
   private final int WINDOW_HEIGHT =600; //window height
   //player card that is used to set image in gui
   Card player1card;
   Card player2card;
   //states who wins and if there was a war
   String winner="";
   //set grid layout for the center 
   GridLayout centerLA = new GridLayout(3,0);
   
   
   
   
   
      
   public static void main(String[] args)
      {
          //call GUI 
          new WarGUI();
      }
   
      //GUI default con
      public WarGUI()
      {
      //create a new deck from the deck class
      Deck1 deck = new Deck1();
      //fill the deck with 52 cards
      deck.freshDeck();
      //shuffle cards
      deck.shuffle();
     
      
      //create player 1 and player 2s deck
       final Deck1 deck2 = new Deck1();
       final Deck1 deck3 = new Deck1();
      //deal deck evenly to two players
      for(int i = 0; i < 26; i++)
      {
        deck2.add(deck.getTopCard());
        deck3.add(deck.getTopCard());
      }
      //create a genearl JFrame called WarFrame
      JFrame WarFrame = new JFrame();
      //Set the window Title
      WarFrame.setTitle("Let's play War!");
      
      //Set the size of the window
      WarFrame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT); 
      
      //Specify what happens when the close button is clicked
        WarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //create a panel that contains players 1s remaining cards
        JPanel player1 = new JPanel();
        //JLabel that that shows the players remaining cards
        final JLabel player1Score = new JLabel("");
        //set text and use cardsRemaining() method from the Deck1 class
        player1Score.setText("Player 1 has : " + deck2.cardsRemaining()+ " cards remaining");
        //add label to jpanel
        player1.add(player1Score);
        //set color
        player1.setBackground(Color.GREEN);
        //set visible 
        player1Score.setVisible(true);
        
       
       
        //create the same panel as player 1 but for player 2
        JPanel player2 = new JPanel();
        final JLabel player2Score = new JLabel("");
        player2Score.setText("Player 2 has : " + deck3.cardsRemaining()+ " cards remaining");
        player2.add(player2Score);
        player2.setBackground(Color.GREEN);
        player2Score.setVisible(true);
        
      //create a new panel that will hold the image of the card that is played 
      JPanel east = new JPanel();
      final  JLabel image1 = new JLabel();
      //set the image to the label
      image1.setIcon(new ImageIcon("back.jpg"));
      //add the image label to the east panel
      east.add(image1);
        
      //create another new panel that will hold the other image  
      JPanel west = new JPanel();
      final JLabel image2 = new JLabel();
      image2.setIcon(new ImageIcon("back.jpg"));
      west.add(image2);
      
       //create new panel to hold the draw button and the text that says who won       
      JPanel center = new JPanel();
      //set the layout to be the cenerLA gridlayout which is 2,0
      center.setLayout(centerLA);
      //create a new button
      JButton playButton = new JButton("Draw Card");
      //add button to GUI
      center.add(playButton,BorderLayout.NORTH);
     // label that will show who won
      final JLabel scoreLabel = new JLabel("The Winner is....");
     
     //add to the center panel
     center.add(scoreLabel,BorderLayout.SOUTH);
     //make it visible
     playButton.setVisible(true);
     //action button
     playButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                
                //try clause that will ultimately catch the error that comes when one deck gets to 0
                try{
                
                //the play method will take both decks and automate a draw
                play(deck2,deck3);
                //set text to the cards remaining of each player
                player1Score.setText("Player 1 has : " + deck2.cardsRemaining()+ " cards remaining");
                player2Score.setText("Player 2 has : " + deck3.cardsRemaining()+ " cards remaining");
                //set text to who won or if it was a war
                scoreLabel.setText(winner);
                //set image of the card was played
                image1.setIcon(new ImageIcon(player1card.getImage()));
                image2.setIcon(new ImageIcon(player2card.getImage()));
                // shuffle decks for each play
                deck2.shuffle();
                deck3.shuffle();
               
                }
                //catch the out of bound exception
          catch (IndexOutOfBoundsException theException)  
               {
               //set the scorelabel of who won when the array list reaches 0
               if(deck2.cardsRemaining() == 0)
               {
                   scoreLabel.setText("Winner is Player 2");

               }
               else
                  scoreLabel.setText("Winner is Player 1");

   
               }
    
               }
        });      
     
     
      
        //set the positioning of each panel
        WarFrame.add(player1, BorderLayout.NORTH);
        WarFrame.add(player2, BorderLayout.SOUTH);
        WarFrame.add(center,BorderLayout.CENTER);
        WarFrame.add(east,BorderLayout.EAST);
        WarFrame.add(west,BorderLayout.WEST);
         
     
      //Display the window
      WarFrame.setVisible(true);
      
      }
     //play method that takes two decks
public void play(Deck1 deck2, Deck1 deck3)
   {
       //declare card variables    
       player1card = deck2.getTopCard();
       player2card = deck3.getTopCard();
       
      

      //if player 1s card is greater 
      if(player1card.compareTo(player2card)==1)
      {
         //add cards to player 1s deck
         deck2.add(player1card);
         deck2.add(player2card);
         //set winner text
         winner = "Player 1 Wins";
         
      }
      //if player 2s card is greater..
      else if (player1card.compareTo(player2card)==-1)
      {  
         //add cards to player 2s deck
         deck3.add(player1card);
         deck3.add(player2card);
         //set winner text
         winner = "Player 2 Wins";
      }
      //if they are equal 
      else
         {
            //if they are no cards in player 2s deck
            if(deck3.cardsRemaining() == 0)
            {
                  winner = "Player 2 is out of cards. Player 1 Wins!";
                  deck2.add(player1card);
                  deck2.add(player2card);
            }
            //if there are no cards in player 1s deck
            else if (deck2.cardsRemaining() == 0)
            {
                  winner = "Player 1 is out of cards. Player 2 Wins!";
                  deck3.add(player1card);
                  deck3.add(player2card);
            }
           
            else
            {
            //if there is a war get four more cards, two cards in the pile and two more to be compared
               Card player1War = deck2.getTopCard();
               Card player2War = deck3.getTopCard();
               Card player1Card2 = deck2.getTopCard();
               Card player2Card2 = deck3.getTopCard();
               //player1 wins war
               if(player1Card2.compareTo(player2Card2) == 1)
               {
              
               deck2.add(player1card);
               deck2.add(player1Card2);
               deck2.add(player2card);
               deck2.add(player2Card2);
               deck2.add(player1War);
               deck2.add(player2War);
               winner = "Player 1 is the winner of the War! ";
               }
               //player2 wins war
               else if (player1Card2.compareTo(player2Card2) == -1)                                        
               {
               deck3.add(player1card);
               deck3.add(player1Card2);
               deck3.add(player2card);
               deck3.add(player2Card2);
               deck3.add(player1War);
               deck3.add(player2War);
               
               winner = "Player 2 is the winner of the War! ";
               }
               //if there is another tie or WAR
               else
               {
               Card player1War2 = deck2.getTopCard();
               Card player2War2 = deck3.getTopCard();
               Card player1Card3 = deck2.getTopCard();
               Card player2Card3 = deck3.getTopCard();
                    //player 1 wins
                    if(player1Card3.compareTo(player2Card3) == 1)
                     {
                     //add war cards
                     deck2.add(player1card);
                     deck2.add(player1Card2);
                     deck2.add(player2card);
                     deck2.add(player2Card2);
                     deck2.add(player1War);
                     deck2.add(player2War);
                     deck2.add(player1War2);
                     deck2.add(player2War2);
                     deck2.add(player1Card3);
                     deck2.add(player2Card3);
                     winner = "Player 1 is the winner of double War! ";
                     }
                     //player2 wins
                     else if(player1Card3.compareTo(player2Card3) == -1)
                     {
                     
                     //add war cards
                     deck3.add(player1card);
                     deck3.add(player1Card2);
                     deck3.add(player2card);
                     deck3.add(player2Card2);
                     deck3.add(player1War);
                     deck3.add(player2War);
                     deck3.add(player1War2);
                     deck3.add(player2War2);
                     deck3.add(player1Card3);
                     deck3.add(player2Card3);  
                     winner = "Player 2 is the winner of double War! ";
                     }
            }  
            }
      }
   }   
 
      

      
   }
   
 
  
    
     
      
   

      
      