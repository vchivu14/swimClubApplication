package swimC.exec;

import swimC.chairman.*;
import swimC.coach.exec.*;
import java.io.*;
import java.util.*;

public class exe {

   public static void main(String[] args) throws FileNotFoundException {
      
      
      Scanner user = new Scanner(System.in);
      
      System.out.println("Choose a user: 1 or 2");
      int answer = user.nextInt();
      
      // if authenticated as coach
      if (answer == 1) {
         ProgramCoach.ON();
      }
      
      else if (answer == 2) {
         ChairmanControler c = new ChairmanControler();
         c.chairman();
      }
 
   }
}