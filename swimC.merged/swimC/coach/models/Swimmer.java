package swimC.coach.models;

import swimC.chairman.Member;

public class Swimmer extends Member {
   private int ID;
   private String firstName;
   private String lastName;
   private String mobile;
   private int age;
   private int disciplineID;
   private String coach;

   public String getCoach() {
      return coach;
   }

   public void setCoach(String s) {
      this.coach = s;
   }
   
   public int getDisciplineID() {
      return disciplineID;
   }

   public void setDisciplineID(int i) {
      this.disciplineID = i;
   }

   public Swimmer(Member member) {
      this.ID = member.getID();
      this.firstName = member.getFirstName();
      this.lastName = member.getLastName();
      this.mobile = member.getMobile();
      this.age = member.getAge();
      this.coach = "Zidane";
   }
   
   public Swimmer() {
      
   }
   
   public String toString() {
      return ID + " " + firstName + " " + lastName + " " + mobile + " " + 
             age + " " + disciplineID + " " + getCoach() + "\n";
   }
   
}