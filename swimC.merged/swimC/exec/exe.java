package swimC.exec;

import swimC.chairman.*;
import swimC.coach.exec.*;
import java.io.*;
import java.util.*;

public class exe {

   public static void main(String[] args) throws IOException {
      
      boolean start = true;
      while (start) {
      Scanner user = new Scanner(System.in);
      System.out.println("Choose a user: ");
      System.out.println("<1> for Chairman, <2> for Treasurer, <3> for Coach");
      System.out.println("<0> for Exit");
      int answer = user.nextInt();
      
      if (answer == 1) {
         ChairmanControler c = new ChairmanControler();
         c.chairman();
      }
      
      else if (answer == 2) {
         System.out.println("Thunderstruck!!");
      }
      
      else if (answer == 3) {
         ProgramCoach.ON();
      }
      else if (answer == 0) {
         System.out.println();
         System.out.println("Goodbye");
         break;
      }
      else {
         System.out.println("Not a real option really");
         continue;
      }
      
      }
      
 
   }
}