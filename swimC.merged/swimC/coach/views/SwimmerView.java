package swimC.coach.views;

public class SwimmerView {
   public void printSwimmerDetails(int SwimmerID, String SwimmerName, int SwimmerMobile, int SwimmerAge,
                                    int SwimmerDiscipline, String SwimmerCoach) {
      System.out.println("Swimmer ID: " + SwimmerID);
      System.out.println("Name: " + SwimmerName);
      System.out.println("Phone: " + SwimmerMobile);
      System.out.println("Age: " + SwimmerAge);
      String s = "";
      if (SwimmerAge < 18) {
         s += "junior";
      }
      else if (SwimmerAge >= 18) {
         s += "senior";
      }
      else {
         s += "no data";
      }
      System.out.println("Category: " + s);
      System.out.println("Discipline: " + (SwimmerDiscipline));
      System.out.println("Coach: " + SwimmerCoach);
      System.out.println("--------------------------------");                                       
   } 
}