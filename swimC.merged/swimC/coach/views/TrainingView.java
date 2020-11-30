package swimC.coach.views;

public class TrainingView {
   public void printTrainingDetails(int TrainingResultID, int SwimmerID, int DisciplineID, int rally, double time) {
      System.out.println("Training Result ID: " + TrainingResultID);
      System.out.println("Swimmer ID: " + SwimmerID);
      System.out.println("Discipline ID: " + DisciplineID);
      System.out.println("Rally: " + rally);
      System.out.println("Time: " + time);
      System.out.println("--------------------------------");                                       
   }
    
}