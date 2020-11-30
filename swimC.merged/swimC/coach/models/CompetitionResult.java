package swimC.coach.models;

public class CompetitionResult extends Result {
   private int position;
   private int competitionID;
   
   public int getCompetitionID() {
      return this.competitionID;
   }
   public void setCompetitionID(int i) {
      this.competitionID = i;
   }
   public int getPosition() {
      return position;
   }
   public void setPosition(int i) {
      this.position = i;
   }

}