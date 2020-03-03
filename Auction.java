/**Program #48 on page 158
This program will let us see how a stack is used in an actual application. 
Using a stack to keep track of an online auction can be really helpful as the ADT of the data structure maps well to the actual bidding process. 
Note: Create a class called Bid that contains the user's name, current bid, and max bid. Then, you can store items of the class Bid on your stack. 
You should only have one stack in your program that manages objects of type Bid. Let the stack do the bulk of the work in this program.

code used in this assignment was derived from the book, videos provided for this assignment and 
reading through the discussion board posts for this week 

*/

import ch02.stacks.*;
import support.LLNode;
import java.util.Scanner;

public class Auction {
   public static void main(String[] args) {
   
      LinkedStack<Bid> auctionBids = new LinkedStack<>();
      char c;
      
      Scanner keyboard = new Scanner(System.in);
     do {
         //ask user for input
         System.out.println("Please enter the bidder's name: ");
         String name = keyboard.nextLine();
         
         System.out.println("Please enter the bidder's maxBid: ");
         int newBid = keyboard.nextInt();
         
         //check to see if there's any previous bids, if not set to current bid and set bid to $1
         if (auctionBids.isEmpty()) {
            
            //updates to current values as new bidders are entered by user
            Bid createdBid = new Bid (name, 1, newBid);
            auctionBids.push(createdBid);
            System.out.println("New High Bidder: \t\t\t\t\t\t\t\t\t High Bid\t\t\t\t\t\t\t\t\t Max Bid " );
            System.out.println(auctionBids.top().getName() + " \t\t\t\t\t\t\t\t\t\t\t\t\t\t " + auctionBids.top().getCurrentBid() + 
                                " \t\t\t\t\t\t\t\t\t\t\t " + auctionBids.top().getMaxBid() );
            
            //System.out.println("New High Bidder: " + auctionBids.top().getName() + " High Bid " + auctionBids.top().getCurrentBid() + 
                              //  " Max Bid " + auctionBids.top().getMaxBid() );
            System.out.println();               
            
         //if bid is less than current bid, discard it
         } else if (newBid <= auctionBids.top().getCurrentBid()) {
         
            System.out.println("No Change : \t\t\t\t\t\t\t\t\t High Bid \t\t\t\t\t\t\t\t\t Max Bid " );
            System.out.println(auctionBids.top().getName() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + auctionBids.top().getCurrentBid() + 
                                " \t\t\t\t\t\t\t\t\t\t\t " + auctionBids.top().getMaxBid() );
            
            //System.out.println("No Change : " + auctionBids.top().getName() + " High Bid " + auctionBids.top().getCurrentBid() + 
                               // " Max Bid " + auctionBids.top().getMaxBid() );
            System.out.println();               
         
         //if new bid is greater than current high bid, and less than current maxBid, then match previous bid to new bid and discard new bid
         } else if (newBid > auctionBids.top().getCurrentBid() && newBid < auctionBids.top().getMaxBid() ) {
            Bid createdBid = new Bid (auctionBids.top().getName(), newBid, auctionBids.top().getMaxBid() );
            auctionBids.push(createdBid);
            System.out.println("High Bid Increased: \t\t\t\t\t\t\t\t\t High Bid \t\t\t\t\t\t\t\t\t Max Bid " );
            System.out.println(auctionBids.top().getName() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + auctionBids.top().getCurrentBid() + 
                                " \t\t\t\t\t\t\t\t\t\t\t " + auctionBids.top().getMaxBid() );
            
            
            //System.out.println("High Bid Increased: " + auctionBids.top().getName() + " High Bid " + auctionBids.top().getCurrentBid() + 
              //                  " Max Bid " + auctionBids.top().getMaxBid() );
            System.out.println();               

         //if new bid is greater than maxBid, new bidder becomes high bidder, and high bidder becomes previous max bid + 1 
         } else if (newBid > auctionBids.top().getMaxBid() ) {
            Bid createdBid = new Bid (name, auctionBids.top().getMaxBid() + 1, newBid);
            auctionBids.push(createdBid);
            System.out.println("New High Bidder:\t\t\t\t\t\t\t\t\t High Bid \t\t\t\t\t\t\t\t\t Max Bid ");
            System.out.println(auctionBids.top().getName() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + auctionBids.top().getCurrentBid() + 
                                " \t\t\t\t\t\t\t\t\t\t\t " + auctionBids.top().getMaxBid() );

            //System.out.println("New High Bidder: " + auctionBids.top().getName() + " High Bid " + auctionBids.top().getCurrentBid() + 
                                //" Max Bid " + auctionBids.top().getMaxBid() );
            System.out.println();               
         }

         System.out.println("Do you want to enter a new bidder? [Y/N] ");
         c = keyboard.next().charAt(0);
         keyboard.nextLine();
   
     } while (c == 'Y'|| c == 'y' );
         System.out.println();               
         System.out.println("These are the final results of the auction. The top value is the winner!" );               
      do {
         System.out.println(auctionBids.top().getName() + "\t" + auctionBids.top().getCurrentBid() ); 
         auctionBids.pop();
         
      } while(! auctionBids.isEmpty() );
   }
}