package swimC.coach.models;

import java.util.ArrayList;

public class CompetitionList {
   private int id;
   private int competitionID;
   private int swimmerID;
   private ArrayList<Integer> swimmers = new ArrayList<Integer>();
   
   public int getID() {
     return id;
   }
   public void setID(int i) {
      this.id = i;
   }
   public int getCompetitionID() {
      return competitionID;
   }
   public void setCompetitionID(int i) {
      this.competitionID = i;
   }
   public int getSwimmerID() {
      return swimmerID;
   }
   public void setSwimmerID(int i) {
      this.swimmerID = i;
      addSwimmerToList(i);
   }
   public ArrayList<Integer> getSwimmers() {
      return swimmers;
   }
   public int getSwimmer(int i) {
      return swimmers.get(i);
   }
   public void addSwimmerToList(int i) {
      swimmers.add(i);
   }

}