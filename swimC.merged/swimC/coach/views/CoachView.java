package swimC.coach.views;

import java.util.Scanner;

public class CoachView {
   static Scanner answer;
   static int option;
   static String optionMenu;
   
   public static int startMenu() {
      answer = new Scanner(System.in);
      System.out.println();
      System.out.println("Type: ");
      System.out.println("<1> to show Members: ");
      System.out.println("<2> to show Swimmers: ");
      System.out.println("<3> to show Disciplines: ");
      System.out.println("<4> to show Competitions: ");
      System.out.println("<5> to show Training Results: ");
      System.out.println("<6> to show Competition Results: ");
      System.out.println("<0> to exit: ");
      option = answer.nextInt();
      return option;   
   }
   
   public static int chooseCompetition() {
      answer = new Scanner(System.in);
      System.out.println();
      System.out.println("In order to see a Competition List ");
      System.out.println("type the ID of one the Competions listed above: ");
      System.out.println("Or <0> to exit: ");
      option = answer.nextInt();
      return option;   
   }
   
   public static int chooseSwimmer() {
      answer = new Scanner(System.in);
      System.out.println();
      System.out.println("Would you like to reassign a discipline for a specific Swimmer?");
      System.out.println("type the ID of one of the Swimmers listed above: ");
      System.out.println("Or <0> to exit: ");
      option = answer.nextInt();
      return option;   
   }
   
   public static int chooseDiscipline() {
      answer = new Scanner(System.in);
      System.out.println();
      System.out.println("What Discipline you want to Reassign to this Swimmer?");
      System.out.println("type the ID of one the Disciplines listed above: ");
      System.out.println("Or <0> to exit: ");
      option = answer.nextInt();
      return option;   
   }
   
   public static String saveChanges() {
      answer = new Scanner(System.in);
      System.out.println();
      System.out.println("Do you want to save your changes, or discard them?");
      System.out.println("<y> for Yes, <n> for No");
      optionMenu = answer.next();
      return optionMenu;   
   }
         
}
