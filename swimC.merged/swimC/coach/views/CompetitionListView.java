package swimC.coach.views;

import java.util.ArrayList;

public class CompetitionListView {
   
   public void printCompetitionListDetails(int CompetitionListID, int CompetitionID, ArrayList<Integer> swimmers) {
      System.out.println("Competition List ID: " + (CompetitionListID));
      System.out.println("Competition ID: " + (CompetitionID));
      for (int i = 0; i < swimmers.size(); i++) {
         System.out.println("SwimmerID :" + swimmers.get(i));  
      }
      System.out.println("--------------------------------");                                       
   }
    
}