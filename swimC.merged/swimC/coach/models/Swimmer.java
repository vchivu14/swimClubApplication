package swimC.coach.models;

import swimC.chairman.Member;

public class Swimmer extends Member {
   private String coach;

   public String getCoach() {
      return coach;
   }

   public void setCoach(String s) {
      this.coach = s;
   }

   public Swimmer(Member member) {
      super();
      this.coach = "Zidane";
   }
   
   public Swimmer() {
      
   }

   public String toString() {
      return super.getID() + " " + super.getFirstName() + " " + super.getLastName() + " " + super.getMobile() + " " + 
             super.getAge() + " " + super.getDiscipline() + " " + getCoach() + "\n";
   }
}