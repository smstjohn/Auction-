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

public class Bid {
   protected String name;
   protected int currentBid;
   protected int maxBid;
   
   public Bid(String name, int currentBid, int maxBid) {
       this.name = name;
       this.currentBid = currentBid;
       this.maxBid = maxBid;
   }

   public String toString() {
       return name + "\t\t" + currentBid + "\n";
   }
   public void setName(String name) {
      this.name = name;
   }
   
   public String getName() {
      return name;
   }
   public void setCurrentBid(int currentBid) {
      this.currentBid = currentBid;
   }
   
   public int getCurrentBid() {
      return currentBid;
   }
   
   public void setMaxBid(int maxBid) {
      this.maxBid = maxBid;
   }
   
   public int getMaxBid() {
      return maxBid;
   }
   
}