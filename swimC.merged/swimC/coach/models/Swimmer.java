package swimC.coach.models;

public class Swimmer extends Member {
   
   public String toString() {
      return super.getID() + " " + super.getName() + " " + super.getMobile() + " " + 
             super.getAge() + " " + super.getDiscipline() + " " + super.getCoach();
   }
}