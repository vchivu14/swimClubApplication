package swimC.exec;

import swimC.chairman.*;
import swimC.coach.exec.*;
import java.io.*;
import java.util.*;

public class exe {

   public static int chooseOption() {
      answer = new Scanner(System.in);
      System.out.println("Choose a user: ");
      System.out.println("<1> for Chairman, <2> for Treasurer, <3> for Coach");
      System.out.println("<0> for Exit");
      try {
         option = answer.nextInt();
      }
      catch (Exception e) {
         option = -1; 
         System.out.println("...");
      }
      return option;     
   }

   static Scanner answer;
   static int option;
   static int tries = 3;
   
   public static void main(String[] args) throws IOException {
     
      boolean start = true;
      while (start) {
      
      if (tries == 0) {
         System.out.println("Too many tries!");
         break;  
      }
      option  = chooseOption();
      
      if (option == 1) {
         ChairmanControler c = new ChairmanControler();
         c.chairman();
      }
      
      else if (option == 2) {
         System.out.println("Thunderstruck!!");
      }
      
      else if (option == 3) {
         ProgramCoach.ON();
      }
      else if (option == 0) {
         System.out.println();
         System.out.println("Goodbye");
         break;
      }
      else if (option == -1) {
         System.out.println("Something went wrong!");
                            System.out.println("----------------------");
                            System.out.println("Let's try again!");
                            System.out.println();
                            tries--;
                            continue;
      } else {
         System.out.println("Please enter one of the following");
                            System.out.println("----------------------");
                            System.out.println();
                            tries--;
                            continue;
      
      }
      
      }
 
   }
}