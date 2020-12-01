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

   public Swimmer(Member member) {
      this.ID = member.getID()-1;
      this.firstName = member.getFirstName();
      this.lastName = member.getLastName();
      this.mobile = member.getMobile();
      this.age = member.getAge();
      this.disciplineID = member.getDiscipline();
      this.coach = "Zidane";
   }
   
   public Swimmer() {
      
   }

//    public String toString() {
//       return super.getID() + " " + super.getFirstName() + " " + super.getLastName() + " " + super.getMobile() + " " + 
//              super.getAge() + " " + super.getDiscipline() + " " + getCoach() + "\n";
//    }
   
   public String toString() {
      return this.ID + " " + this.firstName + " " + lastName + " " + mobile + " " + 
             age + " " + disciplineID + " " + getCoach() + "\n";
   }
   
}