package swimC.coach.views;

public class CompetitionResultView {
   public void printCompetitionResultDetails(int CompetitionResultID, int CompetitionID, int SwimmerID,
                                             int DisciplineID, int rally, double time, int position) {
      System.out.println("Competition Result ID: " + CompetitionResultID);
      System.out.println("CompetitionID: " + CompetitionID);
      System.out.println("Swimmer ID: " + SwimmerID);
      System.out.println("Discipline ID: " + DisciplineID);
      System.out.println("Rally: " + rally);
      System.out.println("Time: " + time);
      System.out.println("Position: " + position);
      System.out.println("--------------------------------");                                       
   }
    
}